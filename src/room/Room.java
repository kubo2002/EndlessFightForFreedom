package room;

import characters.Actions;
import characters.Person;
import characters.player.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * Abstraktna trieda Room reprezentuje miestnost v hre.
 * Spravuje rozlozenie dlazdic, postav a zobrazovanie mapy.
 *
 * @autor Jakub Gubany
 */
public abstract class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    private Tile[][] tiles;
    private Door door;
    private ArrayList<Person> spawnedCharacters;
    /**
     * Konstruktor vytvori miestnost so zadanym typom.
     *
     * @param roomType typ miestnosti
     */
    public Room(TypeOfRoom roomType) {
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
        this.tiles = new Tile[roomType.getNumberOfTilesX()][roomType.getNumberOfTilesY()];
        this.spawnedCharacters = new ArrayList<>();

    }
    /**
     * Abstraktna metoda na spawnovanie postav v miestnosti.
     * Podtriedy musia poskytnut implementaciu.
     */
    public abstract void spawnCharacters();
    /**
     * Zobrazi mapu nastavenim dlazdic a ich pozicii.
     * Tiez identifikuje a nastavuje poziciu dveri.
     */
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
                posX += 90;
            }
            posY += 90;
            posX = this.positionX;
        }
        this.setSurroundings();
    }
    /**
     * Skryje mapu a postavy, resetuje stav miestnosti.
     */
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
    /**
     * Nastavi okolite dlazdice pre kazdu dlazdicu v miestnosti.
     * Tato metoda funguje spravne len pre stvorcove miestnosti.
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
    /**
     * Skontroluje, ci je mozne presunut sa na dlazdicu na zadanych suradniciach.
     *
     * @param x x-suradnica dlazdice
     * @param y y-suradnica dlazdice
     * @return true, ak dlazdica nie je obsadena, inak false
     */
    public boolean isAbleToMove(int x, int y) {
        return !this.tiles[y][x].isOccupied();
    }
    /**
     * Ziska x-poziciu miestnosti.
     *
     * @return x-pozicia miestnosti
     */
    public int getPositionX() {
        return this.positionX;
    }
    /**
     * Ziska y-poziciu miestnosti.
     *
     * @return y-pozicia miestnosti
     */
    public int getPositionY() {
        return this.positionY;
    }
    /**
     * Prida postavu do miestnosti.
     *
     * @param person postava, ktoru treba pridat
     */
    public void addCharacter(Person person) {
        this.spawnedCharacters.add(person);
    }
    /**
     * Ziska typ miestnosti.
     *
     * @return typ miestnosti
     */
    public TypeOfRoom getRoomType() {
        return this.roomType;
    }
    /**
     * Ziska okolite dlazdice dlazdice na zadanych suradniciach.
     *
     * @param x x-suradnica dlazdice
     * @param y y-suradnica dlazdice
     * @return nemodifikovatelny zoznam okolitych dlazdic
     */
    public List<Tile> getSurroundings(int x, int y) {
        return Collections.unmodifiableList(this.tiles[y][x].getSurroundings());
    }
    /**
     * Nastavi postavu na dlazdicu na zadanych suradniciach.
     *
     * @param x x-suradnica dlazdice
     * @param y y-suradnica dlazdice
     * @param character postava, ktoru treba nastavit na dlazdicu
     */
    public void setCharacterOnTile(int x, int y, Person character) {
        var c = (Actions)character;
        this.tiles[y][x].setCharacter(c);
    }
    /**
     * Nastavi stav obsadenosti dlazdice na zadanych suradniciach.
     *
     * @param x x-suradnica dlazdice
     * @param y y-suradnica dlazdice
     * @param occupied stav obsadenosti dlazdice
     */
    public void setOccupiedTile(int x, int y, boolean occupied) {
        this.tiles[y][x].setOccupied(occupied);
    }
    /**
     * Odstrani postavy, ktore nie su aktivne (ich stav je false), a vrati zoznam odstranenych postav.
     *
     * @return nemodifikovatelny zoznam odstranenych postav
     */
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
    /**
     * Ziska dlazdicu na zadanych suradniciach.
     *
     * @param x x-suradnica dlazdice
     * @param y y-suradnica dlazdice
     * @return dlazdica na zadanych suradniciach
     */
    public Tile getTile(int x, int y) {
        return this.tiles[y][x];
    }
}
