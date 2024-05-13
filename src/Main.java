import inventory.Inventory;
import room.Battleground;
import room.Market;
import room.ScoreBoard;

public class Main {
    public static void main(String[] args) {
        var room = new Market();
        room.showMap();
        room.spawnCharacters();

        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();
    }


}