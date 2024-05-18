package room;

import characters.Merchant;
import characters.Player;

import java.io.Serializable;
import java.util.List;

public class Market extends Room {
    private Merchant merchant;
    private static final Market MARKET = new Market();
    private Market() {
        super(TypeOfRoom.MARKET);
    }

    public static Market getInstance() {
        return MARKET;
    }

    public void spawnCharacters() {
        Player player = Player.getInstance();
        player.setCurrentRoom(this);
        player.setPosition(1, 1);
        super.addCharacter(player);
        this.merchant = new Merchant();
        this.merchant.setCurrentRoom(this);
        this.merchant.setPosition(2, 2);
        super.addCharacter(this.merchant);
    }

    public Merchant getMerchant() {
        return this.merchant;
    }
}
