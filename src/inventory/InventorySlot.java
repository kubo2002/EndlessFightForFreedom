package inventory;

import java.util.Optional;

public class InventorySlot {
    private Optional<Item> item;

    public InventorySlot() {
        this.item = Optional.empty();
    }

    public void setItem(Item item) {
        this.item = Optional.of(item);
    }

    public Optional<Item> getItem() {
        return this.item;
    }
}
