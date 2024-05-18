package characters;

public enum TypeOfProjectile {
    WITCH_PROJECTILE("witch_projectile", 1, 30);
    private final String path;
    private final Double damage;
    private final int speed;
    TypeOfProjectile(String path, double damage, int speed) {
        this.path = path;
        this.damage = damage;
        this.speed = speed;
    }
    public String getPath() {
        return this.path;
    }
    public Double getDamage() {
        return this.damage;
    }
    public int getSpeed() {
        return this.speed;
    }
}
