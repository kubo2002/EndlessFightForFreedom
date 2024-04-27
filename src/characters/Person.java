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

    public Person(TypeOfPerson type, Room currentRoom) {
        this.currentRoom = currentRoom;
        this.type = type;
        this.numberOfFrames = type.getNumberOfFrames();
        this.image = new Image(String.format("images/characters/%s/%s_0.png", this.type.getName(), this.type.getName()));
        this.image.makeVisible();
    }

    public void animation() {
        this.currentFarme += 1;
        if (this.currentFarme > this.numberOfFrames) {
            this.currentFarme = 0;
        }
        this.image.changeImage(String.format("images/characters/%s/%s_%d.png", this.type.getName(), this.type.getName(), this.currentFarme));
        this.image.makeVisible();
    }

    /***
     * Aplikovat dijkstrov alg an hladanie optimálnej cesty k cielu.
     * @param x
     * @param y
     */
    public void moveToDestination(int x, int y) {
        this.positionX = x;
        this.positionY = y;

        int destX = x / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();
        int destY = y / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();

        Tile[][] map = this.currentRoom.getAllTiles();

        //TODO Urobit premiestnovanie na konkretne kachlicky + nastavit na kachlicke info ze je obsadena


    }
    public void setPosition(int x, int y) {
        this.positionX = x - 45;
        this.positionY = y - 45;
        this.image.changePosition(this.positionX, this.positionY);
    }

}
