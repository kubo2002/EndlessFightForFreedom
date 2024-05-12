package inventory;

import fri.shapesge.Image;

import java.util.Optional;

public class InventorySlot {
    private Optional<Item> item;
    private final int lengthOfTile = 90;
    private Image image;
    private int countOfItem; // number of same items in same slot
    private int positionX;
    private int positionY;

    public InventorySlot() {
        this.item = Optional.empty();
        this.countOfItem = 0;
        this.image = new Image("images/inventorySlots/inventorySlot.png");
    }

    public void hide() {
        this.image.makeInvisible();
    }
    public void deleteItem() {
        this.item = null;
    }
    public void setSlotPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }
    public void addItem(Item item) {
        this.countOfItem += 1;
        this.item = Optional.of(item);
    }

    public Optional<Item> getItem() {
        if (this.countOfItem > 0) {
            this.countOfItem -= 1;
            return this.item;
        } else {
            this.countOfItem = 0;
            this.item = Optional.empty();
            return this.item;
        }
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }
}
