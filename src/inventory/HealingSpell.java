package inventory;

import fri.shapesge.Image;
public class HealingSpell implements Item {
    private Image image;
    private int positionX;
    private int positionY;
    private TypeOfItem type;
    public HealingSpell() {
        this.image = new Image(String.format("images/items/spells/%s.png", TypeOfItem.HEAL.getPath()));
        this.type = TypeOfItem.HEAL;
    }

    public void setPosition(int x, int y) {
        this.image.changePosition(x, y);
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
