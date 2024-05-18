package inventory;
import fri.shapesge.Image;
public class Item {
    private int positionX;
    private int positionY;
    private Image image;
    private TypeOfItem type;
    public Item(TypeOfItem type) {
        this.image = new Image(String.format("images/items/%s/%s.png", type.getCategory(), type.getPath()));
        this.type = type;
    }
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
    public double getPower() {
        return this.type.getPower();
    }
    public double getCost() {
        return this.type.getCost();
    }
    public int getMaxUse() {
        return this.type.getMaxUse();
    }
}
