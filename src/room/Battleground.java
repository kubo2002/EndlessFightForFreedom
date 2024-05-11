package room;

import characters.Player;

import java.util.List;

public class Battleground extends Room {
    public Battleground() {
        super(TypeOfRoom.BATTLEGROUND);

    }

    public void spawnCharacters() {
        List<Integer> spawnMerchant = super.getMap().generatePlayerSpawn();

        int playerX = spawnMerchant.getFirst();
        int playerY = spawnMerchant.getLast();

        Player player = new Player(playerX, playerY, this);
    }
}
