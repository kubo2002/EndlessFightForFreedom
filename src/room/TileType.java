package room;

public enum TileType {
    STONE_WALL("images/walls/stonewall.png", 1),
    DIRT_FLOWERS("images/surface/dirtblock_clean.png", 2),
    DIRT_CLEAN("images/surface/dirtblock_flowers.png", 3),
    DIRT_GRASS("images/surface/dirtblock_grass.png", 4),
    INVENTORY_SLOT("images/inventorySlots/inventorySlot.png", 0);

    private final String path;
    private final int idNumber;

    TileType(String path, int idNumber) {
        this.path = path;
        this.idNumber = idNumber;
    }

    public String getPath() {
        return this.path;
    }

    public int getID() {
        return this.idNumber;
    }
}
