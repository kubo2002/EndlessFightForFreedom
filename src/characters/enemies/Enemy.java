package characters.enemies;

import characters.Actions;
import characters.Person;
import characters.player.Player;
import characters.TypeOfPerson;
import fri.shapesge.Manager;
import inventory.items.Coins;
import java.util.Optional;

/**
 * Trieda reprezentujuca nepriatela s jeho charakteristickymi vlastnostami.
 *
 * Z triedy dalej dedia vlastnosti potomkovia, t.j. konkretni nepriatelia.
 *
 * @author Jakub Gubany
 */
public class Enemy extends Person implements Actions {
    private Player target;
    private double damage;
    private Manager manager;

    /**
     * Konstruktor triedy Enemy.
     *
     * @param type typ postavy nepriatela, ktora sa ma vytvorit v hre.
     * @param target ciel na ktory nepritel celu hru utoci
     *
     */
    public Enemy(TypeOfPerson type, Player target) {
        super(type);
        this.target = target;
        this.damage = super.getType().getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    /**
     * Hybe postavou po platne do urcenych smerov.
     *
     */
    public void move() {
        if (super.getState()) {
            if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.direction(1, 0);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.direction(1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.direction(-1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.direction(-1, 0);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.direction(1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.direction(-1, 0);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
                super.direction(0, 1);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
                super.direction(0, -1);
            }
        }
    }

    /**
     * Nasmeruje postavu do urceneho smeru podla ciela oponenta.
     *
     * @param cX konstanta, ktorou metoda nasobi suradnice na ose X, podla toho kde sa nachadza nepriatel.
     * @param cY konstanta, ktorou metoda nasobi suradnice na ose Y, podla toho kde sa nachadza nepriatel.
     *
     */
    public void direction(int cX, int cY) {
        super.direction(cX, cY);
    }

    /**
     *
     * Kazdy nepriatel po ukonceni zivotneho cyklu zanecha na svojom mieste mince.
     *
     */
    public void placeCoin() {
        Coins coins = new Coins(super.getPositionX(), super.getPositionY());
        super.getCurrentTile().setItem(Optional.of(coins));
    }

    /**
     * Pristupova metoda k triede oponenta.
     *
     * @return Player (trieda reprezentujuca hraca.)
     *
     */
    public Player getTarget() {
        return this.target;
    }

    /**
     * Vykona utok na oponenta.
     *
     * @param person oponent ktory implementuje rovnake rozhranie.
     *
     */
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }
    /**
     * Prijme poskodenie od oponenta.
     *
     * @param damage hodnota poskodenia, ktore postava prijme od oponenta.
     *
     */
    @Override
    public void receiveAttack(double damage) {
        if (super.getHpBar().isAlive()) {
            super.getHpBar().subtractLife(damage);
        } else {
            super.setState(false);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            this.placeCoin();
            this.getTarget().getScoreBoard().addScore();
        }
    }
}
