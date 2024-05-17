package characters;

import fri.shapesge.Manager;
import java.util.ArrayList;

public class Witch extends Person implements Actions, Enemy {
    private Manager manager;
    private double damage;
    private ArrayList<Projectile> firedProjectiles;
    private Player target;

    public Witch(Player target) {
        super(TypeOfPerson.WITCH);
        this.firedProjectiles = new ArrayList<>();
        this.target = target;
        this.damage = TypeOfPerson.WITCH.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.deleteProjectiles();
    }

    //TODO skraslit vetvy ifov
    public void tick() {
        if (super.getState()) {
            if (this.target.getPositionX() == super.getPositionX()) {
                if (this.firedProjectiles.size() < 5) {
                    Projectile projectile = new Projectile(TypeOfProjectile.WITCH_PROJECTILE, this, this.target);
                    if (this.target.getPositionY() < super.getPositionY()) {
                        projectile.setPosition(super.getPositionX(), super.getPositionY() - 1);
                    }
                    if (this.target.getPositionY() > super.getPositionY()) {
                        projectile.setPosition(super.getPositionX(), super.getPositionY() + 1);
                    }
                    projectile.moveProjectile();
                    this.firedProjectiles.add(projectile);
                }
            } else if (this.target.getPositionY() == super.getPositionY()) {
                if (this.firedProjectiles.size() < 5) {
                    Projectile projectile = new Projectile(TypeOfProjectile.WITCH_PROJECTILE, this, this.target);
                    if (this.target.getPositionX() < super.getPositionX()) {
                        projectile.setPosition(super.getPositionX() - 1, super.getPositionY());
                    }
                    if (this.target.getPositionX() > super.getPositionX()) {
                        projectile.setPosition(super.getPositionX() + 1, super.getPositionY());
                    }
                    projectile.moveProjectile();
                    this.firedProjectiles.add(projectile);
                }
            }
        }
    }

    public void move() {
        this.tick();
        if (super.getState()) {
            if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() + 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() + 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() - 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() - 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() + 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() - 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(0, this.getType().getSpeed());
                super.setPositionY(super.getPositionY() + 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(0, -this.getType().getSpeed());
                super.setPositionY(super.getPositionY() - 1);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            }
        }
    }

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

    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }

    @Override
    public void receiveAttack(double damage) {
        super.getHpBar().subtractLife(damage);
    }

    @Override
    public void die() {
        super.getImage().makeInvisible();
    }
}
