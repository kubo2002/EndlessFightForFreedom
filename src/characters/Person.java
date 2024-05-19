package characters;
import fri.shapesge.Image;
import room.Room;
import room.Tile;

/**
 * Trieda reprezentujuca postavu v hre.
 *
 * Z postavy dalej dedia zakladne vlastnosti postavy Hrac, Merchant, Enemies
 *
 * @author Jakub Gubany
 *
 */
public class Person {
    private Room currentRoom;
    private TypeOfPerson type;
    private Image image;
    private int positionX;
    private int positionY;
    private HpBar hpBar;
    private boolean state;

    /**
     * Konstruktor triedy Postava.
     *
     * @param type typ postavy ktora bude triedou vytvorena.
     *
     */
    public Person(TypeOfPerson type) {
        this.state = true;
        this.type = type;
        this.image = new Image(String.format("images/characters/%s/%s_0.png", this.type.getName(), this.type.getName()));
        this.image.makeVisible();
        this.hpBar = new HpBar(type.getBaseHp());
    }

    /**
     * Posunie obrazok postavy po ploche o danu vzdialenost.
     *
     * @param x vzdialenost na ose X.
     * @param y vzdialenost na ose Y.
     */
    public void moveImage(int x, int y) {
        this.hpBar.moveHpBar(x, y);
        this.image.moveHorizontal(x);
        this.image.moveVertical(y);
    }

    /**
     * Nastavi postave presnu poziciu na hernej ploche.
     *
     * @param x int pozicia na ose X.
     * @param y int pozicia na ose Y.
     *
     */
    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.currentRoom.setOccupiedTile(this.positionX, this.positionY, true);
        this.image.changePosition(this.positionX * 90 + 45, this.positionY * 90 + 45);
        this.hpBar.setPosition(this.positionX * 90 + 60, this.positionY * 90 + 35);
        this.hpBar.showHpBar();
        this.image.makeVisible();
    }

    /**
     * Zmeni boolean hodnotu na okupovanej kachlicke na true ak na nej stoji alebo false ak od nej odisiel.
     *
     * Metoda je dolezita kvoli koliziam a predchazadniu overlap.
     *
     * @param x int pozicia kachlicky na ose X.
     * @param y int pozicia kachlicky na ose Y.
     * @param occupied boolean obsadena / neobsadena kachlicka.
     *
     */
    public void changeOccupiedPosition(int x , int y, boolean occupied) {
        this.currentRoom.setOccupiedTile(x, y, occupied);
    }

    /**
     * Nasmeruje postavu do urceneho smeru podla ciela oponenta.
     *
     * @param cX konstanta, ktorou metoda nasobi suradnice na ose X, podla toho kde sa nachadza nepriatel.
     * @param cY konstanta, ktorou metoda nasobi suradnice na ose Y, podla toho kde sa nachadza nepriatel.
     *
     */
    public void direction(int cX, int cY) {
        if (this.getCurrentRoom().isAbleToMove(this.positionX + cX, this.positionY + cY)) {
            this.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), false);
            this.moveImage(cX * this.getType().getSpeed(), cY * this.getType().getSpeed());
            this.positionX += cX;
            this.positionY += cY;
            this.currentRoom.setCharacterOnTile(this.positionX, this.positionY, this);
            this.changeOccupiedPosition(this.getPositionX(), this.getPositionY(), true);
        }
    }

    /**
     * Vrati aktualnu kachlicku an ktorej sa hrac nachadza.
     *
     * @return Tile aktualna kachlicka.
     *
     */
    public Tile getCurrentTile() {
        return this.currentRoom.getTile(this.positionX, this.positionY);
    }

    /**
     * Vrati miestnost v ktorej sa postava aktualne nachadza.
     *
     * @return Room aktualna miestnost.
     *
     */
    public Room getCurrentRoom() {
        return this.currentRoom;
    }

    /**
     * Vrati poziciu postavy na ose X.
     *
     * @return int pozicia na ose X.
     */
    public int getPositionX() {
        return this.positionX;
    }
    /**
     * Vrati poziciu postavy na ose Y.
     *
     * @return int pozicia na ose Y.
     */
    public int getPositionY() {
        return this.positionY;
    }

    /**
     * Vrati typ aktualnej postavy.
     *
     * @return TypeOfPerson typ postavy.
     *
     */
    public TypeOfPerson getType() {
        return this.type;
    }

    /**
     * Vrati HpBar postavy.
     *
     * @return HpBar
     */
    public HpBar getHpBar() {
        return this.hpBar;
    }

    /**
     * Nastavi postave poziciu na ose X.
     *
     * @param positionX pozicia na ose X.
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    /**
     * Nastavi postave poziciu na ose Y.
     *
     * @param positionY pozicia na ose Y.
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    /**
     * Vrati stav postavy.
     * @return boolean stav psotavy.
     *
     */
    public boolean getState() {
        return this.state;
    }

    /**
     * Nastavi stav postave.
     *
     * @param state boolean stav postavy.
     *
     */
    public void setState(boolean state) {
        this.state = state;
    }

    /**
     * Schova postavu z hernej plochy.
     */
    public void hide() {
        this.hpBar.hideHpBar();
        this.image.makeInvisible();
    }

    /**
     * nastavi aktualnu miestnost do ktorej sa postava premiestnuje.
     *
     * @param currentRoom Room miestnost do kotrej posatav ide.
     *
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}
