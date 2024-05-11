package inventory;

//TODO podedit druhy itemov
public abstract class Item {
    private int positionX;
    private int positionY;
    private boolean inInventory;
    public Item(int positionX, int positionY) {

        this.positionX = positionX;
        this.positionY = positionY;
    }
    public abstract void perform();

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public boolean isInInventory() {
        return this.inInventory;
    }

    public void setInInventory(boolean inInventory) {
        this.inInventory = inInventory;
    }
}
