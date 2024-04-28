package characters;

import room.Room;
import room.Tile;

public class Enemy extends Person implements Actions {
    public Enemy(TypeOfPerson type, Room currentRoom) {
        super(type, currentRoom);
    }

    @Override
    public void fight(Tile tile) {

    }
}
