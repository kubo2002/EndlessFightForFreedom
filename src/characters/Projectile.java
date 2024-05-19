package characters;

import fri.shapesge.Image;
import fri.shapesge.Manager;

/**
 * Trieda predstavujuca projektil a jeho spravanie (pohyb, kolizia)
 *
 * @author Jakub Gubány
 *
 */
public class Projectile {
    private Image image;
    private int positionX;
    private int positionY;
    private int destinationX;
    private int destinationY;
    private TypeOfProjectile type;
    private Manager manager;
    private Actions person;
    private Player target;
    private boolean state;

    /**
     *
     * Konstruktor triedy Projectile
     *
     * @param type typ konkretnej postavy ktora bude triedou vytvorena.
     * @param person osoba od ktorej projektil pochadza
     * @param target ciel ktory ma projektil zasiahnut
     *
     */
    public Projectile(TypeOfProjectile type, Actions person, Player target) {
        this.person = person;
        this.target = target;
        this.destinationX = target.getPositionX() * 90 + 45;
        this.destinationY = target.getPositionY() * 90 + 45;
        this.type = type;
        this.image = new Image(String.format("images/projectiles/%s.png", type.getPath()));
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    /**
     *
     * Posuva projektil po ploche
     *
     */
    public void moveProjectile() {
        if (this.positionX < this.destinationX) {
            this.direction(1, 0);
        } else if (this.positionX > this.destinationX) {
            this.direction(-1, 0);
        } else if (this.positionY < this.destinationY) {
            this.direction(0, 1);
        } else if (this.positionY > this.destinationY) {
            this.direction(0, -1);
        } else if (this.state && (this.destinationX - 45) / 90 == this.target.getPositionX() && (this.destinationY - 45) / 90 == this.target.getPositionY()) {
            this.person.performAttack(this.target);
            this.state = false;
            this.image.makeInvisible();
        } else {
            this.state = false;
            this.image.makeInvisible();
        }
    }

    /**
     *
     * Vyberie ktorym smerom sa bude projektil pohybovat.
     *
     * @param cX konstanta ktora udava kladny / zaporny smer pohybu po osi X
     * @param cY konstanta ktora udava kladny / zaporny smer pohybu po osi Y
     *
     */
    private void direction(int cX, int cY) {

        this.image.moveHorizontal(cX * this.type.getSpeed());
        this.image.moveVertical(cY * this.type.getSpeed());
        this.positionX += cX * this.type.getSpeed();
        this.positionY += cY * this.type.getSpeed();

        if (this.areCollided()) { // ak nahodou pocas letu nastane kolizia s hracom tak mu daj poskodenie
            this.person.performAttack(this.target);
            this.state = false;
            this.image.makeInvisible();
        }
    }

    /**
     *
     * @return
     */
    private boolean areCollided() {
        return this.positionX == this.target.getPositionX() && this.positionY == this.target.getPositionY();
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        this.state = true;
        this.positionX = x * 90 + 45;
        this.positionY = y * 90 + 45;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }

    /**
     *
     * @return index v matici stvorcov z ktorych je zostavena plocha.
     *
     */
    public int getPositionX() {
        return (this.positionX - 45) / 90;
    }

    /**
     *
     * @return index v matici stvorcov z ktorych je zostavena plocha.
     */
    public int getPositionY() {
        return (this.positionY - 45) / 90;
    }

    /**
     *
     * @return ivrati ci je naboj v aktivnom alebo neaktivnom stave.
     *
     * Hodnota sluzi na vymazanie neaktivnych nabojov z hry.
     *
     */
    public boolean getState() {
        return this.state;
    }
}
