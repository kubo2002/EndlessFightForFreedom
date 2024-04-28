package inventory;

import fri.shapesge.Image;
import room.Tile;
import room.TileType;

import java.util.Optional;

public class Inventory {
    private InventorySlot[][] slots;
    private final int inventoryRange = 9;
    private final int numberOfRows = 3;
    private final int numberOfColumns = 3;
    private final int lengthOfTile = 90;
    private final int positionX = 1220;
    private final int positionY = 50;

    public Inventory() {
        this.slots = new InventorySlot[this.numberOfRows][this.numberOfColumns];

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                this.slots[row][column] = new InventorySlot();
            }
        }

    }

    public void addItem(Item item) {
        int counter = 0;

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                if (this.slots[row][column].getItem().isEmpty()) {
                    this.slots[row][column].addItem(item);
                } else {
                    counter += 1;
                }
            }
        }

        if (counter == this.inventoryRange) {
            System.out.println("Inventory is full !");
        }
    }

    public void drawInventoryOnScreen() {
        int posX = this.positionX;
        int posY = this.positionY;

        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
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

}
