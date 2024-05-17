package inventory;

import fri.shapesge.Image;

public class Coins extends Item {
    private int positionX;
    private int positionY;
    private Image image;
    public Coins(int positionX, int positionY) {
        super(TypeOfItem.COINS);
        super.setPosition(positionX * 90 + 45, positionY * 90 + 45);
        super.showItem();
    }

    @Override
    public void addToInventory() {

    }
}
