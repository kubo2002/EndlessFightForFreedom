package characters;

import fri.shapesge.Image;

public class Projectile {
    private Image image;
    private int positionX;
    private int positionY;
    private TypeOfProjectile type;
    public Projectile(TypeOfProjectile type, int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.type = type;
        this.image = new Image(String.format("images/projectiles/%s.png", type.getPath()));
    }
    public void move(int x, int y) {
        this.image.moveHorizontal(x);
        this.image.moveVertical(y);
    }
    public void showProjectile() {
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
