package room;

import characters.Player;

public class RoomManager {
    private Battleground battleground;
    private Market market;
    private Room temple;
    private Room current;
    private Player player;
    private DialogWindow dialog;
    public RoomManager() {
        this.battleground = new Battleground(this);
        this.dialog = new DialogWindow(this);
        this.temple = new Temple(this);
        this.temple.showMap();
        //this.temple.setPlayer(this.player);
        this.temple.spawnCharacters();
    }

    public void switchRoom(TypeOfRoom room) {
        if (room == TypeOfRoom.BATTLEGROUND) {
            System.out.println("battleGround");
            this.temple = new Market(this);
            this.temple.showMap();
            //this.player.setCurrentRoom(this.current);
            //this.current.setPlayer(this.player);
            this.temple.spawnCharacters();
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
