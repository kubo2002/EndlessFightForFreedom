package room;

public class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;

    public Room() {
        this.map = new RoomGenerator();
    }

    public void showMap() {
        int[][] matrixOfMap = this.map.createMap();
        int posX = this.positionX;
        int posY = this.positionY;
        int lengthOfTile = 0;

        for (int row = 0; row < matrixOfMap.length; row++) {
            for (int column = 0; column < matrixOfMap[row].length; column++) {
                Tile tile = new Tile();
                lengthOfTile = tile.getLengthOfTile();
                tile.setPicture(matrixOfMap[row][column]);
                tile.setTilePosition(posX, posY);
                posX += lengthOfTile;
            }
            posY += lengthOfTile;
            posX = this.positionX;
        }
    }
}
