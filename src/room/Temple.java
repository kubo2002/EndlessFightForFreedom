package room;


public class Temple extends Room {
    //TODO volat v atribute hraca vytvoreneho v nadtriede napr RoomManager
    public Temple(RoomManager roomManager) {
        super(TypeOfRoom.TEMPLE, roomManager);
    }
    @Override
    public void spawnCharacters() {
        var player = super.getPlayer();
        player.respawn();
    }


}
