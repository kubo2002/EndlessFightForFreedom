package room;

import fri.shapesge.Manager;


public class Door {
    private int positionX;
    private int positionY;
    private Manager manager;
    private RoomManager roomManager;
    public Door(int positionX, int positionY, RoomManager roomManager) {
        this.roomManager = roomManager;
        this.positionX = positionX;
        this.positionY = positionY;
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    public void openDoor(int x, int y) {
        int clickedX = (x - 45) / 90;
        int clickedY = (y - 45) / 90;

        if (this.positionX == clickedX && this.positionY == clickedY) {
            this.roomManager.showDialog();
            //TODO pridat podmienku kedy sa otvoria dvere.
        }
    }


}
