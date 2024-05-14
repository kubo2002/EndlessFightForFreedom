package characters;

import room.Room;

public class Skeleton extends Person implements Enemy {
    public Skeleton(TypeOfPerson type, Room currentRoom) {
        super(TypeOfPerson.SKELETON, currentRoom);
    }

    
}
