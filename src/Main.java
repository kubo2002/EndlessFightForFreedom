import characters.Player;
import inventory.Inventory;
import room.Room;
import room.TypeOfRoom;

public class Main {
    public static void main(String[] args) {
        Room room = new Room(TypeOfRoom.BATTLEGROUND);
        room.showMap();

        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();
        
    }

}