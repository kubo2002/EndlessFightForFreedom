package characters;

import fri.shapesge.Image;
import fri.shapesge.Manager;

public class Projectile implements Projectiles {
    private Image image;
    private int positionX;
    private int positionY;
    private int destinationX;
    private int destinationY;
    private TypeOfProjectile type;
    private Manager manager;
    private Actions person;
    private Actions target;
    private boolean state;
    public Projectile(TypeOfProjectile type, Actions person, Actions target) {
        this.person = person;
        this.target = target;
        this.destinationX = target.getPositionX() * 90 + 45;
        this.destinationY = target.getPositionY() * 90 + 45;
        this.type = type;
        this.image = new Image(String.format("images/projectiles/%s.png", type.getPath()));
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    @Override
    public void moveProjectile() {
        if (this.positionX < this.destinationX) {
            this.image.moveHorizontal(this.type.getSpeed());
            this.positionX += this.type.getSpeed();
            if (this.areCollided()) {
                this.person.performAttack(this.target);
                this.state = false;
                this.image.makeInvisible();
            }
        } else if (this.positionX > this.destinationX) {
            this.image.moveHorizontal(-this.type.getSpeed());
            this.positionX -= this.type.getSpeed();
            if (this.areCollided()) {
                this.person.performAttack(this.target);
                this.state = false;
                this.image.makeInvisible();
            }
        } else if (this.positionY < this.destinationY) {
            this.image.moveVertical(this.type.getSpeed());
            this.positionY += this.type.getSpeed();
            if (this.areCollided()) {
                this.person.performAttack(this.target);
                this.state = false;
                this.image.makeInvisible();
            }
        } else if (this.positionY > this.destinationY) {
            this.image.moveVertical(-this.type.getSpeed());
            this.positionY -= this.type.getSpeed();
            if (this.areCollided()) {
                this.person.performAttack(this.target);
                this.state = false;
                this.image.makeInvisible();
            }
        } else if (this.state && (this.destinationX - 45) / 90 == this.target.getPositionX() && (this.destinationY - 45) / 90 == this.target.getPositionY()) {
            this.person.performAttack(this.target);
            this.state = false;
            this.image.makeInvisible();
        } else {
            this.state = false;
            this.image.makeInvisible();
        }
    }
    private boolean areCollided() {
        return this.positionX == this.target.getPositionX() && this.positionY == this.target.getPositionY();
    }
    public void setPosition(int x, int y) {
        this.state = true;
        this.positionX = x * 90 + 45;
        this.positionY = y * 90 + 45;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }
    public int getPositionX() {
        return (this.positionX - 45) / 90;
    }
    public int getPositionY() {
        return (this.positionY - 45) / 90;
    }
    public boolean getState() {
        return this.state;
    }
}
