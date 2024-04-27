package characters;

import fri.shapesge.Manager;


public class Player extends Person implements Actions {

    private Manager manager;

    public Player(int positionX, int positionY) {
        super(TypeOfPerson.KNIGHT);
        super.setPosition(positionX, positionY);
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    public void move(int x, int y) {
        super.moveToDestination(x, y);
    }

}
