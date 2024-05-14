package room;

import characters.Merchant;
import characters.Player;

import java.util.List;

public class Market extends Room {
    private Merchant merchant;
    public Market(RoomManager roomManager) {
        super(TypeOfRoom.MARKET, roomManager);
    }

    public void spawnCharacters() {
        var player = Player.getInstance(1, 1, this);
        this.merchant = new Merchant(2, 2, this);
    }

    public Merchant getMerchant() {
        return this.merchant;
    }
}
