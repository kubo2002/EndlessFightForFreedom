package characters;

import fri.shapesge.Manager;
import inventory.Coins;
import room.Tile;

import java.util.Optional;

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
            this.findTarget();
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

    public void findTarget() {
        for (Tile tile : super.getCurrentRoom().getSurroundings(this.getPositionX(), this.getPositionY())) {
            if (tile.getCharacter().isPresent()) {
                this.performAttack(tile.getCharacter().get());
            }
        }
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
            super.hide();
            Coins coins = new Coins(super.getPositionX(), super.getPositionY());
            super.getCurrentTile().setItem(Optional.of(coins));
        }
    }

    @Override
    public void die() {

    }
}
