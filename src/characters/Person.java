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

        Tile[][] map = this.currentRoom.getAllTiles();

        int destX = (x - this.currentRoom.getPositionX()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();
        int destY = (y - this.currentRoom.getPositionY()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();

        System.out.println(map[destY][destX].getPositionX());
        System.out.println(map[destY][destX].getPositionY());
        if (!map[destY][destX].isOccupied()) {
            map[y][x].setOccupied(false); //nefunguje
            map[destY][destX].setOccupied(true);
            System.out.println(String.format("Current X : %d Current Y : %d", y, x));
            System.out.println(String.format("dest X : %d dest Y : %d", destY, destX));
            this.image.changePosition(map[destY][destX].getPositionX(), map[destY][destX].getPositionY());
        }
        //TODO Urobit premiestnovanie na konkretne kachlicky + nastavit na kachlicke info ze je obsadena


    }
    public void setPosition(int x, int y) {
        this.positionX = x - 45;
        this.positionY = y - 45;
        this.image.changePosition(this.positionX, this.positionY);
    }

    private int[][] shortestPath(int destX, int destY) {
        int currentX = this.positionX;
        int currentY = this.positionY;

        return null;
    }
}
