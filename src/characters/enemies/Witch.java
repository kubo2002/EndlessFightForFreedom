package characters.enemies;

import characters.*;
import characters.player.Player;

import java.util.ArrayList;

/**
 * Trieda reprezentujuca nepriatela (Witch).
 *
 * @author Jakub Gubany
 *
 */
public class Witch extends Enemy {
    private ArrayList<Projectile> firedProjectiles;

    /**
     * Konstruktor triedy Witch.
     *
     * @param target Ciel t.j. hrac po ktorom bude Witch utocit strielanim projektilov.
     */
    public Witch(Player target) {
        super(TypeOfPerson.WITCH, target);
        this.firedProjectiles = new ArrayList<>();
        this.deleteProjectiles();
    }

    /**
     * Zameriava v pravidelnych casovych intervaloch hraca a striela po nom projektily.
     */
    public void tick() {
        if (super.getState()) {
            if (super.getTarget().getPositionX() == super.getPositionX()) {
                this.shootProjectile(super.getTarget().getPositionY(), super.getPositionY(), 0, -1);
            } else if (super.getTarget().getPositionY() == super.getPositionY()) {
                this.shootProjectile(super.getTarget().getPositionX(), super.getPositionX(), -1, 0);
            }
        }
    }

    /**
     * Zamieri projektil podla polohy hraca a nepriatel po nom vystreli
     *
     * @param targetPosition zamierena pozicia hraca
     * @param currentPosition aktualna pozicia nepriatela
     * @param cX konstanta ktorou sa prenasobia pozicie podla toho, do ktorej strany sa ma hybat projektil
     * @param cY konstanta ktorou sa prenasobia pozicie podla toho, do ktorej strany sa ma hybat projektil
     */
    private void shootProjectile(int targetPosition, int currentPosition, int cX, int cY) {
        if (this.firedProjectiles.size() < 5) {
            Projectile projectile = new Projectile(TypeOfProjectile.WITCH_PROJECTILE, this, super.getTarget());
            if (targetPosition < currentPosition) {
                projectile.setPosition(super.getPositionX() + cX, super.getPositionY() + cY);
            }
            if (targetPosition > currentPosition) {
                projectile.setPosition(super.getPositionX() - cX, super.getPositionY() - cY);
            }
            projectile.moveProjectile();
            this.firedProjectiles.add(projectile);
        }
    }

    /**
     * Hybe postavou do urcenych smerov.
     *
     * Witch sa hybe horizontalne alebo vertiklne.
     *
     */
    @Override
    public void move() {
        this.tick();
        super.move();
    }

    /**
     *
     * Premazava zbytocne neaktivne projektily.
     *
     */
    public void deleteProjectiles() {
        for (int i = 0; i < this.firedProjectiles.size(); i++) {
            if (!super.getState()) {
                var projectile = this.firedProjectiles.get(i);
                projectile = null;
                this.firedProjectiles.remove(i);
            } else if (!this.firedProjectiles.get(i).getState()) {
                var projectile = this.firedProjectiles.get(i);
                projectile = null;
                this.firedProjectiles.remove(i);
            }
        }
    }

    /**
     *
     * Vykona utok na oponenta.
     *
     * @param person postava na ktoru sa utoci.
     *
     */
    @Override
    public void performAttack(Actions person) {
        super.performAttack(person);
    }

    /**
     *
     * Prijme poskodenie od oponenta.
     *
     * @param damage double hodnota poskodenia.
     *
     */
    @Override
    public void receiveAttack(double damage) {
        super.receiveAttack(damage);
    }
}
