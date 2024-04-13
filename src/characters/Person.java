package characters;
import fri.shapesge.Image;
public abstract class Person {
    private TypeOfPerson type;
    private int numberOfFrames;
    private int currentFarme;
    private Image image;
    private int positionX;
    private int positionY;

    public Person(TypeOfPerson type) {
        this.type = type;
        this.numberOfFrames = type.getNumberOfFrames();
        this.image = new Image(String.format("images/characters/%s/%s_0.png", this.type.getName(), this.type.getName()));
    }

    public void animation() {
        this.currentFarme += 1;
        if (this.currentFarme > this.numberOfFrames) {
            this.currentFarme = 0;
        }
        this.image.changeImage(String.format("images/characters/%s/%s_%d.png", this.type.getName(), this.type.getName(), this.currentFarme));
        this.image.makeVisible();
    }

    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
    }

    public void goTo(int x, int y) {
    }
}
