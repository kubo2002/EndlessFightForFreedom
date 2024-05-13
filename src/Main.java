import inventory.Inventory;
import room.Battleground;
import room.Market;

public class Main {
    public static void main(String[] args) {
        var room = new Battleground();
        room.showMap();
        room.spawnCharacters();


        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();
    }


}