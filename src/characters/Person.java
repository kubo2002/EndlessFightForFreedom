package characters;
import fri.shapesge.Image;
import room.Room;
import room.Tile;

public abstract class Person {
    private Room currentRoom;
    private TypeOfPerson type;
    private int numberOfFrames;
    private int currentFarme;
    private Image image;
    private int positionX;
    private int positionY;
    private HpBar hpBar;
    public Person(TypeOfPerson type, Room currentRoom) {
        this.currentRoom = currentRoom;
        this.type = type;
        this.numberOfFrames = type.getNumberOfFrames();
        this.image = new Image(String.format("images/characters/%s/%s_0.png", this.type.getName(), this.type.getName()));
        this.image.makeVisible();
        this.hpBar = new HpBar(type.getBaseHp());
    }

    public void moveImage(int x, int y) {
        this.hpBar.move(x, y);
        this.image.moveHorizontal(x);
        this.image.moveVertical(y);
    }
    public void setPosition(int x, int y) {
        this.positionX = x; // tu to prepocita z (255, 256) na (2,3)
        this.positionY = y;
        this.currentRoom.getAllTiles()[this.positionY][this.positionX].setOccupied(true);
        this.image.changePosition(this.positionX * 90 + 45, this.positionY * 90 + 45);
        this.hpBar.setPosition(this.positionX * 90 + 60, this.positionY * 90 + 35);
        this.hpBar.setPositionX(this.positionX);
        this.hpBar.setPositionY(this.positionY);
        this.hpBar.showHpBar();
    }
    public void changeOccupiedPosition(int x , int y, boolean occupied) {
        this.currentRoom.getAllTiles()[x][y].setOccupied(occupied);
    }
    public Tile getCurrentTile() {
        return this.currentRoom.getAllTiles()[this.positionY][this.positionX];
    }
    public Room getCurrentRoom() {
        return this.currentRoom;
    }
    public Image getImage() {
        return this.image;
    }
    public int getPositionX() {
        return this.positionX;
    }
    public int getPositionY() {
        return this.positionY;
    }
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
    public HpBar getHpBar() {
        return this.hpBar;
    }

}
