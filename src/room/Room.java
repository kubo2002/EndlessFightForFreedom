package room;

public abstract class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    private Tile[][] tiles;
    private Door door;
    public Room(TypeOfRoom roomType) {
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
        this.tiles = new Tile[roomType.getNumberOfTilesX()][roomType.getNumberOfTilesY()];
    }

    public abstract void spawnCharacters();
    public void showMap() {
        int[][] matrixOfMap = this.map.createMap();
        int posX = this.positionX;
        int posY = this.positionY;

        for (int row = 0; row < matrixOfMap.length; row++) {
            for (int column = 0; column < matrixOfMap[row].length; column++) {
                this.tiles[row][column] = new Tile();
                this.tiles[row][column].setPicture(matrixOfMap[row][column]);
                if (this.tiles[row][column].areDoors()) {
                    this.door = new Door(column, row);
                }
                this.tiles[row][column].setTilePosition(posX, posY);
                posX += this.tiles[row][column].getLengthOfTile();
            }
            posY += this.tiles[row][0].getLengthOfTile();
            posX = this.positionX;
        }
        this.setSurroundings();
    }

    /***
     * Funguje len pre stvorcove
     *
     * Nastavi pre kazdu dlazdicu okolite dlazdice
     */
    private void setSurroundings() {
        for (int row = 1; row < this.tiles.length - 1; row++) {
            for (int column = 1; column < this.tiles[row].length - 1; column++) {
                if (column - 1 > 0) {
                    this.tiles[row][column].addSurrounding(this.tiles[row][column - 1]);
                }
                if (column + 1 <= this.tiles[row].length) {
                    this.tiles[row][column].addSurrounding(this.tiles[row][column + 1]);
                }
                if (row - 1 > 0) {
                    this.tiles[row][column].addSurrounding(this.tiles[row - 1][column]);
                }
                if (row + 1 <= this.tiles.length) {
                    this.tiles[row][column].addSurrounding(this.tiles[row + 1][column]);
                }
            }
        }
    }

    public boolean isAbleToMove(int x, int y) {
        return !this.tiles[y][x].isOccupied();
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
    public RoomGenerator getMap() {
        return this.map;
    }

}
