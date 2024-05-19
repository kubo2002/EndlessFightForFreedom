package inventory;

/**
 * Enumerativny typ TypeOfItem definuje rozne typy predmetov v hre.
 * Kazdy typ ma priradenu cestu k obrazku, kategoriu, silu, cenu a maximalny pocet pouziti.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfItem {
    HEAL_1("healingSpell_1", "spells",  30.0, 10, 1), // jeden z moznych typov healing spellu
    HEAl_2("healingSpell_2", "spells",  60.0, 20, 1), // jeden z moznych typov healing spellu
    HEAl_3("healingSpell_3", "spells",  90.0, 30, 1), // jeden z moznych typov healing spellu
    SWORD_1("sword_1", "swords", 50, 20, 10), // jeden z moznych typov healing swordu
    SWORD_2("sword_2", "swords", 100, 50, 5), // jeden z moznych typov healing swordu
    COINS("coins", "coins", 20, 0, 1); // mince
    private final String path; // cesta k obrazku
    private final String category; // nazov balicka v ktorom treba hladat
    private final double power; // sila itemu
    private final double cost; // cena itemu v shope
    private final int maxUse; // maximalny mozny pocet pouitia jedneho itemu

    /**
     * Konstruktor enum triedy.
     *
     * @param path cesta k obrázku.
     * @param category kategoria v ktorej sa ma obrazok hladat.
     * @param power sila premdetu.
     * @param cost cena predmetu v obchode.
     * @param maxUse maximalny pocet pouziti itemu.
     */
    TypeOfItem(String path, String category, double power, double cost, int maxUse) {
        this.path = path;
        this.power = power;
        this.cost = cost;
        this.category = category;
        this.maxUse = maxUse;
    }
    /**
     * Vráti cenu predmetu.
     *
     * @return cena predmetu
     */
    public double getCost() {
        return this.cost;
    }
    /**
     * Vráti cestu k obrázku predmetu.
     *
     * @return cesta k obrázku
     */
    public String getPath() {
        return this.path;
    }
    /**
     * Vráti silu predmetu.
     *
     * @return sila predmetu
     */
    public double getPower() {
        return this.power;
    }
    /**
     * Vráti kategóriu predmetu.
     *
     * @return kategória predmetu
     */
    public String getCategory() {
        return this.category;
    }
    /**
     * Vráti maximálny počet použití predmetu.
     *
     * @return maximálny počet použití
     */
    public int getMaxUse() {
        return this.maxUse;
    }
}
