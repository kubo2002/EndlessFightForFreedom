package room;

import fri.shapesge.Image;

import java.util.ArrayList;

public class Tile {
    private int positionX;
    private int positionY;
    private final int lengthOfTile = 90;
    private Image image;
    private boolean isOccupied;
    private Tile precursor;
    private ArrayList<Tile> surroundings;
    private boolean areDoors;
    public Tile() {
        this.surroundings = new ArrayList<>();
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
            case 6:
                this.image = new Image(TileType.DOORS.getPath());
                this.isOccupied = TileType.DOORS.isOccupied();
                this.areDoors = true;
                break;
        }
    }
    public void setTilePosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }

    public void setPrecursor(Tile precursor) {
        this.precursor = precursor;
    }
    public Tile getPrecursor() {
        return this.precursor;
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
    public void addSurrounding(Tile tile) {
        this.surroundings.add(tile);
    }

    public ArrayList<Tile> getSurroundings() {
        return this.surroundings;
    }
    public boolean areDoors() {
        return this.areDoors;
    }
}
