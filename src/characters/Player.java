package characters;

public class Player extends Person implements Actions {
    private int positionX;
    public Player() {
        super(TypeOfPerson.KNIGHT);
    }

    @Override
    public void pohyb() {

    }
}
