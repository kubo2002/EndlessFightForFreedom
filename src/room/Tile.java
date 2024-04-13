package room;

import fri.shapesge.Image;
public class Tile {
    private int positionX;
    private int positionY;
    private final int lengthOfTile = 90;
    private Image image;

    public Tile() {

    }
    public void setPicture(int type) {
        switch (type) {
            case 1:
                this.image = new Image(TileType.STONE_WALL.getPath());
                break;
            case 2:
                this.image = new Image(TileType.DIRT_FLOWERS.getPath());
                break;
            case 3:
                this.image = new Image(TileType.DIRT_CLEAN.getPath());
                break;
            case 4:
                this.image = new Image(TileType.DIRT_GRASS.getPath());
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
}
