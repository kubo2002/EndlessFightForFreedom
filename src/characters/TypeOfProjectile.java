package characters;
/**
 * Enum TypeOfProjectile predstavuje rôzne typy striel v hre.
 * Každý typ strely má svoje unikátne vlastnosti, ako je cesta k obrázku, poškodenie a rýchlosť.
 *
 * @autor Jakub Gubany
 */
public enum TypeOfProjectile {
    WITCH_PROJECTILE("witch_projectile", 1, 30); // typ projektilu carodejnice
    private final String path;  // cesta k suboru
    private final Double damage; // poskodenie
    private final int speed; // rychlost pohybu
    /**
     * Konštruktor pre enum TypeOfProjectile.
     *
     * @param path cesta k obrázku strely
     * @param damage poškodenie spôsobené strelou
     * @param speed rýchlosť strely
     */
    TypeOfProjectile(String path, double damage, int speed) {
        this.path = path;
        this.damage = damage;
        this.speed = speed;
    }
    /**
     * Získa cestu k obrázku strely.
     *
     * @return cesta k obrázku strely
     */
    public String getPath() {
        return this.path;
    }
    /**
     * Získa poškodenie spôsobené strelou.
     *
     * @return poškodenie spôsobené strelou
     */
    public Double getDamage() {
        return this.damage;
    }
    /**
     * Získa rýchlosť strely.
     *
     * @return rýchlosť strely
     */
    public int getSpeed() {
        return this.speed;
    }
}
