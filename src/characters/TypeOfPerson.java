package characters;

public enum TypeOfPerson {
    KNIGHT("knight", 2, 2.5, 50, 90),
    MERCHANT("merchant", 2, 0, 999, 0),
    WITCH("witch", 2, 3, 40, 90),
    SKELETON("skeleton", 2, 3, 50, 90);
    private final String name;
    private final int numberOfFrames;
    private final double baseDamage;
    private final double baseHp;
    private final int speed;
    TypeOfPerson(String name, int numberOfFrames, double baseDamage, double baseHp, int speed) {
        this.name = name;
        this.numberOfFrames = numberOfFrames;
        this.baseDamage = baseDamage;
        this.baseHp = baseHp;
        this.speed = speed;
    }
    public String getName() {
        return this.name;
    }
    public int getNumberOfFrames() {
        return this.numberOfFrames;
    }
    public double getBaseDamage() {
        return this.baseDamage;
    }
    public double getBaseHp() {
        return this.baseHp;
    }
    public int getSpeed() {
        return this.speed;
    }

}
