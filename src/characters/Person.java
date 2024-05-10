package characters;
import fri.shapesge.Image;
import room.Room;
import room.Tile;

import java.util.ArrayList;
import java.util.Optional;

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


        Tile[][] map = this.currentRoom.getAllTiles();

        int destX = (x - this.currentRoom.getPositionX()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();
        int destY = (y - this.currentRoom.getPositionY()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();

        this.shortestPath(x, y);

        if (destX < map[0].length && destY < map.length) {
            if (!map[destY][destX].isOccupied()) {
                map[this.positionY][this.positionX].setOccupied(false);
                map[destY][destX].setOccupied(true);
                this.positionX = destX;
                this.positionY = destY;
                this.image.changePosition(map[destY][destX].getPositionX(), map[destY][destX].getPositionY());
            }
        }
    }
    public void setPosition(int x, int y) {
        this.positionX = x; // tu to prepocita z (255, 256) na (2,3)
        this.positionY = y;
        this.image.changePosition(this.positionX * 90 + 45, this.positionY * 90 + 45);
    }

    private ArrayList<Tile> shortestPath(int destX, int destY) {
        int currentX = this.positionX;
        int currentY = this.positionY;

        int destionationX = (destX - this.currentRoom.getPositionX()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();
        int destionationY = (destY - this.currentRoom.getPositionY()) / this.currentRoom.getAllTiles()[0][0].getLengthOfTile();

        Optional<Tile> currentTile = this.currentRoom.getTileByCoordinates(currentX, currentY);
        Optional<Tile> destinationTile = this.currentRoom.getTileByCoordinates(destionationX, destionationY);

        ArrayList<Tile> queue = new ArrayList<>();
        queue.add(currentTile.get());

        boolean start = true;

        if (destinationTile.isPresent()) {
            int index = 0;
            do {
                Tile c = queue.get(index); // vyberam vzdy prvy z rady a skumam jeho susedov
                for (Tile surrounder : c.getSurroundings()) { // prechadzam susedmi akzualnej kachlicky
                    if (!surrounder.isOccupied()) {
                        surrounder.setPrecursor(c);
                        queue.add(surrounder);
                        if (surrounder == destinationTile.get()) {
                            start = false;
                        }

                    }
                }
                index += 1;
            } while (start);
        }

        return queue;
        //TODO urcenie najkratsej cesty k cielu
    }
}
