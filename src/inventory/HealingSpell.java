package inventory;

import fri.shapesge.Image;
public class HealingSpell extends Item implements Spell {
    private Image image;
    private int positionX;
    private int positionY;
    private TypeOfItem type;
    public HealingSpell(TypeOfItem type) {
        super(type);
        this.image = new Image(String.format("images/items/spells/%s.png", type.getPath()));
        this.type = type;
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
