package characters;

import fri.shapesge.Manager;
import room.Room;

import java.util.ArrayList;

public class Witch extends Person implements Actions {
    private Manager manager;
    private double damage;
    private ArrayList<Projectile> firedProjectiles;
    private Player target;
    public Witch(int positionX, int positionY, Room currentRoom, Player target) {
        super(TypeOfPerson.WITCH, currentRoom);
        super.setPosition(positionX, positionY);
        this.firedProjectiles = new ArrayList<>();
        this.target = target;
        this.damage = TypeOfPerson.WITCH.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.deleteProjectiles();
    }

    //TODO skraslit vetvy ifov
    public void tick() {
        if (this.target.getPositionX()  == super.getPositionX()) {
            Projectile projectile = new Projectile(TypeOfProjectile.WITCH_PROJECTILE, this, this.target);

            if (this.target.getPositionY() < super.getPositionY()) {
                projectile.setPosition(super.getPositionX(), super.getPositionY() - 1);
            }
            if (this.target.getPositionY() > super.getPositionY()) {
                projectile.setPosition(super.getPositionX(), super.getPositionY() + 1);
            }
            projectile.moveProjectile();
            this.firedProjectiles.add(projectile);


        } else if (this.target.getPositionY() == super.getPositionY()) {

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

    public void deleteProjectiles() {
        for (int i = 0; i < this.firedProjectiles.size(); i++) {
            if (!this.firedProjectiles.get(i).getState()) {
                var projectile = this.firedProjectiles.get(i);
                projectile = null;
                this.firedProjectiles.remove(projectile);
            }
        }
    }
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }

    @Override
    public void receiveAttack(double damage) {

    }

    @Override
    public void die() {

    }
}
