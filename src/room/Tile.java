package room;

import characters.Actions;
import fri.shapesge.Image;
import inventory.Item;
import java.util.ArrayList;
import java.util.Optional;

public class Tile {
    private int positionX;
    private int positionY;
    private final int lengthOfTile = 90;
    private Image image;
    private boolean isOccupied;
    private Optional<Actions> character;
    private ArrayList<Tile> surroundings;
    private boolean areDoors;
    private Optional<Item> item;
    public Tile() {
        this.surroundings = new ArrayList<>();
        this.character = Optional.empty();
        this.item = Optional.empty();
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
        if (!occupied) {
            this.character = Optional.empty();
        }
        this.isOccupied = occupied;
    }
    public void setCharacter(Actions character) {
        this.character = Optional.of(character);
    }
    public Optional<Actions> getCharacter() {
        return this.character;
    }
    public void addSurrounding(Tile tile) {
        this.surroundings.add(tile);
    }
    public boolean areDoors() {
        return this.areDoors;
    }
    public void show() {
        this.image.makeVisible();
    }
    public void hide() {
        this.image.makeInvisible();
    }
    public ArrayList<Tile> getSurroundings() {
        return this.surroundings;
    }
    public Optional<Item> getItem() {
        return this.item;
    }
    public void setItem(Optional<Item> item) {
        if (this.item.isEmpty()) {
            this.item = item;
            this.item.get().showItem();
        }
    }
}
