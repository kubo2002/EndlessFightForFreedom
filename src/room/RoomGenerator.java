package room;

import java.util.List;
import java.util.Random;

/**
 * Trieda RoomGenerator vytvara nahodne generovanu mapu pre miestnost.
 * Mapa obsahuje rozne typy dlazdic a umiestnenie dveri.
 *
 * @autor Jakub Gubany
 */
public class RoomGenerator {
    private int[][] map;

    /**
     * Konstruktor vytvori generator mapy so zadanym poctom dlazdic na x-ovej a y-ovej osi.
     *
     * @param tilesOnXAxis pocet dlazdic na x-ovej osi
     * @param tilesOnYAxis pocet dlazdic na y-ovej osi
     */
    public RoomGenerator(int tilesOnXAxis, int tilesOnYAxis) {
        this.map = new int[tilesOnXAxis][tilesOnYAxis];

    }
    /**
     * Metoda vytvori mapu s nahodnym umiestnenim dveri a roznymi typmi dlazdic.
     *
     * @return generovana mapa miestnosti
     */
    public int[][] createMap() {
        Random r = new Random();

        int doorSpawn = r.nextInt(1, this.map.length - 2);

        for (int row = 0; row < this.map.length; row++) {
            for (int column = 0; column < this.map[row].length; column++) {
                if (row == 0 && column == doorSpawn) {
                    this.map[row][column] = 6;
                } else {
                    if (row == 0 || row == this.map.length - 1 || column == 0 || column == this.map.length - 1) {
                        this.map[row][column] = 1;
                    } else {
                        int typeOfTile = r.nextInt(2, 5);
                        this.map[row][column] = typeOfTile;
                    }
                }
            }
        }
        return this.map;
    }
    /**
     * Metoda generuje nahodne umiestnenie pre hraca.
     *
     * @return zoznam obsahujuci x-ovu a y-ovu poziciu pre hraca
     */
    public List<Integer> generatePlayerSpawn() {
        Random r = new Random();
        return List.of(r.nextInt(2, this.map.length - 2), r.nextInt(2, this.map[0].length - 2));
    }
}
