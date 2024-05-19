package room;

import characters.Actions;
import characters.Person;
import characters.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    private Tile[][] tiles;
    private Door door;
    private ArrayList<Person> spawnedCharacters;
    public Room(TypeOfRoom roomType) {
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
        this.tiles = new Tile[roomType.getNumberOfTilesX()][roomType.getNumberOfTilesY()];
        this.spawnedCharacters = new ArrayList<>();

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
                this.tiles[row][column].show();
                posX += this.tiles[row][column].getLengthOfTile();
            }
            posY += this.tiles[row][0].getLengthOfTile();
            posX = this.positionX;
        }
        this.setSurroundings();
    }
    public void hideMap() {
        for (int i = 0; i < this.spawnedCharacters.size(); i++) {
            if (this.spawnedCharacters.get(i) instanceof Player) {
                this.spawnedCharacters.get(i).hide();
            } else {
                this.spawnedCharacters.get(i).setState(false);
            }
        }
        this.door = null;
        for (Tile[] row : this.tiles) {
            for (Tile tile : row) {
                tile.hide();
            }
        }
        this.tiles = new Tile[this.roomType.getNumberOfTilesX()][this.roomType.getNumberOfTilesY()];
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
                    if (row - 1 > 0) {
                        this.tiles[row][column].addSurrounding(this.tiles[row - 1][column - 1]);
                    }
                    if (row + 1 <= this.tiles.length) {
                        this.tiles[row][column].addSurrounding(this.tiles[row + 1][column - 1]);
                    }
                }
                if (column + 1 <= this.tiles[row].length) {
                    this.tiles[row][column].addSurrounding(this.tiles[row][column + 1]);
                    if (row - 1 > 0) {
                        this.tiles[row][column].addSurrounding(this.tiles[row - 1][column + 1]);
                    }
                    if (row + 1 <= this.tiles.length) {
                        this.tiles[row][column].addSurrounding(this.tiles[row + 1][column + 1]);
                    }
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
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public void addCharacter(Person person) {
        this.spawnedCharacters.add(person);
    }
    public TypeOfRoom getRoomType() {
        return this.roomType;
    }
    public List<Tile> getSurroundings(int x, int y) {
        return Collections.unmodifiableList(this.tiles[y][x].getSurroundings());
    }
    public void setCharacterOnTile(int x, int y, Person character) {
        var c = (Actions)character;
        this.tiles[y][x].setCharacter(c);
    }
    public void setOccupiedTile(int x, int y, boolean occupied) {
        this.tiles[y][x].setOccupied(occupied);
    }
    public List<Person> deleteCharacters() {
        Iterator<Person> characters = this.spawnedCharacters.iterator();
        ArrayList<Person> deleted = new ArrayList<>();

        while (characters.hasNext()) {
            Person p = characters.next();
            if (!p.getState()) {
                p.hide();
                deleted.add(p);
                characters.remove();
                p = null;
            }
        }
        return Collections.unmodifiableList(deleted);
    }
    public Tile getTile(int x, int y) {
        return this.tiles[y][x];
    }
}
