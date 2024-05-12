package shop;

import inventory.InventorySlot;
import inventory.Item;
import room.Tile;
import room.TileType;

import java.util.HashMap;

public class Offer {
    private InventorySlot[][] slots;
    private HashMap<Item, Double> warehouse;
    private HashMap<Item, Double> offer;
    private double bank;
    private final int numberOfRows = 2;
    private final int numberOfColumns = 5;
    private final int lengthOfTile = 90;
    private final int positionX = 1220;
    private final int positionY = 400;

    public Offer(HashMap<Item, Double> warehouse, double bank) {
        this.slots = new InventorySlot[this.numberOfRows][this.numberOfColumns];
        this.warehouse = warehouse;
        this.bank = bank;
        this.offer = new HashMap<>();

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column] = new InventorySlot();
            }
        }
    }


    private void calculateOffer() {
        for (Item warehouseSlot : this.warehouse.keySet()) {
            if (this.warehouse.get(warehouseSlot) <= this.bank) {
                this.offer.put(warehouseSlot, this.warehouse.get(warehouseSlot));
            }
        }
    }

    public void drawOfferOnScreen() {

        int posX = this.positionX;
        int posY = this.positionY;

        for (int columns = 0; columns < this.numberOfColumns; columns++) {
            Tile slot = new Tile();
            slot.setPicture(TileType.INVENTORY_SLOT.getID());
            slot.setOccupied(true);
            slot.setTilePosition(posX, posY);
            posX += this.lengthOfTile;
        }
        posY += this.lengthOfTile;
        posX = this.positionX;
    }
}

