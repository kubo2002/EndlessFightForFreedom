package characters;

import inventory.Item;
import room.Room;
import java.util.HashMap;

public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    public Merchant(TypeOfPerson type, Room currentRoom) {
        super(TypeOfPerson.MERCHANT, currentRoom);
        this.offer = new HashMap<>();
    }

    public HashMap<Item, Double> getOffer() {
        return this.offer;
    }

}
