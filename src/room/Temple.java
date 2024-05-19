package room;


import characters.Player;

import java.io.Serializable;

public class Temple extends Room implements Serializable {

    private static final Temple TEMPLE = new Temple();

    private Temple() {
        super(TypeOfRoom.TEMPLE);
    }
    public static Temple getInstance() {
        return TEMPLE;
    }
    @Override
    public void spawnCharacters() {
        Player player = Player.getInstance();
        player.setCurrentRoom(this);
        player.setPosition(1, 1);
        super.addCharacter(player);
    }
}
