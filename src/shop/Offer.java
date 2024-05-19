package shop;

import inventory.InventorySlot;
import inventory.Item;


import java.util.ArrayList;
import java.util.HashMap;

/**
 * Trieda Offer reprezentuje ponuku predmetov v obchode.
 *
 * @autor Jakub Gubany
 */
public class Offer {
    private InventorySlot[][] slots;
    private HashMap<Item, Double> warehouse;
    private ArrayList<Item> offer;
    private double bank;
    private final int numberOfRows = 2;
    private final int numberOfColumns = 5;
    private final int lengthOfTile = 90;
    private final int positionX = 1220;
    private final int positionY = 400;
    private boolean isVisible;
    /**
     * Konstruktor triedy Offer vytvara instanciu ponuky predmetov na zaklade skladu.
     * @param warehouse HashMap, ktore obsahuje predmety a ich ceny v sklade.
     */
    public Offer(HashMap<Item, Double> warehouse) {
        this.slots = new InventorySlot[this.numberOfRows][this.numberOfColumns];
        this.warehouse = warehouse;
        this.offer = new ArrayList<>();
        this.isVisible = false;

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column] = new InventorySlot();
                this.slots[row][column].isInventory(false);
            }
        }
    }
    /**
     * Metoda offerOnScreen zobrazuje alebo skryva ponuku predmetov na obrazovke.
     */
    public void offerOnScreen() {
        if (!this.isVisible) {
            this.showOffer();
            this.isVisible = true;
        } else {
            this.hideOffer();
            this.isVisible = false;
        }
    }
    /**
     * Metoda calculateOffer vypocitava ponuku predmetov na zaklade dostupnych financii hraca.
     */
    private void calculateOffer() {
        for (Item warehouseSlot : this.warehouse.keySet()) {
            if (this.warehouse.get(warehouseSlot) <= this.bank) {
                this.offer.add(warehouseSlot);
            }
        }
    }
    /**
     * Metoda showOffer zobrazuje ponuku predmetov na obrazovke.
     */
    private void showOffer() {
        this.calculateOffer();
        int posX = this.positionX;
        int posY = this.positionY;

        int itemIndex = 0;

        for (int rows = 0; rows < this.numberOfRows; rows++) {
            for (int columns = 0; columns < this.numberOfColumns; columns++) {
                this.slots[rows][columns].setSlotPosition(posX, posY);
                posX += this.lengthOfTile;
            }
            posY += this.lengthOfTile;
            posX = this.positionX;
        }
        posX = this.positionX;
        posY = this.positionY;
        int row = 0;

        for (int i = 0; i < this.offer.size(); i++) {
            if (i < this.slots[row].length - 1) {
                this.offer.get(i).setPosition(posX, posY);
                this.offer.get(i).showItem();
                this.slots[row][i].addItem(this.offer.get(i));
                posX += this.lengthOfTile;
            } else {
                row += 1;
                posY += this.lengthOfTile;
                posX = this.positionX;
            }
        }
    }
    /**
     * Metoda hideOffer skryva ponuku predmetov na obrazovke.
     */
    public void hideOffer() {
        this.offer = new ArrayList<>();
        for (int rows = 0; rows < this.numberOfRows; rows++) {
            for (int columns = 0; columns < this.numberOfColumns; columns++) {
                if (this.slots[rows][columns].getItem().isPresent()) {
                    var item = this.slots[rows][columns].getItem().get();
                    item.hideItem();
                }
                this.slots[rows][columns].hide();
            }
        }
    }
    /**
     * Metoda setBank nastavuje aktualnu hodnotu poctu minci hraca.
     * @param bank Hodnota poctu minci hraca.
     */
    public void setBank(double bank) {
        this.bank = bank;
    }

}

