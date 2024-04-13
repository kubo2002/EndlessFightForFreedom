import characters.Player;
import inventory.Inventory;
import room.Room;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        room.showMap();

        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();

        Player player = new Player(50, 50);
    }

}