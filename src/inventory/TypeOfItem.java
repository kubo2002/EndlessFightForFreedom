package inventory;

public enum TypeOfItem {
    HEAL("healingSpell", 0, 1);
    private final String path;
    private final double power;
    private final double cost;
    TypeOfItem(String path, double power, double cost) {
        this.path = path;
        this.power = power;
        this.cost = cost;
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
}
