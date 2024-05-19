package characters;
import fri.shapesge.Rectangle;

/**
 * Trieda reprezentujuca ukazvatel aktualneho stavu zivota.
 *
 * @author Jakub Gubany
 *
 */
public class HpBar {
    private double fullHP;
    private double hp;
    private Rectangle mainIdicator;
    private Rectangle background;
    private int positionX;
    private int positionY;
    private final int widthOfIndicator = 50;

    /**
     * Konstrukor triedy HpBar.
     *
     * Vytvori novu instanciu.
     *
     * @param hp maximalny pocet zivota postavy.
     */
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

    /**
     * Odrata zivoty a upravi graficky ukazovatel podla aktualneho stavu zivota.
     *
     * @param count pocet zivota, ktory ma byt odratany.
     *
     */
    public void subtractLife(double count) {
        int c = (int)(this.hp - count);
        int newWidth =  (int)(c * this.widthOfIndicator / this.fullHP);

        this.mainIdicator.changeSize(newWidth,  8);
        this.hp -= count;
    }

    /**
     * Prida postave zivoty a upravi podla toho aj graficky ukazovatel zivotov.
     *
     * @param count pocet zivotov ktore maju byt pridane postave.
     *
     */
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

    /**
     *
     * Posunie hp bar na ploche o zadanu vzdialenost.
     *
     * @param x vzdialenost na ose X.
     * @param y vzdialenost na ose Y.
     */
    public void moveHpBar(int x, int y) {
        this.background.moveHorizontal(x);
        this.background.moveVertical(y);
        this.mainIdicator.moveHorizontal(x);
        this.mainIdicator.moveVertical(y);
    }

    /**
     * Nastavi presnu poziciu na ploche.
     *
     * @param x pozicia na ose X.
     * @param y pozicia na ose Y.
     */
    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.background.changePosition(x, y);
        this.mainIdicator.changePosition(x, y);
    }

    /**
     * Zobrazi hp bar na hracej ploche.
     */
    public void showHpBar() {
        this.background.makeVisible();
        this.mainIdicator.makeVisible();
    }

    /**
     * Schova hp bar.
     */
    public void hideHpBar() {
        this.background.makeInvisible();
        this.mainIdicator.makeInvisible();
    }

    /**
     * Zresetuje pocet hp a ukazovatel zivota.
     */
    public void resetHp() {
        this.mainIdicator.changeSize(this.widthOfIndicator, 8);
        this.hp = this.fullHP;
    }

    /**
     * Vrati stav ci je postava nazive alebo nie.
     *
     * @return boolean stav
     */
    public boolean isAlive() {
        return this.hp >= 0;
    }

    /**
     * Vrati aktualny pocet hp.
     *
     * @return double pocet zivotov.
     *
     */
    public double getHp() {
        return this.hp;
    }

    /**
     * Nastavi pocet zivotov postave.
     *
     * @param hp double pocet zivotov ktore chceme postave nastavit.
     */
    public void setHp(double hp) {
        this.hp = hp;
        int newWidth =  (int)(this.hp * this.widthOfIndicator / this.fullHP);
        this.mainIdicator.changeSize(newWidth,  8);
    }
}
