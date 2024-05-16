package room;

import characters.Person;
import inventory.Item;

import java.util.Iterator;

public class RoomManager {
    private Room current = Temple.getInstance();
    private static final RoomManager INSTANCE = new RoomManager();
    private RoomManager() {
        this.current.showMap();
        this.current.spawnCharacters();
    }
    public static RoomManager getInstance() {
        return INSTANCE;
    }
    public void switchRoom(TypeOfRoom room) {
        if (room != this.current.getRoomType()) {
            this.current.hideMap();
            if (this.current instanceof Market) {
                var market = (Market)this.current;
                market.getMerchant().terminateOffer();
            }
            if (room == TypeOfRoom.BATTLEGROUND) {
                this.deleteCharacters();
                this.current = Battleground.getInstance();
                this.current.showMap();
                this.current.spawnCharacters();
            } else if (room == TypeOfRoom.MARKET) {
                this.deleteCharacters();
                this.current = Market.getInstance();
                this.current.showMap();
                this.current.spawnCharacters();
            } else if (room == TypeOfRoom.TEMPLE) {
                this.deleteCharacters();
                this.current = Temple.getInstance();
                this.current.showMap();
                this.current.spawnCharacters();
            }
        }
    }

    private void deleteCharacters() {
        Iterator<Person> characters = this.current.getSpawnedCharacters().iterator();

        while (characters.hasNext()) {
            Person p = characters.next();
            p.hide();
            characters.remove();
            p = null;
        }
    }

    public void showDialog() {
        DialogWindow dialog = DialogWindow.getInstance();
        if (!dialog.isOn()) {
            dialog.showDialogWindow();
        }
    }
}
