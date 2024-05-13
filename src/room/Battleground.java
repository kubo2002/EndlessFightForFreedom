package room;

import characters.Player;
import characters.Witch;

import java.util.List;

public class Battleground extends Room {
    //TODO volat v atribute hraca vytvoreneho v nadtriede napr RoomManager
    public Battleground() {
        super(TypeOfRoom.BATTLEGROUND);

    }

    public void spawnCharacters() {
        List<Integer> spawnMerchant = super.getMap().generatePlayerSpawn();

        //int playerX = spawnMerchant.getFirst();
        //int playerY = spawnMerchant.getLast();

        //TODO dat si pozor aby sa nespawnovali na seba

        Player player = new Player(1, 1, this);
        Witch witch = new Witch(5, 5, this, player);
        witch.move();
    }
}
