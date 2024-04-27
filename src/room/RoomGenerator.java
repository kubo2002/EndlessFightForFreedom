package room;

import java.util.*;

public class RoomGenerator {
    private int[][] map;

    public RoomGenerator(int tilesOnXAxis, int tilesOnYAxis) {
        this.map = new int[tilesOnXAxis][tilesOnYAxis];

    }
    public int[][] createMap() {
        Random r = new Random();

        for (int row = 0; row < this.map.length; row++) {
            for (int column = 0; column < this.map[row].length; column++) {
                if (row == 0 || row == this.map.length - 1 || column == 0 || column == this.map.length - 1) {
                    this.map[row][column] = 1;
                } else {
                    int typeOfTile = r.nextInt(2, 5);
                    this.map[row][column] = typeOfTile;
                }
            }
        }
        return this.map;
    }

    public List<Integer> generatePlayerSpawn() {
        Random r = new Random();
        return List.of(r.nextInt(1, this.map.length - 2), r.nextInt(1, this.map[0].length - 2));
    }
}
