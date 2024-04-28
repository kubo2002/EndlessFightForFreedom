package room;

import fri.shapesge.Image;
public class Tile {
    private int positionX;
    private int positionY;
    private final int lengthOfTile = 90;
    private Image image;
    private boolean isOccupied;
    public Tile() {

    }
    public void setPicture(int type) {
        switch (type) {
            case 1:
                this.image = new Image(TileType.STONE_WALL.getPath());
                this.isOccupied = TileType.STONE_WALL.isOccupied();
                break;
            case 2:
                this.image = new Image(TileType.DIRT_FLOWERS.getPath());
                this.isOccupied = TileType.DIRT_FLOWERS.isOccupied();
                break;
            case 3:
                this.image = new Image(TileType.DIRT_CLEAN.getPath());
                this.isOccupied = TileType.DIRT_CLEAN.isOccupied();
                break;
            case 4:
                this.image = new Image(TileType.DIRT_GRASS.getPath());
                this.isOccupied = TileType.DIRT_GRASS.isOccupied();
                break;
            case 0:
                this.image = new Image(TileType.INVENTORY_SLOT.getPath());
                this.isOccupied = TileType.INVENTORY_SLOT.isOccupied();
                break;
        }
    }
    public void setTilePosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }

    public int getLengthOfTile() {
        return this.lengthOfTile;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public boolean isOccupied() {
        return this.isOccupied;
    }
    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }
}
