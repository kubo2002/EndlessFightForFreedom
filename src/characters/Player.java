package characters;

import fri.shapesge.Manager;
import room.Room;
import room.Tile;


public class Player extends Person implements Actions {
    private Manager manager;
    public Player(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.KNIGHT, currentRoom);
        super.setPosition(positionX, positionY);
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    public void move(int x, int y) {
        super.moveToDestination(x, y);
    }

    @Override
    public void fight(Tile tile) {

    }
}
