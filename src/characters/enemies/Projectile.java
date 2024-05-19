package characters.enemies;

import characters.Actions;
import characters.TypeOfProjectile;
import characters.player.Player;
import fri.shapesge.Image;
import fri.shapesge.Manager;

/**
 * Trieda Projectile reprezentuje strelu v hre, ktorú môže vystreliť postava na cieľ.
 * Obsahuje informácie o pozícii strely, jej type, rýchlosti a cieľovej pozícii.
 *
 * @autor Jakub Gubany
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
     * Konštruktor triedy Projectile.
     *
     * @param type typ strely
     * @param person postava, ktorá vystrelila strelu
     * @param target cieľová hráčska postava
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
     * Metóda na pohyb strely smerom k cieľu.
     * Ak strela dosiahne cieľ, vykoná útok a stane sa neviditeľnou.
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
     * Metóda na pohyb strely v zadanom smere.
     *
     * @param cX smer pohybu po osi X
     * @param cY smer pohybu po osi Y
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
     * Skontroluje, či došlo ku kolízii strely s cieľom.
     *
     * @return true, ak došlo ku kolízii, inak false
     */
    private boolean areCollided() {
        return this.positionX == this.target.getPositionX() && this.positionY == this.target.getPositionY();
    }

    /**
     * Nastaví pozíciu strely a zobrazí ju.
     *
     * @param x x-súradnica novej pozície
     * @param y y-súradnica novej pozície
     */
    public void setPosition(int x, int y) {
        this.state = true;
        this.positionX = x * 90 + 45;
        this.positionY = y * 90 + 45;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }
    /**
     * Získa x-súradnicu aktuálnej pozície strely.
     *
     * @return x-súradnica aktuálnej pozície
     */
    public int getPositionX() {
        return (this.positionX - 45) / 90;
    }
    /**
     * Získa y-súradnicu aktuálnej pozície strely.
     *
     * @return y-súradnica aktuálnej pozície
     */
    public int getPositionY() {
        return (this.positionY - 45) / 90;
    }
    /**
     * Získa stav strely (true, ak je strela aktívna).
     *
     * @return stav strely
     */
    public boolean getState() {
        return this.state;
    }
}
