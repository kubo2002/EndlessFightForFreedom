package inventory;
public class Coins extends Item {
    public Coins(int positionX, int positionY) {
        super(TypeOfItem.COINS);
        super.setPosition(positionX * 90 + 45, positionY * 90 + 45);
    }
}
