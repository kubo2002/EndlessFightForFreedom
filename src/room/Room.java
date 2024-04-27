package room;

import characters.TypeOfPerson;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private RoomGenerator map;
    private final int positionX = 50;
    private final int positionY = 50;
    private TypeOfRoom roomType;
    public Room(TypeOfRoom roomType) {
        this.roomType = roomType;
        this.map = new RoomGenerator(roomType.getNumberOfTilesX(), roomType.getNumberOfTilesY());
    }

    public void showMap() {
        int[][] matrixOfMap = this.map.createMap();
        int posX = this.positionX;
        int posY = this.positionY;
        int lengthOfTile = 0;

        for (int row = 0; row < matrixOfMap.length; row++) {
            for (int column = 0; column < matrixOfMap[row].length; column++) {
                Tile tile = new Tile();
                lengthOfTile = tile.getLengthOfTile();
                tile.setPicture(matrixOfMap[row][column]);
                tile.setTilePosition(posX, posY);
                posX += lengthOfTile;
            }
            posY += lengthOfTile;
            posX = this.positionX;
        }
    }

    private void putPlayer() {
        List<Integer> spawn = this.map.generatePlayerSpawn();


    }
}
