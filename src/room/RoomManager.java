package room;

import java.util.HashMap;

public class RoomManager {
    private Room current;
    private static RoomManager instance;
    private HashMap<TypeOfRoom, Room> rooms;
    private RoomManager() {
        this.rooms = new HashMap<>();
        this.rooms.put(TypeOfRoom.BATTLEGROUND, Battleground.getInstance());
        this.rooms.put(TypeOfRoom.MARKET, Market.getInstance());
        this.rooms.put(TypeOfRoom.TEMPLE, Temple.getInstance());

        this.current = this.rooms.get(TypeOfRoom.TEMPLE);
        this.current.showMap();
        this.current.spawnCharacters();
    }
    public static RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }
    public void newInstance() {
        instance = null;
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

            this.current.deleteCharacters();
            this.current = this.rooms.get(room);
            this.current.showMap();
            this.current.spawnCharacters();

        }
    }
    public void showDialog() {
        DialogWindow dialog = DialogWindow.getInstance();
        if (!dialog.isOn()) {
            dialog.showDialogWindow();
        }
    }
}
