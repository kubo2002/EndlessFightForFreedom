package room;

public enum TypeOfRoom {
    MARKET(5, 5),
    BATTLEGROUND(10, 10),
    TEMPLE(5, 5);

    private final int numberOfTilesX;
    private final int numberOfTilesY;

    TypeOfRoom(int numberOfTilesX, int numberOfTilesY) {
        this.numberOfTilesX = numberOfTilesX;
        this.numberOfTilesY = numberOfTilesY;
    }

    private int getNumberOfTilesX() {
        return this.numberOfTilesX;
    }

    private int getNumberOfTilesY() {
        return this.numberOfTilesY;
    }
}
