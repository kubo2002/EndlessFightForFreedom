package room;

/**
 * Enumeratívny typ TypeOfRoom definuje rôzne typy miestností v hre.
 * Každý typ miestnosti má priradený počet dlaždíc na osi X a osi Y.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfRoom {
    MARKET(5, 5),
    BATTLEGROUND(10, 10),
    TEMPLE(5, 5);

    private final int numberOfTilesX;
    private final int numberOfTilesY;

    /**
     * Konštruktor vytvára nový typ miestnosti s daným počtom dlaždíc na osi X a osi Y.
     *
     * @param numberOfTilesX počet dlaždíc na osi X
     * @param numberOfTilesY počet dlaždíc na osi Y
     */
    TypeOfRoom(int numberOfTilesX, int numberOfTilesY) {
        this.numberOfTilesX = numberOfTilesX;
        this.numberOfTilesY = numberOfTilesY;
    }
    /**
     * Získa počet dlaždíc na osi X pre daný typ miestnosti.
     *
     * @return počet dlaždíc na osi X
     */
    public int getNumberOfTilesX() {
        return this.numberOfTilesX;
    }
    /**
     * Získa počet dlaždíc na osi Y pre daný typ miestnosti.
     *
     * @return počet dlaždíc na osi Y
     */
    public int getNumberOfTilesY() {
        return this.numberOfTilesY;
    }
}
