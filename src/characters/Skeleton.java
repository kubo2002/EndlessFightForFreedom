package characters;

import fri.shapesge.Manager;

public class Skeleton extends Person implements Actions, Enemy {
    private Manager manager;
    private double damage;
    private Player target;
    public Skeleton(Player player) {
        super(TypeOfPerson.SKELETON);
        this.target = player;
        this.damage = TypeOfPerson.SKELETON.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
    }

    @Override
    public void move() {
        if (super.getState()) {
            if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY() + 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), this.getType().getSpeed());
                super.setPositionX(super.getPositionX() + 1);
                super.setPositionY(super.getPositionY() + 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY() - 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), -this.getType().getSpeed());
                super.setPositionX(super.getPositionX() + 1);
                super.setPositionY(super.getPositionY() - 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY() + 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), this.getType().getSpeed());
                super.setPositionX(super.getPositionX() - 1);
                super.setPositionY(super.getPositionY() + 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY() - 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), -this.getType().getSpeed());
                super.setPositionX(super.getPositionX() - 1);
                super.setPositionY(super.getPositionY() - 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() + 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(-this.getType().getSpeed(), 0);
                super.setPositionX(super.getPositionX() - 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(0, this.getType().getSpeed());
                super.setPositionY(super.getPositionY() + 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
                this.moveImage(0, -this.getType().getSpeed());
                super.setPositionY(super.getPositionY() - 1);
                super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
                super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
            }
        }
    }

    @Override
    public void performAttack(Actions person) {

    }

    @Override
    public void receiveAttack(double damage) {
        super.getHpBar().subtractLife(damage);
    }

    @Override
    public void die() {

    }
}
