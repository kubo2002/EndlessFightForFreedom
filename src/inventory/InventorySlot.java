package inventory;

import fri.shapesge.Image;
import fri.shapesge.Manager;
import java.util.Optional;

public class InventorySlot {
    private Optional<Item> item;
    private final int lengthOfTile = 90;
    private Image image;
    private int countOfItem; // number of same items in same slot
    private int positionX;
    private int positionY;
    private Manager manager;
    private boolean isInventory;

    public InventorySlot() {
        this.item = Optional.empty();
        this.countOfItem = 0;
        this.image = new Image("images/inventorySlots/inventorySlot.png");
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    public void hide() {
        this.image.makeInvisible();
    }
    public void deleteItem() {
        this.item = null;
    }
    public void setSlotPosition(int x, int y) {
        this.positionX = (x - 1220) / 90;
        if (this.isInventory) {
            this.positionY = (y - 45) / 90;
        } else {
            this.positionY = (y - 400) / 90;
        }
        this.image.changePosition(x, y);
        this.image.makeVisible();
    }
    public void moveTo(int x, int y) {
        int destX = (x - 1220) / 90;
        int destY;
        if (this.isInventory) {
            destY = (y - 50) / 90;
        } else {
            destY = (y - 400) / 90;
        }

        if (this.positionX == destX && this.positionY == destY) {
            System.out.println(this.positionX);
            System.out.println(this.positionY);
        }
    }
    public void addItem(Item item) {
        this.countOfItem += 1;
        this.item = Optional.of(item);
    }
    public Optional<Item> getItem() {
        return this.item;
    }
    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }
    public void isInventory(boolean inventory) {
        this.isInventory = inventory;
    }

}
