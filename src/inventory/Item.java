package inventory;
import fri.shapesge.Image;
public abstract class Item {
    private int positionX;
    private int positionY;
    private Image image;
    public Item(TypeOfItem type) {
        this.image = new Image(String.format("images/items/%s/%s.png", type.getCategory(), type.getPath()));
    }
    public abstract void addToInventory();
    public void setPosition(int x, int y) {
        this.positionX = (x - 45) / 90;
        this.positionY = (y - 45) / 90;
        this.image.changePosition(x, y);
    }
    public void showItem() {
        this.image.makeVisible();
    }
    public void hideItem() {
        this.image.makeInvisible();
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
}
