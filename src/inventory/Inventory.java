package inventory;

import java.util.Optional;

public class Inventory {
    private Optional<InventorySlot>[][] slots;

    public Inventory() {
        this.slots = new Optional[3][3];
    }

    public void addItem() {
        for (int row = 0; row < this.slots.length; row++) {
            for (int column = 0; column < this.slots[row].length; column++) {
                if (this.slots[row][column].isEmpty()) {

                }
            }
        }
    }

}
