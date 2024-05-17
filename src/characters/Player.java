package characters;

import fri.shapesge.Manager;
import inventory.*;
import room.Market;
import room.ScoreBoard;
import room.Tile;

public class Player extends Person implements Actions {
    private Manager manager;
    private Inventory inventory;
    private ScoreBoard score;
    private int amountOfCoins; //TODO pridat zbieranie minci
    private double damage;
    private static Player player = new Player();
    private Player() {
        super(TypeOfPerson.KNIGHT);
        this.damage = TypeOfPerson.KNIGHT.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.inventory = Inventory.getInstance();
        this.inventory.drawInventoryOnScreen();
        this.score = new ScoreBoard(0, 50);
        this.score.showScoreOnScreen(true);
    }

    public static Player getInstance() {
        return player;
    }
    public void moveUp() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, -90);
            super.setPositionY(super.getPositionY() - 1);
            super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveDown() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(0, 90);
            super.setPositionY(super.getPositionY() + 1);
            super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);

        }
    }
    public void moveLeft() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(-90, 0);
            super.setPositionX(super.getPositionX() - 1);
            super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), true);
        }
    }
    public void moveRight() {
        if (super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), false);
            super.moveImage(90, 0);
            super.setPositionX(super.getPositionX() + 1);
            super.getCurrentRoom().getAllTiles()[super.getPositionY()][super.getPositionX()].setCharacter(this);
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
                merchant.setPlayersBank(this.score.getBank());
                merchant.getOffer();
            }
        }
    }
    public void buyItem(Item item) {
        this.score.subtractCoins(item.getCost());
    }
    public void useItem(Item item) {
        if (item instanceof Spell) {
            super.getHpBar().heal(item.getPower());
        } else if (item instanceof Weapon) {
            this.damage = item.getPower();
        }
    }
    public void checkTarget(int x, int y) {
        int clickedX = (x - 45) / 90;
        int clickedY = (y - 45) / 90;

        for (Tile tile : super.getCurrentRoom().getSurroundings(this.getPositionX(), this.getPositionY())) {
            if ((tile.getPositionX() - 45) / 90 == clickedX && (tile.getPositionY() - 45) / 90 == clickedY && tile.isOccupied()) {
                if (tile.getCharacter().isPresent()) {
                    this.performAttack(tile.getCharacter().get());
                }
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
        //TODO dokoncit co sa ma stat ked zomrie hrdina
    }

    @Override
    public void die() {
        super.getHpBar().hideHpBar();
        super.getImage().makeInvisible();
        //TODO dorobit garbage collector
    }

}
