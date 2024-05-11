package characters;

import inventory.Item;
import room.Room;
import java.util.HashMap;

public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    private int positionX;
    private int positionY;

    public Merchant(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.MERCHANT, currentRoom);
        super.setPosition(positionX, positionY);
        this.offer = new HashMap<>();
        this.positionX = positionX;
        this.positionY = positionY;

    }

    public HashMap<Item, Double> getOffer(int x, int y) {
        int clickedX = (x - super.getCurrentRoom().getPositionX()) / super.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();
        int clickedY = (y - super.getCurrentRoom().getPositionY()) / super.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();

        if (clickedX == this.positionX && clickedY == this.positionY) {
            return this.offer;
        } else {
            return null;
        }
    }

}
