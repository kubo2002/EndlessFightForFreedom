package room;

import characters.Merchant;
import characters.Player;

import java.util.List;

public class Market extends Room {
    //TODO volat v atribute hraca vytvoreneho v nadtriede napr RoomManager
    private Merchant merchant;
    public Market() {
        super(TypeOfRoom.MARKET);
    }

    public void spawnCharacters() {
        Player player = new Player(1, 1, this);

        List<Integer> spawnMerchant = super.getMap().generatePlayerSpawn();
        int merchantX = spawnMerchant.getFirst();
        int merchantY = spawnMerchant.getLast();

        this.merchant = new Merchant(merchantX, merchantY, this);
    }

    public Merchant getMerchant() {
        return this.merchant;
    }
}
