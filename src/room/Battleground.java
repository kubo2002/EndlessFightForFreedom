package room;


import characters.Player;
import characters.Witch;

public class Battleground extends Room {
    public Battleground(RoomManager roomManager) {
        super(TypeOfRoom.BATTLEGROUND, roomManager);
    }

    public void spawnCharacters() {
        var player = super.getPlayer();
        player.respawn();

        Witch witch = new Witch(5, 5, this, super.getPlayer());
        witch.move();
    }
}
