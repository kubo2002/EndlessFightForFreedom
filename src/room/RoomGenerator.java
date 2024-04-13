package room;

import java.util.Random;

public class RoomGenerator {
    private int[][] map;

    public RoomGenerator() {
        this.map = new int[10][10];

    }
    public int[][] createMap() {
        for (int row = 0; row < this.map.length; row++) {
            for (int column = 0; column < this.map[row].length; column++) {
                if (row == 0 || row == this.map.length - 1 || column == 0 || column == this.map.length - 1) {
                    this.map[row][column] = 1;
                } else {
                    Random r = new Random();
                    int typeOfTile = r.nextInt(2, 5);
                    this.map[row][column] = typeOfTile;
                }
            }
        }
        return this.map;
    }
}
