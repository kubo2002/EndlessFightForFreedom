package room;

import characters.Player;
import characters.Skeleton;
import fri.shapesge.Manager;


public class Battleground extends Room {
    private static final Battleground BATTLEGROUND = new Battleground();
    private Manager manager;
    private Battleground() {
        super(TypeOfRoom.BATTLEGROUND);
        this.manager =  new Manager();
        this.manager.manageObject(this);
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

    public void findDeadCharacters() {
        super.deleteCharacters(false);
    }

}
