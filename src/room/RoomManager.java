package room;

import characters.Person;

import java.io.Serializable;
import java.util.Iterator;

public class RoomManager implements Serializable {
    private Room current = Temple.getInstance();
    private static RoomManager instance;
    private RoomManager() {
        this.current.showMap();
        this.current.spawnCharacters();
    }
    public static RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }
    public void end() {
        System.exit(0);
    }
    public void switchRoom(TypeOfRoom room) {
        if (room != this.current.getRoomType()) {
            this.current.hideMap();
            if (this.current instanceof Market) {
                var market = (Market)this.current;
                market.getMerchant().terminateOffer();
            }
            if (room == TypeOfRoom.BATTLEGROUND) {
                this.current.deleteCharacters(true);
                this.current = Battleground.getInstance();
                this.current.showMap();
                this.current.spawnCharacters();
            } else if (room == TypeOfRoom.MARKET) {
                this.current.deleteCharacters(true);
                this.current = Market.getInstance();
                this.current.showMap();
                this.current.spawnCharacters();
            } else if (room == TypeOfRoom.TEMPLE) {
                this.current.deleteCharacters(true);
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
