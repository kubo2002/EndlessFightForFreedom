package inventory;

/**
 * Enumerativny typ TypeOfItem definuje rozne typy predmetov v hre.
 * Kazdy typ ma priradenu cestu k obrazku, kategoriu, silu, cenu a maximalny pocet pouziti.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfItem {
    HEAL_1("healingSpell_1", "spells",  30.0, 10, 1),
    HEAl_2("healingSpell_2", "spells",  60.0, 20, 1),
    HEAl_3("healingSpell_3", "spells",  90.0, 30, 1),
    SWORD_1("sword_1", "swords", 50, 20, 10),
    SWORD_2("sword_2", "swords", 100, 50, 5),
    COINS("coins", "coins", 20, 0, 1);
    private final String path;
    private final String category;
    private final double power;
    private final double cost;
    private final int maxUse;

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
