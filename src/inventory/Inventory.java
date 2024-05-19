package inventory;

/**
 * Trieda Inventory reprezentuje inventar hraca.
 * Obsahuje maticu slotov, ktore su organizovane v riadkoch a stlpcoch.
 * Je implementovana ako singleton.
 *
 * @autor Jakub Gubany
 */
public class Inventory {
    private InventorySlot[][] slots;
    private final int inventoryRange = 9;
    private final int numberOfRows = 3;
    private final int numberOfColumns = 3;
    private final int lengthOfTile = 90;
    private final int positionX = 1220;
    private final int positionY = 50;
    private static final Inventory INVENTORY = new Inventory();
    /**
     * Privatny konstruktor triedy Inventory.
     * Inicializuje maticu slotov a nastavi kazdy slot ako sucast inventara.
     */
    private Inventory() {
        this.slots = new InventorySlot[this.numberOfRows][this.numberOfColumns];

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column] = new InventorySlot();
                this.slots[row][column].isInventory(true);
            }
        }
    }
    /**
     * Metoda pre ziskanie instancie inventara.
     *
     * @return instancia inventara
     */
    public static Inventory getInstance() {
        return INVENTORY;
    }
    /**
     * Metoda pre pridanie polozky do inventara.
     *
     * @param item polozka na pridanie
     */
    public void addItem(Item item) {
        int counter = 0;
        boolean itemPlaced = false;
        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                if (this.slots[row][column].getItem().isEmpty()) {
                    this.slots[row][column].addItem(item);
                    itemPlaced = true;
                    break;
                } else {
                    counter += 1;
                }
            }
            if (itemPlaced) {
                break;
            }
        }

        if (counter == this.inventoryRange) {
            System.out.println("Inventory is full !");
        }
    }
    /**
     * Metoda pre kreslenie inventara na obrazovku.
     */
    public void drawInventoryOnScreen() {
        int posX = this.positionX;
        int posY = this.positionY;

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column].setSlotPosition(posX, posY);
                posX += this.lengthOfTile;
            }
            posY += this.lengthOfTile;
            posX = this.positionX;
        }
    }
}
