import fri.shapesge.Image;
import fri.shapesge.Manager;

public class Plocha {
    private Image obrazok;
    private Image obrazok2;
    private Manager manazer;

    public Plocha() {
        this.obrazok = new Image("images/characters/knight/knight_stand.png");
        this.obrazok.makeVisible();
        this.manazer = new Manager();

    }
}
