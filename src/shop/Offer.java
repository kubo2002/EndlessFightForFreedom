package shop;

import inventory.InventorySlot;
import inventory.Item;

import java.util.ArrayList;
import java.util.HashMap;

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

    public Offer(HashMap<Item, Double> warehouse) {
        this.slots = new InventorySlot[this.numberOfRows][this.numberOfColumns];
        this.warehouse = warehouse;
        this.offer = new ArrayList<>();
        this.isVisible = false;

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column] = new InventorySlot();
            }
        }
    }

    public void offerOnScreen() {
        if (!this.isVisible) {
            this.showOffer();
            this.isVisible = true;
        } else {
            this.hideOffer();
            this.isVisible = false;
        }
    }
    private void calculateOffer() {
        for (Item warehouseSlot : this.warehouse.keySet()) {
            if (this.warehouse.get(warehouseSlot) <= this.bank) {
                this.offer.add(warehouseSlot);
            }
        }
    }

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
        System.out.println(this.offer);
        posX = this.positionX;
        posY = this.positionY;
        int row = 0;
        for (int i = 0; i < this.offer.size(); i++) {
            if (i < this.slots[row].length - 1) {
                this.slots[row][i].addItem(this.offer.get(i));
                this.slots[row][i].getItem().get().setPosition(posX, posY);
                posX += this.lengthOfTile;
            } else {
                row += 1;
                posY += this.lengthOfTile;
                posX = this.positionX;
            }
        }
    }

    private void hideOffer() {
        for (int rows = 0; rows < this.numberOfRows; rows++) {
            for (int columns = 0; columns < this.numberOfColumns; columns++) {
                this.slots[rows][columns].deleteItem();
                this.slots[rows][columns].hide();
                this.slots[rows][columns] = new InventorySlot();
            }
        }
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

}

