package characters;

/**
 * Enum TypeOfPerson predstavuje rôzne typy postáv v hre.
 * Každý typ postavy má svoje unikátne vlastnosti, ako je názov, počet snímok, základné poškodenie, základné HP a rýchlosť.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfPerson {
    KNIGHT("knight", 2, 2.5, 50, 90),  //typ hraca s vymenovanymi vlastnostami.
    MERCHANT("merchant", 2, 0, 999, 0), //typ obchodnika s vymenovanymi vlastnostami.
    WITCH("witch", 2, 3, 40, 90), //typ carodejnice s vymenovanymi vlastnostami.
    SKELETON("skeleton", 2, 3, 50, 90); //typ kostlivca s vymenovanymi vlastnostami.
    private final String name; //nazov obrazka prefix
    private final int numberOfFrames; // pocet snimkov
    private final double baseDamage; // zakladne poskodenie
    private final double baseHp; // zakladny pocet zivotov
    private final int speed; // rychlost pohybu

    /**
     * Konštruktor pre enum TypeOfPerson.
     *
     * @param name názov typu postavy
     * @param numberOfFrames počet snímok animácie
     * @param baseDamage základné poškodenie
     * @param baseHp základné hp
     * @param speed rýchlosť postavy
     */
    TypeOfPerson(String name, int numberOfFrames, double baseDamage, double baseHp, int speed) {
        this.name = name;
        this.numberOfFrames = numberOfFrames;
        this.baseDamage = baseDamage;
        this.baseHp = baseHp;
        this.speed = speed;
    }
    /**
     * Získa názov typu postavy.
     *
     * @return názov typu postavy
     */
    public String getName() {
        return this.name;
    }
    /**
     * Získa počet snímok animácie.
     *
     * @return počet snímok animácie
     */
    public int getNumberOfFrames() {
        return this.numberOfFrames;
    }
    /**
     * Získa základné poškodenie postavy.
     *
     * @return základné poškodenie postavy
     */
    public double getBaseDamage() {
        return this.baseDamage;
    }
    /**
     * Získa základné hp postavy.
     *
     * @return základné hp postavy
     */
    public double getBaseHp() {
        return this.baseHp;
    }
    /**
     * Získa rýchlosť postavy.
     *
     * @return rýchlosť postavy
     */
    public int getSpeed() {
        return this.speed;
    }

}
