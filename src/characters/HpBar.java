package characters;
import fri.shapesge.Rectangle;
public class HpBar {
    private double fullHP;
    private double hp;
    private Rectangle mainIdicator;
    private Rectangle background;
    private int positionX;
    private int positionY;
    private final int widthOfIndicator = 50;

    public HpBar(double hp) {
        this.fullHP = hp;
        this.hp = this.fullHP;
        this.background = new Rectangle(this.positionX, this.positionY);
        this.background.changeColor("black");
        this.background.changeSize(this.widthOfIndicator, 8);

        this.mainIdicator = new Rectangle(this.positionX, this.positionY);
        this.mainIdicator.changeColor("green");
        this.mainIdicator.changeSize(this.widthOfIndicator, 8);
    }
    public void subtractLife(double count) {
        int c = (int)(this.hp - count);
        int newWidth =  (int)(c * this.widthOfIndicator / this.fullHP);

        this.mainIdicator.changeSize(newWidth,  8);
        this.hp -= count;
    }

    public void heal(double count) {
        double range = this.fullHP - this.hp;

        if (range < count) {
            this.mainIdicator.changeSize(this.widthOfIndicator,  8);
            this.hp = this.fullHP;
        } else {
            this.hp += count;
            int newWidth = (int)((this.hp * this.widthOfIndicator) / this.fullHP);
            this.mainIdicator.changeSize(newWidth,  8);
        }
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
