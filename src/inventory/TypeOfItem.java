package inventory;

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
    TypeOfItem(String path, String category, double power, double cost, int maxUse) {
        this.path = path;
        this.power = power;
        this.cost = cost;
        this.category = category;
        this.maxUse = maxUse;
    }
    public double getCost() {
        return this.cost;
    }
    public String getPath() {
        return this.path;
    }
    public double getPower() {
        return this.power;
    }
    public String getCategory() {
        return this.category;
    }
    public int getMaxUse() {
        return this.maxUse;
    }
}
