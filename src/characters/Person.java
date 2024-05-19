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
     * @param x
     * @param y
     */
    public void moveImage(int x, int y) {
        this.hpBar.move(x, y);
        this.image.moveHorizontal(x);
        this.image.moveVertical(y);
    }
    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        this.currentRoom.setOccupiedTile(this.positionX, this.positionY, true);
        this.image.changePosition(this.positionX * 90 + 45, this.positionY * 90 + 45);
        this.hpBar.setPosition(this.positionX * 90 + 60, this.positionY * 90 + 35);
        this.hpBar.setPositionX(this.positionX);
        this.hpBar.setPositionY(this.positionY);
        this.hpBar.showHpBar();
        this.image.makeVisible();
    }
    public void changeOccupiedPosition(int x , int y, boolean occupied) {
        this.currentRoom.setOccupiedTile(x, y, occupied);
    }
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
    public Tile getCurrentTile() {
        return this.currentRoom.getTile(this.positionX, this.positionY);
    }
    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public TypeOfPerson getType() {
        return this.type;
    }
    public HpBar getHpBar() {
        return this.hpBar;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public boolean getState() {
        return this.state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public void hide() {
        this.hpBar.hideHpBar();
        this.image.makeInvisible();
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

}
