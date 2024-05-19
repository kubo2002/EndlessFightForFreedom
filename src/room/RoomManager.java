package room;

import room.rooms.Battleground;
import room.rooms.Market;
import room.rooms.Temple;
import screens.DialogWindow;

import java.util.HashMap;

/**
 * Singleton RoomManager spravuje zmenu miestnosti v hre.
 *
 * @autor Jakub Gubany
 */
public class RoomManager {
    private Room current;
    private static RoomManager instance;
    private HashMap<TypeOfRoom, Room> rooms;

    /**
     * Privatny konstruktor triedy RoomManager.
     */
    private RoomManager() {
        this.rooms = new HashMap<>();
        this.rooms.put(TypeOfRoom.BATTLEGROUND, Battleground.getInstance());
        this.rooms.put(TypeOfRoom.MARKET, Market.getInstance());
        this.rooms.put(TypeOfRoom.TEMPLE, Temple.getInstance());

        this.current = this.rooms.get(TypeOfRoom.TEMPLE);
        this.current.showMap();
        this.current.spawnCharacters();
    }
    /**
     * Ziska instanciu triedy RoomManager.
     *
     * @return instancia triedy RoomManager
     */
    public static RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }
    /**
     * Vytvori novu instanciu triedy RoomManager.
     */
    public void newInstance() {
        instance = null;
    }
    /**
     * Ukonci beh hry.
     */
    public void end() {
        System.exit(0);
    }
    /**
     * Prepnutie do inej miestnosti.
     *
     * @param room typ miestnosti, do ktorej sa ma prepnut
     */
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
    /**
     * Zobrazi dialógove okno v hre.
     */
    public void showDialog() {
        DialogWindow dialog = DialogWindow.getInstance();
        if (!dialog.isOn()) {
            dialog.showDialogWindow();
        }
    }
}
