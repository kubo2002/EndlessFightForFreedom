package room;

import fri.shapesge.Manager;
/**
 * Trieda Door reprezentuje dvere v miestnosti, ktore umoznuju hracovi prechod do inej miestnosti.
 *
 * @autor Jakub Gubany
 */
public class Door {
    private int positionX;
    private int positionY;
    private Manager manager;
    /**
     * Konstruktor triedy Door inicializuje poziciu dveri.
     *
     * @param positionX pozicia X dveri
     * @param positionY pozicia Y dveri
     */
    public Door(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    /**
     * Metoda openDoor sluzi na otvorenie dveri v miestnosti.
     * Ak hrac klikne na dvere, zobrazi sa dialogove okno.
     *
     * @param x pozicia X kliknutia hraca
     * @param y pozicia Y kliknutia hraca
     */
    public void openDoor(int x, int y) {
        int clickedX = (x - 45) / 90;
        int clickedY = (y - 45) / 90;

        if (this.positionX == clickedX && this.positionY == clickedY) {
            RoomManager roomManager = RoomManager.getInstance();
            roomManager.showDialog();
        }
    }
}
