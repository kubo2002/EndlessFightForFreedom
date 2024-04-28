package room;


import characters.Player;

import java.util.List;

public class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    private Tile[][] tiles;
    public Room(TypeOfRoom roomType) {
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
        this.tiles = new Tile[roomType.getNumberOfTilesX()][roomType.getNumberOfTilesY()];
    }

    public void showMap() {
        int[][] matrixOfMap = this.map.createMap();
        int posX = this.positionX;
        int posY = this.positionY;


        for (int row = 0; row < matrixOfMap.length; row++) {
            for (int column = 0; column < matrixOfMap[row].length; column++) {
                this.tiles[row][column] = new Tile();
                this.tiles[row][column].setPicture(matrixOfMap[row][column]);
                this.tiles[row][column].setTilePosition(posX, posY);
                posX += this.tiles[row][column].getLengthOfTile();
            }
            posY += this.tiles[row][0].getLengthOfTile();
            posX = this.positionX;
        }
        this.putPlayer(this.tiles[0][0].getLengthOfTile());
        this.setSurroundings();
    }

    private void setSurroundings() {
        for (int row = 1; row < this.tiles.length - 1; row++) {
            for (int column = 1; column < this.tiles[row].length - 1; column++) {
                if ((row > 1 && row < this.tiles.length - 1) && (column > 1 && column < this.tiles.length - 1 )) {
                    this.tiles[row][column].addSurrounding(this.tiles[row][column - 1]);
                    this.tiles[row][column].addSurrounding(this.tiles[row][column + 1]);
                    this.tiles[row][column].addSurrounding(this.tiles[row - 1][column]);
                    this.tiles[row][column].addSurrounding(this.tiles[row + 1][column]);
                }
            }
        }
    }
    private void putPlayer(int lengthOfTile) {
        List<Integer> spawn = this.map.generatePlayerSpawn();
        int x = spawn.getFirst();
        int y = spawn.getLast();

        Player player = new Player(x, y, this);
    }

    public Tile[][] getAllTiles() {
        return this.tiles;
    }

    public int getPositionX() {
        return this.positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }
}
