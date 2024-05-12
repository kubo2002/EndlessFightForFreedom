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

    public Projectile(TypeOfProjectile type, Actions person, Actions target) {
        this.person = person;
        this.target = target;
        this.destinationX = target.getPositionX();
        this.destinationY = target.getPositionY();
        this.type = type;
        this.image = new Image(String.format("images/projectiles/%s.png", type.getPath()));
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.moveProjectile(this.destinationX, this.destinationY);
    }
    @Override
    public void moveProjectile(int destX, int destY) {
        if (this.positionX < destX) {
            this.positionX += 1;
            System.out.println(this.positionX);
            //this.image.moveHorizontal(90);
        } else if (this.positionX > destX) {
            this.positionX -= 1;
            //this.image.moveHorizontal(-90);
        } else if (this.positionY < destY) {
            this.positionY -= 1;
           //this.image.moveVertical(-90);
        } else if (this.positionY > destY) {
            this.positionY += 1;
            //this.image.moveVertical(90);
        }
        if (this.positionX == destX || this.positionY == destY) {
            this.person.performAttack(this.target);
        }

    }
    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(x * 90 + 45, y * 90 + 45);
        this.showProjectile();
    }
    private void showProjectile() {
        this.image.makeVisible();
    }
    public void hideProjectile() {
        this.image.makeInvisible();
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
}
