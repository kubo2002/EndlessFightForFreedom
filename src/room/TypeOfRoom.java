package room;

/**
 * Enumeratívny typ TypeOfRoom definuje rôzne typy miestností v hre.
 * Každý typ miestnosti má priradený počet dlaždíc na osi X a osi Y.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfRoom {
    MARKET(5, 5), // jeden z moznych typov miestnosti
    BATTLEGROUND(10, 10), // jeden z moznych typov miestnosti
    TEMPLE(5, 5); // jeden z moznych typov miestnosti

    private final int numberOfTilesX; // pocet dlazdic na ose X
    private final int numberOfTilesY; // pocet dlazdnic na ose Y

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
