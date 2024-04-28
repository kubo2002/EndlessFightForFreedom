package room;

public enum TileType {
    STONE_WALL("images/walls/stonewall.png", 1, true),
    DIRT_FLOWERS("images/surface/dirtblock_clean.png", 2, false),
    DIRT_CLEAN("images/surface/dirtblock_flowers.png", 3, false),
    DIRT_GRASS("images/surface/dirtblock_grass.png", 4, false),
    INVENTORY_SLOT("images/inventorySlots/inventorySlot.png", 0, true);

    private final String path;
    private final int idNumber;
    private final boolean isOccupied;

    public boolean isOccupied() {
        return this.isOccupied;
    }

    TileType(String path, int idNumber, boolean isOccupied) {
        this.path = path;
        this.idNumber = idNumber;
        this.isOccupied = isOccupied;
    }

    public String getPath() {
        return this.path;
    }

    public int getID() {
        return this.idNumber;
    }
}
