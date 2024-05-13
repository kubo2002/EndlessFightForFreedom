package inventory;

public enum TypeOfItem {
    HEAL("healingSpell", "spells",  0, 1);
    private final String path;
    private final String category;
    private final double power;
    private final double cost;
    TypeOfItem(String path, String category, double power, double cost) {
        this.path = path;
        this.power = power;
        this.cost = cost;
        this.category = category;
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
}
