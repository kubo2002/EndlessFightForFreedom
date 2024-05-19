package room.rooms;


import characters.player.Player;
import room.Room;
import room.TypeOfRoom;

/**
 * Singleton Temple reprezentuje pociatocnu miestnost v hre.
 *
 * @autor Jakub Gubany
 */
public class Temple extends Room {

    private static final Temple TEMPLE = new Temple(); // instancia vychodzej miestnosti

    /**
     * Privatny konstruktor triedy Temple.
     */
    private Temple() {
        super(TypeOfRoom.TEMPLE);
    }
    /**
     * Ziska instanciu miestnosti.
     *
     * @return instancia miestnosti.
     */
    public static Temple getInstance() {
        return TEMPLE;
    }
    /**
     * Spawnuje postavy v miestnosti.
     */
    @Override
    public void spawnCharacters() {
        Player player = Player.getInstance();
        player.setCurrentRoom(this);
        player.setPosition(1, 1);
        super.addCharacter(player);
    }
}
