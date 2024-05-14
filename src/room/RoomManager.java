package room;

import characters.Player;

public class RoomManager {
    private Battleground battleground;
    private Market market;
    private Temple temple;
    private Room current;
    private Player player;
    private DialogWindow dialog;
    public RoomManager() {
        this.battleground = new Battleground(this);
        this.dialog = new DialogWindow(this);
        this.market = new Market(this);
        this.temple = new Temple(this);
        this.temple.showMap();
        this.player = new Player(1, 1, this.temple);
        this.temple.setPlayer(this.player);
        this.temple.spawnCharacters();
        this.current = this.temple;
    }

    public void switchRoom(TypeOfRoom room) {
        if (room == TypeOfRoom.BATTLEGROUND) {
            System.out.println("battleGround");
        } else if (room == TypeOfRoom.MARKET) {
            System.out.println("market");
        } else if (room == TypeOfRoom.TEMPLE) {
            System.out.println("temple");
        }
    }

    public void showDialog() {
        if (!this.dialog.isOn()) {
            this.dialog.showDialogWindow();
            this.dialog = new DialogWindow(this);
        }
    }
}
