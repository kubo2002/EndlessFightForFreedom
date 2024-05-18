package characters;

import fri.shapesge.Manager;
import inventory.Coins;
import java.util.Optional;

public class Enemy extends Person implements Actions {
    private Player target;
    private double damage;
    private Manager manager;
    public Enemy(TypeOfPerson type, Player target) {
        super(type);
        this.target = target;
        this.damage = super.getType().getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
    }
    public void move() {
        if (super.getState()) {
            if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                this.direction(1, 0);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                this.direction(1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                this.direction(-1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                this.direction(-1, 0);
            } else if (super.getPositionX() < this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                this.direction(1, 0);
            } else if (super.getPositionX() > this.target.getPositionX() && super.getPositionY() == this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                this.direction(-1, 0);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() < this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
                this.direction(0, 1);
            } else if (super.getPositionX() == this.target.getPositionX() && super.getPositionY() > this.target.getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
                this.direction(0, -1);
            }
        }
    }
    public void direction(int cX, int cY) {
        super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
        this.moveImage(cX * this.getType().getSpeed(), cY * this.getType().getSpeed());
        super.setPositionX(super.getPositionX() + cX);
        super.setPositionY(super.getPositionY() + cY);
        super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
        super.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
    }
    public void placeCoin() {
        Coins coins = new Coins(super.getPositionX(), super.getPositionY());
        super.getCurrentTile().setItem(Optional.of(coins));
    }
    public Player getTarget() {
        return this.target;
    }
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }
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
