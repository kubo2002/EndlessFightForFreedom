package room;

import characters.Enemy;
import characters.Person;
import characters.Player;
import characters.Skeleton;
import characters.Witch;
import fri.shapesge.Manager;
import java.util.List;
import java.util.Random;


public class Battleground extends Room {
    private static final Battleground BATTLEGROUND = new Battleground();
    private Manager manager;
    private Player player;
    private Battleground() {
        super(TypeOfRoom.BATTLEGROUND);
        this.manager =  new Manager();
        this.manager.manageObject(this);
    }
    public static Battleground getInstance() {
        return BATTLEGROUND;
    }
    public void spawnCharacters() {
        this.player = Player.getInstance();
        this.player.setCurrentRoom(this);
        this.player.setPosition(1, 1);
        super.addCharacter(this.player);

        Witch witch = new Witch(this.player);
        super.addCharacter(witch);
        witch.setCurrentRoom(this);
        witch.setPosition(5, 5);
        witch.move();

        Skeleton skeleton = new Skeleton(this.player);
        super.addCharacter(skeleton);
        skeleton.setCurrentRoom(this);
        skeleton.setPosition(9, 7);
        skeleton.move();
    }

    /**
     * Spawner nepriatelov.
     */
    public void findDeadCharacters() {
        Random randomNumber = new Random();
        List<Person> deleted = super.deleteCharacters();

        for (Person revived : deleted) {
            if (revived instanceof Enemy) {
                var enemy = (Enemy)revived;
                revived.setCurrentRoom(this);

                int posX = randomNumber.nextInt(1, this.getRoomType().getNumberOfTilesX() - 1);
                int posY = randomNumber.nextInt(1, this.getRoomType().getNumberOfTilesY() - 1);

                revived.setPosition(posX, posY);
                revived.getHpBar().resetHp();
                revived.setState(true);
                enemy.move();
                super.addCharacter(revived);
            }
        }
    }
    public Player getPlayer() {
        return this.player;
    }

}
