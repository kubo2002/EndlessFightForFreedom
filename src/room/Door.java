package room;

import fri.shapesge.Manager;
public class Door {
    private int positionX;
    private int positionY;
    private Manager manager;
    public Door(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    public void openDoor(int x, int y) {
        int clickedX = (x - 45) / 90;
        int clickedY = (y - 45) / 90;

        if (this.positionX == clickedX && this.positionY == clickedY) {
            RoomManager roomManager = RoomManager.getInstance();
            roomManager.showDialog();
        }
    }


}
