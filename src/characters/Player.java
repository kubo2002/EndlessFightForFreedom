package characters;

import fri.shapesge.Manager;
import room.Room;
import room.Tile;

public class Player extends Person implements Actions {
    private Manager manager;
    private int amountOfCoins; //TODO pridat zbieranie minci
    public Player(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.KNIGHT, currentRoom);
        super.setPosition(positionX, positionY);
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    public void moveUp() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, -90);
            super.setPositionY(super.getPositionY() - 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveDown() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, 90);
            super.setPositionY(super.getPositionY() + 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveLeft() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(-90, 0);
            super.setPositionX(super.getPositionX() - 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveRight() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(90, 0);
            super.setPositionX(super.getPositionX() + 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }

    @Override
    public void performAttack(Tile tile) {

    }

    //TODO nakup itemov
}
