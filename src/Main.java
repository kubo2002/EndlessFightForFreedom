import inventory.Inventory;
import room.Room;

public class Main {
    public static void main(String[] args) {
        Room room = new Room();
        room.showMap();
        Plocha plocha = new Plocha();

        Inventory inventory = new Inventory();
        inventory.drawInventoryOnScreen();

    }

}