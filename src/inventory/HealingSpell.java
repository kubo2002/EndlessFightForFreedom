package inventory;

import fri.shapesge.Image;
public class HealingSpell extends Item implements Spell {
    private Image image;
    private int positionX;
    private int positionY;
    private TypeOfItem type;
    public HealingSpell() {
        super(TypeOfItem.HEAL);
        this.image = new Image(String.format("images/items/spells/%s.png", TypeOfItem.HEAL.getPath()));
        this.type = TypeOfItem.HEAL;
    }

    @Override
    public void addToInventory() {

    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

}
