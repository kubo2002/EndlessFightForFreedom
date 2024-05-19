package room;

/**
 * Enumeratívny typ TileType definuje rôzne typy dlaždíc v hre.
 * Každý typ má priradenú cestu k obrázku a stav obsadenosti.
 *
 * @autor Jakub Gubany
 */
public enum TileType {
    STONE_WALL("images/walls/stonewall.png", true),
    DOORS("images/walls/closeDoors.png", true),
    DIRT_FLOWERS("images/surface/dirtblock_clean.png", false),
    DIRT_CLEAN("images/surface/dirtblock_flowers.png", false),
    DIRT_GRASS("images/surface/dirtblock_grass.png", false);

    private final String path;
    private final boolean isOccupied;

    /**
     * Konštruktor vytvára nový typ dlaždice s danou cestou k obrázku a stavom obsadenosti.
     *
     * @param path      cesta k obrázku dlaždice
     * @param isOccupied stav obsadenosti dlaždice
     */
    TileType(String path, boolean isOccupied) {
        this.path = path;
        this.isOccupied = isOccupied;
    }
    /**
     * Získa cestu k obrázku dlaždice.
     *
     * @return cesta k obrázku dlaždice
     */
    public String getPath() {
        return this.path;
    }

    /**
     * Zistí, či je dlaždica obsadená.
     *
     * @return true, ak je dlaždica obsadená, inak false
     */
    public boolean isOccupied() {
        return this.isOccupied;
    }

}
