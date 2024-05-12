package inventory;

import fri.shapesge.Image;
public class HealingSpell implements Item {
    private Image image;
    private int positionX;
    private int positionY;
    public HealingSpell() {
        this.image = new Image(String.format("images/items/spells/%s.png", TypeOfItem.HEAL.getPath()));
        this.image.makeVisible();
    }

    public void setPosition(int x, int y) {
        this.image.changePosition(x * 90 + 45, y * 90 + 45);
        this.image.makeVisible();
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    @Override
    public void use() {

    }

    @Override
    public void addToInventory() {

    }
}
