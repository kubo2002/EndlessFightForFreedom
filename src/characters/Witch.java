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
    }

    public void tick() {
        if (this.target.getPositionX()  == super.getPositionX() || this.target.getPositionY() == super.getPositionY()) {
            System.out.println(String.format("je v ceste | moja x : %d | jeho x : %d", super.getPositionX(), this.target.getPositionX()));
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
