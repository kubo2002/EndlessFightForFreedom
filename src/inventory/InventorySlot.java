package inventory;

import characters.player.Player;
import fri.shapesge.Image;
import fri.shapesge.Manager;
import java.util.Optional;
/**
 * Trieda InventorySlot predstavuje slot v inventari.
 * Kazdy slot moze obsahovat jednu polozku.
 *
 * @autor Jakub Gubany
 */

public class InventorySlot {
    private Optional<Item> item;
    private Image image;
    private int positionX;
    private int positionY;
    private Manager manager;
    private boolean isInventory;
    /**
     * Konstruktor triedy InventorySlot.
     * Inicializuje slot, nastavi polozku ako Optional.empty() a nacita obrazok pre zobrazenie slotu.
     */
    public InventorySlot() {
        this.item = Optional.empty();
        this.image = new Image("images/inventorySlots/inventorySlot.png");
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    /**
     * Metoda na skrytie obrazku slotu.
     */
    public void hide() {
        this.image.makeInvisible();
    }
    /**
     * Metoda na nastavenie pozicie slotu.
     *
     * @param x x-suradnica pozicie
     * @param y y-suradnica pozicie
     */
    public void setSlotPosition(int x, int y) {
        this.positionX = ((x - 1220) / 90);
        if (this.isInventory) {
            this.positionY = ((y - 45) / 90);
        } else {
            this.positionY = ((y - 400) / 90);
        }
        this.image.changePosition(x, y);
        this.image.makeVisible();
    }
    /**
     * Metoda na pohyb polozky na urcitu poziciu.
     * Ak sa polozka nachadza na rovnakej pozicii ako cielova pozicia,
     * vykona sa prislusna akcia s polozkou (napr. nakup / pouzivanie).
     *
     * @param x x-suradnica cielovej pozicie
     * @param y y-suradnica cielovej pozicie
     */
    public void moveTo(int x, int y) {
        int destX = (x - 1220) / 90;
        int destY;
        if (this.isInventory) {
            destY = (y - 50) / 90;
        } else {
            destY = (y - 400) / 90;
        }
        if (this.positionX == destX && this.positionY == destY) {
            if (this.item.isPresent()) {
                if (!this.isInventory) {
                    Player player = Player.getInstance();
                    if (player.getScoreBoard().getBank() >= this.item.get().getCost()) {
                        player.buyItem(this.item.get());
                        Inventory inventory = Inventory.getInstance();
                        inventory.addItem(this.item.get());
                    }
                } else {
                    Player player = Player.getInstance();
                    player.useItem(this.item.get());
                    this.item.get().hideItem();
                }
                this.item = Optional.empty();
            }
        }
    }
    /**
     * Metoda na pridanie polozky do slotu.
     *
     * @param item polozka na pridanie
     */
    public void addItem(Item item) {
        this.item = Optional.of(item);
        if (this.isInventory) {
            this.item.get().setPosition((this.positionX * 90) + 1220, (this.positionY * 90) + 50);
        }
    }
    /**
     * Metoda na ziskanie polozky zo slotu.
     *
     * @return polozka zo slotu
     */
    public Optional<Item> getItem() {
        return this.item;
    }
    /**
     * Metoda na ziskanie x-suradnice pozicie slotu.
     *
     * @return x-suradnica pozicie slotu
     */
    public int getPositionX() {
        return this.positionX;
    }
    /**
     * Metoda na ziskanie y-suradnice pozicie slotu.
     *
     * @return y-suradnica pozicie slotu
     */
    public int getPositionY() {
        return this.positionY;
    }

}
