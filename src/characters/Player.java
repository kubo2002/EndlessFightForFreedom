package characters;

import fri.shapesge.Manager;
import inventory.Inventory;
import room.Market;
import room.Room;
import room.ScoreBoard;

public class Player extends Person implements Actions {
    private Manager manager;
    private Inventory inventory;
    private ScoreBoard score;
    private int amountOfCoins; //TODO pridat zbieranie minci
    private double damage;
    public Player(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.KNIGHT, currentRoom);
        super.setPosition(positionX, positionY);
        this.damage = TypeOfPerson.KNIGHT.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.inventory = new Inventory();
        this.score = new ScoreBoard(0, 50);
        this.score.showScoreOnScreen(true);
    }

    //TODO ak vyjde cas urobit shield
    private void setShield(int radius, boolean isOn) { // pocet kociek okolo hraca ktore nebudu priechodne

        super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), isOn);// nastavi na bool policko na ktorom stoji hrac

        int numberOfTiles = (int)(radius * Math.pow(2, 3));

        int startingX = super.getPositionX() - radius;
        int startingY = super.getPositionY() + radius;

        if (!super.getCurrentRoom().getAllTiles()[startingY][startingX].isOccupied()) {
            super.changeOccupiedPosition(super.getPositionX(), super.getPositionY(), isOn);
        }

        for (int i = 1; i < numberOfTiles; i++) {
            if (i < (numberOfTiles / 4) + 1) {
                if (!super.getCurrentRoom().getAllTiles()[startingY][startingX].isOccupied()) {
                    super.changeOccupiedPosition(startingX, startingY, isOn);
                }
                startingY -= 1;
            } else if (i == (numberOfTiles / 4) + 1) {
                if (!super.getCurrentRoom().getAllTiles()[startingY][startingX].isOccupied()) {
                    super.changeOccupiedPosition(startingX, startingY, isOn);
                }
                startingX += 1;
            } else if (i == ((numberOfTiles / 4) + 1) * 2) {
                if (!super.getCurrentRoom().getAllTiles()[startingY][startingX].isOccupied()) {
                    super.changeOccupiedPosition(startingX, startingY, isOn);
                }
                startingY += 1;
            } else if (i == ((numberOfTiles / 4) + 1) * 3) {
                if (!super.getCurrentRoom().getAllTiles()[startingY][startingX].isOccupied()) {
                    super.changeOccupiedPosition(startingX, startingY, isOn);
                }
                startingX += 1;
            }
        }
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
                merchant.setPlayersBank(this.score.getBank());
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
