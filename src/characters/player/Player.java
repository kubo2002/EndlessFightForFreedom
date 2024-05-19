package characters.player;

import characters.Actions;
import characters.Person;
import characters.TypeOfPerson;
import fri.shapesge.Manager;
import inventory.Inventory;
import inventory.Item;
import inventory.items.Spell;
import inventory.items.Weapon;
import inventory.items.Coins;
import room.rooms.Market;
import room.ScoreBoard;
import room.Tile;
import screens.EndOfGame;
import screens.SaveAndExit;

import java.util.Optional;

/**
 * Singleton reprezentuje hraca na hernej ploche.
 *
 * @author Jakub Gubany
 */
public class Player extends Person implements Actions {
    private Manager manager;
    private Inventory inventory;
    private ScoreBoard score;
    private double damage;
    private static Player player = new Player();
    private int useCount;
    /**
     * Konstruktor triedy Player.
     *
     * Inicializuje inventar a skore.
     *
     */
    private Player() {
        super(TypeOfPerson.KNIGHT);
        this.damage = TypeOfPerson.KNIGHT.getBaseDamage();
        this.manager = new Manager();
        this.manager.manageObject(this);
        this.inventory = Inventory.getInstance();
        this.inventory.drawInventoryOnScreen();
        this.score = new ScoreBoard(0, 50);
        this.score.showScoreOnScreen(true);
        PlayerData data = PlayerData.getInstance();
        data.setHp(super.getHpBar().getHp());
    }

    /**
     * Vrati instanciu triedy Player.
     *
     * @return Player.
     */
    public static Player getInstance() {
        return player;
    }

    /**
     * Posunie hraca po stlaceni klaesy hore.
     */
    public void moveUp() {
        this.direction(0, -1);
    }
    /**
     * Posunie hraca po stlaceni klaesy dole.
     */
    public void moveDown() {
        this.direction(0, 1);
    }
    /**
     * Posunie hraca po stlaceni klaesy dolava.
     */
    public void moveLeft() {
        this.direction(-1, 0);
    }
    /**
     * Posunie hraca po stlaceni klaesy doprava.
     */
    public void moveRight() {
        this.direction(1, 0);
    }

    /**
     * Nasmeruje hraca.
     *
     * @param cX konstanta, ktorou metoda nasobi suradnice na ose X, podla toho kde sa nachadza nepriatel.
     * @param cY konstanta, ktorou metoda nasobi suradnice na ose Y, podla toho kde sa nachadza nepriatel.
     */
    @Override
    public void direction(int cX, int cY) {
        super.direction(cX, cY);
        this.collectIfPossible();
    }

    /**
     * Po stlaceni mysou na postavu Merchant sa zobrazi jeho ponuka itemov
     *
     * @param x pozicia na ose X.
     * @param y pozicia na ose Y.
     */
    public void wakeMerchantUp(int x, int y) {
        int clickedX = (x - this.getCurrentRoom().getPositionX()) / 90;
        int clickedY = (y - this.getCurrentRoom().getPositionY()) / 90;

        if (super.getCurrentRoom() instanceof Market) {
            var market = (Market)super.getCurrentRoom();
            var merchant = market.getMerchant();
            if (clickedX == merchant.getPositionX() && clickedY == merchant.getPositionY()) {
                merchant.setPlayersBank(this.score.getBank());
                merchant.showOffer();
            }
        }
    }

    /**
     * Odrata hracovi financie po kupe itemu.
     *
     * @param item Item item ktory si hrac kupil.
     */
    public void buyItem(Item item) {
        this.score.subtractCoins(item.getCost());
    }

    /**
     * Pouzije item z inventa pre svoju potrebu.
     *
     * @param item Item item z inventara.
     */
    public void useItem(Item item) {
        if (item instanceof Spell) {
            super.getHpBar().heal(item.getPower());
        } else if (item instanceof Weapon) {
            this.damage = item.getPower();
            this.useCount = item.getMaxUse();
        }
    }

    /**
     * Vyhlada ci sa v jeho bezprostrednom okolo nachadza nepriatel.
     *
     * Ak ano a pouzivatel na nepriatela klikol, tak na nepriatela zautoci.
     *
     * @param x pozicia na ose X.
     * @param y pozicia na ose Y.
     */
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

    /**
     * po stlaceni klavesy ESC sa zobrazi dialogove okno ulozenia hry alebo zrusenia hry.
     *
     */
    public void saveAndExit() {
        SaveAndExit saveAndExit = new SaveAndExit();
    }

    /**
     * Ak sa na aktualnej kachlicke nachadza item tak ho zober.
     */
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

    /**
     * Vrati Score board hraca s aktualnymi vysledkami.
     *
     * @return ScoreBoard skore hraca.
     */
    public ScoreBoard getScoreBoard() {
        return this.score;
    }

    /**
     * Zautoci na oponenta.
     *
     * @param person oponent ktory implementuje rovnake rozhranie.
     */
    @Override
    public void performAttack(Actions person) {
        person.receiveAttack(this.damage);
    }

    /**
     * Prijme poskodenie od oponenta.
     *
     * @param damage hodnota poskodenia, ktore postava prijme od oponenta.
     */
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
