package inventory;

import java.util.Optional;

public class InventorySlot {
    private Optional<Item> item;
    private int countOfItem; // number of same items in same slot
    private int positionX;
    private int positionY;

    public InventorySlot() {
        this.item = Optional.empty();
        this.countOfItem = 0;
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
}
