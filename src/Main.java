import inventory.Inventory;
import room.Battleground;
import room.Market;
import room.Room;
import room.TypeOfRoom;

public class Main {
    public static void main(String[] args) {
        Room room = new Market();
        room.showMap();

        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();
    }


}