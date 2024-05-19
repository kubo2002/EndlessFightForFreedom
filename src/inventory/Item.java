package inventory;
import fri.shapesge.Image;
/**
 * Trieda Item predstavuje predmet v hre.
 * Kazdy predmet ma urceny typ a obrazok, ktory ho reprezentuje.
 *
 * @autor Jakub Gubany
 */
public class Item {
    private int positionX;
    private int positionY;
    private Image image;
    private TypeOfItem type;
    /**
     * Konstruktor triedy Item.
     * Inicializuje obrazok predmetu na zaklade jeho typu.
     *
     * @param type typ predmetu
     */
    public Item(TypeOfItem type) {
        this.image = new Image(String.format("images/items/%s/%s.png", type.getCategory(), type.getPath()));
        this.type = type;
    }
    /**
     * Metoda na nastavenie pozicie predmetu.
     *
     * @param x x-suradnica pozicie
     * @param y y-suradnica pozicie
     */
    public void setPosition(int x, int y) {
        this.positionX = (x - 45) / 90;
        this.positionY = (y - 45) / 90;
        this.image.changePosition(x, y);
    }
    /**
     * Metoda na zobrazenie predmetu.
     */
    public void showItem() {
        this.image.makeVisible();
    }
    /**
     * Metoda na skrytie predmetu.
     */
    public void hideItem() {
        this.image.makeInvisible();
    }
    /**
     * Metoda na ziskanie x-suradnice pozicie predmetu.
     *
     * @return x-suradnica pozicie
     */
    public int getPositionX() {
        return this.positionX;
    }
    /**
     * Metoda na ziskanie y-suradnice pozicie predmetu.
     *
     * @return y-suradnica pozicie
     */
    public int getPositionY() {
        return this.positionY;
    }
    /**
     * Metoda na ziskanie sily predmetu.
     *
     * @return sila predmetu
     */
    public double getPower() {
        return this.type.getPower();
    }
    /**
     * Metoda na ziskanie ceny predmetu.
     *
     * @return cena predmetu
     */
    public double getCost() {
        return this.type.getCost();
    }
    /**
     * Metoda na ziskanie maximalneho poctu pouziti predmetu.
     *
     * @return maximalny pocet pouziti
     */
    public int getMaxUse() {
        return this.type.getMaxUse();
    }
}
