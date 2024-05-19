package inventory;

import fri.shapesge.Image;
public class HealingSpell extends Item implements Spell {
    private Image image;
    public HealingSpell(TypeOfItem type) {
        super(type);
        this.image = new Image(String.format("images/items/spells/%s.png", type.getPath()));
    }
    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }


}
