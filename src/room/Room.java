package room;

public class Room {
    private RoomGenerator map;
    public Room() {
        this.map = new RoomGenerator();
    }

    public void showMap() {
        int[][] matrixOfMap = this.map.createMap();
        int positionX = 50;
        int positionY = 50;
        int lengthOfTile = 0;

        for (int row = 0; row < matrixOfMap.length; row++) {
            for (int column = 0; column < matrixOfMap[row].length; column++) {
                Tile tile = new Tile();
                lengthOfTile = tile.getLengthOfTile();
                tile.setPicture(matrixOfMap[row][column]);
                tile.setTilePosition(positionX, positionY);
                positionX += lengthOfTile;
            }
            positionY += lengthOfTile;
            positionX = 50;
        }
    }
}
