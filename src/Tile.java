import fri.shapesge.Image;
public class Tile {
    private int positionX;
    private int positionY;
    private Image image;
    public Tile(int positionX, int positionY, Image image) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.image = image;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setTilePosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }
}
