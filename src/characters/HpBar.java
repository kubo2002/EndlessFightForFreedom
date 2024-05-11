package characters;
import fri.shapesge.Rectangle;
public class HpBar {
    private double hp;
    private Rectangle mainIdicator;
    private Rectangle background;
    private int positionX;
    private int positionY;

    public HpBar() {
        this.background = new Rectangle(this.positionX, this.positionY);
        this.background.changeColor("black");
        this.background.changeSize(50, 8);

        this.mainIdicator = new Rectangle(this.positionX, this.positionY);
        this.mainIdicator.changeColor("green");
        this.mainIdicator.changeSize(50, 8);
    }
    public void subtractLife(double count) {
        this.hp -= count;
    }

    public double getHp() {
        return this.hp;
    }
    public void move(int x, int y) {
        this.background.moveHorizontal(x);
        this.background.moveVertical(y);
        this.mainIdicator.moveHorizontal(x);
        this.mainIdicator.moveVertical(y);
    }
    public void setPosition(int x, int y) {
        this.background.changePosition(x, y);
        this.mainIdicator.changePosition(x, y);
    }
    public void showHpBar() {
        this.background.makeVisible();
        this.mainIdicator.makeVisible();
    }
    public void hideHpBar() {
        this.background.makeInvisible();
        this.mainIdicator.makeInvisible();
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public boolean isAlive() {
        return this.hp > 0;
    }
}
