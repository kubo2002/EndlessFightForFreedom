package room.rooms;

import characters.enemies.Enemy;
import characters.Person;
import characters.player.Player;
import characters.enemies.Skeleton;
import characters.enemies.Witch;
import fri.shapesge.Manager;
import room.Room;
import room.TypeOfRoom;

import java.util.List;
import java.util.Random;

/**
 * Singleton Battleground predstavuje bojisko v hre.
 *
 * @autor Jakub Gubany
 */
public class Battleground extends Room {
    private static final Battleground BATTLEGROUND = new Battleground(); // inastancia bojiska
    private Manager manager;
    private Player player;

    /**
     * Privatny konstruktor triedy Battleground.
     */
    private Battleground() {
        super(TypeOfRoom.BATTLEGROUND);
        this.manager =  new Manager();
        this.manager.manageObject(this);
    }
    /**
     * Metoda pre ziskanie instancie triedy Battleground.
     *
     * @return instancia bojiska
     */
    public static Battleground getInstance() {
        return BATTLEGROUND;
    }
    /**
     * Metoda na vytvorenie postav v bojisku.
     */
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
     * Metoda na vyhladanie mrtvych postav a ich respawn do bojiska.
     * Postavy su nahodne umiestnene na bojisku.
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
    /**
     * Metoda na ziskanie hraca v bojisku.
     *
     * @return hrac v bojisku
     */
    public Player getPlayer() {
        return this.player;
    }

}
