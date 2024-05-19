package characters;

import fri.shapesge.Manager;
import inventory.Inventory;
import inventory.Item;
import inventory.Spell;
import inventory.Weapon;
import inventory.Coins;
import room.Market;
import room.ScoreBoard;
import room.Tile;
import screens.EndOfGame;
import screens.SaveAndExit;

import java.util.Optional;

public class Player extends Person implements Actions {
    private Manager manager;
    private Inventory inventory;
    private ScoreBoard score;
    private double damage;
    private static Player player = new Player();
    private int useCount;
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
        this.direction(0, -1);
    }
    public void moveDown() {
        this.direction(0, 1);
    }
    public void moveLeft() {
        this.direction(-1, 0);
    }
    public void moveRight() {
        this.direction(1, 0);
    }
    @Override
    public void direction(int cX, int cY) {
        super.direction(cX, cY);
        this.collectIfPossible();
    }
    public void wakeMerchantUp(int x, int y) {
        int clickedX = (x - this.getCurrentRoom().getPositionX()) / 90;
        int clickedY = (y - this.getCurrentRoom().getPositionY()) / 90;

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
            this.useCount = item.getMaxUse();
        }
    }
    public void checkTarget(int x, int y) {
        int clickedX = (x - 45) / 90;
        int clickedY = (y - 45) / 90;

        for (Tile tile : super.getCurrentRoom().getSurroundings(this.getPositionX(), this.getPositionY())) {
            if ((tile.getPositionX() - 45) / 90 == clickedX && (tile.getPositionY() - 45) / 90 == clickedY && tile.isOccupied()) {
                if (tile.getCharacter().isPresent()) {
                    if (this.useCount > 0) {
                        this.useCount -= 1;
                    } else {
                        this.damage = TypeOfPerson.KNIGHT.getBaseDamage();
                    }
                    this.performAttack(tile.getCharacter().get());
                }
            }
        }
    }
    public void saveAndExit() {
        SaveAndExit saveAndExit = new SaveAndExit();
    }
    private void collectIfPossible() {
        if (super.getCurrentTile().getItem().isPresent()) {
            if (super.getCurrentTile().getItem().get() instanceof Coins) {
                super.getCurrentTile().getItem().get().hideItem();
                double amount = super.getCurrentTile().getItem().get().getPower();
                this.score.addCoins(amount);
                super.getCurrentTile().setItem(Optional.empty());
            }
        }
    }
    public ScoreBoard getScoreBoard() {
        return this.score;
    }

    public void setScoreBoard(ScoreBoard score) {
        this.score = score;
    }
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }
    @Override
    public void receiveAttack(double damage) {
        if (super.getHpBar().isAlive()) {
            super.getHpBar().subtractLife(damage);
            PlayerData data = PlayerData.getInstance();
            data.setHp(super.getHpBar().getHp());
        } else {
            EndOfGame endScreen = EndOfGame.getInstance();
            super.setState(false);
        }
    }
}
