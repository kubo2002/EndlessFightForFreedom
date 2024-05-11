package characters;

public enum TypeOfProjectile {
    WITCH_PROJECTILE("witch_projectile");
    private final String path;
    TypeOfProjectile(String path) {
        this.path = path;
    }
    public String getPath() {
        return this.path;
    }
}
