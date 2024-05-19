package room;

import characters.Actions;
import fri.shapesge.Image;
import inventory.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Trieda reprezentuje dlaždicu v miestnosti.
 *
 * @autor Jakub Gubany
 */
public class Tile {
    private int positionX;
    private int positionY;
    private final int lengthOfTile = 90;
    private Image image;
    private boolean isOccupied;
    private Optional<Actions> character;
    private List<Tile> surroundings;
    private boolean areDoors;
    private Optional<Item> item;

    /**
     * Konštruktor triedy Tile.
     */
    public Tile() {
        this.surroundings = new ArrayList<>();
        this.character = Optional.empty();
        this.item = Optional.empty();
    }
    /**
     * Nastavuje obrázok dlaždice na základe zadaného typu.
     *
     * @param type typ dlaždice
     */
    public void setPicture(int type) {
        switch (type) {
            case 1:
                this.image = new Image(TileType.STONE_WALL.getPath());
                this.isOccupied = TileType.STONE_WALL.isOccupied();
                break;
            case 2:
                this.image = new Image(TileType.DIRT_FLOWERS.getPath());
                this.isOccupied = TileType.DIRT_FLOWERS.isOccupied();
                break;
            case 3:
                this.image = new Image(TileType.DIRT_CLEAN.getPath());
                this.isOccupied = TileType.DIRT_CLEAN.isOccupied();
                break;
            case 4:
                this.image = new Image(TileType.DIRT_GRASS.getPath());
                this.isOccupied = TileType.DIRT_GRASS.isOccupied();
                break;
            case 6:
                this.image = new Image(TileType.DOORS.getPath());
                this.isOccupied = TileType.DOORS.isOccupied();
                this.areDoors = true;
                break;
        }
    }
    /**
     * Nastavuje pozíciu dlaždice.
     *
     * @param x x-ová pozícia dlaždice
     * @param y y-ová pozícia dlaždice
     */
    public void setTilePosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.image.changePosition(this.positionX, this.positionY);
        this.image.makeVisible();
    }

    /**
     * Vráti pozíciu na ose X.
     *
     * @return int pozicia X.
     */
    public int getPositionX() {
        return this.positionX;
    }

    /**
     * Vráti pozíciu na ose Y.
     *
     * @return int pozícia Y.
     */
    public int getPositionY() {
        return this.positionY;
    }
    /**
     * Zistí, či je dlaždica obsadená.
     *
     * @return true, ak je dlaždica obsadená, inak false
     */
    public boolean isOccupied() {
        return this.isOccupied;
    }
    /**
     * Nastaví stav obsadenosti dlaždice.
     *
     * @param occupied true, ak je dlaždica obsadená, inak false
     */
    public void setOccupied(boolean occupied) {
        if (!occupied) {
            this.character = Optional.empty();
        }
        this.isOccupied = occupied;
    }
    /**
     * Nastaví postavu na dlaždicu.
     *
     * @param character postava, ktorá sa má nastaviť
     */
    public void setCharacter(Actions character) {
        this.character = Optional.of(character);
    }
    /**
     * Vráti postavu na dlaždici.
     *
     * @return postava na dlaždici
     */
    public Optional<Actions> getCharacter() {
        return this.character;
    }
    /**
     * Pridá okolité dlaždice.
     *
     * @param tile dlaždica, ktorá sa má pridať ako okolitá
     */
    public void addSurrounding(Tile tile) {
        this.surroundings.add(tile);
    }
    /**
     * Zistí, či sú na dlaždici dvere.
     *
     * @return true, ak sú na dlaždici dvere, inak false
     */
    public boolean areDoors() {
        return this.areDoors;
    }
    /**
     * Zobrazí dlaždicu.
     */
    public void show() {
        this.image.makeVisible();
    }
    /**
     * Skryje dlaždicu.
     */
    public void hide() {
        this.image.makeInvisible();
    }
    /**
     * Získava okolité dlaždice.
     *
     * @return neupraviteľný zoznam okolitých dlaždíc
     */
    public List<Tile> getSurroundings() {
        return Collections.unmodifiableList(this.surroundings);
    }
    /**
     * Získava item, ktorý leží na dlaždici.
     *
     * @return item na dlaždici
     */
    public Optional<Item> getItem() {
        return this.item;
    }
    /**
     * Nastaví item na dlaždicu.
     *
     * @param item item, ktorý sa má nastaviť
     */
    public void setItem(Optional<Item> item) {
        if (this.item.isEmpty()) {
            this.item = item;
            this.item.get().showItem();
        }
    }
}
