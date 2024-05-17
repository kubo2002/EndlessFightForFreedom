package room;


import characters.Player;
import characters.Skeleton;
import characters.Witch;

public class Battleground extends Room {
    private static final Battleground BATTLEGROUND = new Battleground();
    private Battleground() {
        super(TypeOfRoom.BATTLEGROUND);
    }
    public static Battleground getInstance() {
        return BATTLEGROUND;
    }
    public void spawnCharacters() {

        Player player = Player.getInstance();
        player.setCurrentRoom(this);
        player.setPosition(1, 1);
        super.addCharacter(player);

        /*Witch witch = new Witch(player);
        super.addCharacter(witch);
        witch.setCurrentRoom(this);
        witch.setPosition(5, 5);
        witch.move();*/

        Skeleton skeleton = new Skeleton(player);
        super.addCharacter(skeleton);
        skeleton.setCurrentRoom(this);
        skeleton.setPosition(9, 7);
        skeleton.move();
    }

}
