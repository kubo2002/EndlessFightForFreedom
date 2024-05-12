package characters;

import fri.shapesge.Manager;
import inventory.Inventory;
import room.Market;
import room.Room;

public class Player extends Person implements Actions {
    private Manager manager;
    private Inventory inventory;
    private int amountOfCoins; //TODO pridat zbieranie minci
    private double damage;
    public Player(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.KNIGHT, currentRoom);
        super.setPosition(positionX, positionY);
        this.damage = TypeOfPerson.KNIGHT.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.inventory = new Inventory();
    }

    public void moveUp() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, -90);
            super.setPositionY(super.getPositionY() - 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveDown() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, 90);
            super.setPositionY(super.getPositionY() + 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveLeft() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(-90, 0);
            super.setPositionX(super.getPositionX() - 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveRight() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(90, 0);
            super.setPositionX(super.getPositionX() + 1);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }

    public void wakeMerchantUp(int x, int y) {
        int clickedX = (x - this.getCurrentRoom().getPositionX()) / this.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();
        int clickedY = (y - this.getCurrentRoom().getPositionY()) / this.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();

        if (super.getCurrentRoom() instanceof Market) {
            var market = (Market)super.getCurrentRoom();
            var merchant = market.getMerchant();
            if (clickedX == merchant.getPositionX() && clickedY == merchant.getPositionY()) {
                merchant.setPlayersBank(50);
                merchant.getOffer();
            }
        }
    }

    public void buyItem(int x, int y) {
        int clickedX = (x - this.getCurrentRoom().getPositionX()) / this.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();
        int clickedY = (y - this.getCurrentRoom().getPositionY()) / this.getCurrentRoom().getAllTiles()[0][0].getLengthOfTile();

    }
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }

    @Override
    public void receiveAttack(double damage) {
        super.getHpBar().subtractLife(damage);
        //TODO dokoncit co sa ma stat ked zomrie hrdina
    }

    @Override
    public void die() {
        super.getHpBar().hideHpBar();
        super.getImage().makeInvisible();
        //TODO dorobit garbage collector
    }

}
