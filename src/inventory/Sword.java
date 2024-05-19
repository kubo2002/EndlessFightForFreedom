package inventory;

import fri.shapesge.Image;

public class Sword extends Item implements Weapon {
    private Image image;
    private TypeOfItem type;
    public Sword(TypeOfItem type) {
        super(type);
        this.image = new Image(String.format("images/items/swords/%s.png", type.getPath()));
        this.type = type;
    }
    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

}
