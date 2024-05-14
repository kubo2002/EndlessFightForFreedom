package room;

import characters.Enemy;
import characters.Person;
import characters.Player;

import java.util.ArrayList;

public abstract class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    private Tile[][] tiles;
    private Door door;
    private RoomManager roomManager;
    private Player player;
    private ArrayList<Enemy> livingEnemies;
    public Room(TypeOfRoom roomType, RoomManager roomManager) {
        this.roomManager = roomManager;
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
        this.tiles = new Tile[roomType.getNumberOfTilesX()][roomType.getNumberOfTilesY()];
        this.livingEnemies = new ArrayList<>();
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
                    this.door = new Door(column, row, this.roomManager);
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
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Player getPlayer() {
        return this.player;
    }
    public void hideMap() {
        for (Enemy enemy : this.livingEnemies) {
            if (enemy instanceof Person) {
                Person e = (Person)enemy;
                e = null;
            }
        }

        this.tiles = new Tile[this.roomType.getNumberOfTilesX()][this.roomType.getNumberOfTilesY()];
        this.door = null;

    }
    public void addEnemy(Enemy enemy) {
        this.livingEnemies.add(enemy);
    }
    public void removeEnemy(Enemy enemy) {
        this.livingEnemies.remove(enemy);
    }
    public ArrayList<Enemy> getLivingEnemies() {
        return this.livingEnemies;
    }

}
