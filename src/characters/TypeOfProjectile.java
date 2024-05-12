package characters;

public enum TypeOfProjectile {
    WITCH_PROJECTILE("witch_projectile", 2.5);
    private final String path;
    private final Double damage;
    TypeOfProjectile(String path, double damage) {
        this.path = path;
        this.damage = damage;
    }
    public String getPath() {
        return this.path;
    }
    public Double getDamage() {
        return this.damage;
    }
}
