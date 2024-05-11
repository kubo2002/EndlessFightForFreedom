package characters;

public enum TypeOfPerson {
    KNIGHT("knight", 2, 2.5, 50),
    MERCHANT("merchant", 2, 0, 999),
    WITCH("witch", 2, 3, 40);
    private final String name;
    private final int numberOfFrames;
    private final double baseDamage;
    private final double baseHp;
    TypeOfPerson(String name, int numberOfFrames, double baseDamage, double baseHp) {
        this.name = name;
        this.numberOfFrames = numberOfFrames;
        this.baseDamage = baseDamage;
        this.baseHp = baseHp;
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

}
