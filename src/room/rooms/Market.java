package room.rooms;

import characters.Merchant;
import characters.player.Player;
import room.Room;
import room.TypeOfRoom;

/**
 * Singleton Market predstavuje trh v hre, kde hrac moze nakupovat od obchodnika.
 *
 * @autor Jakub Gubany
 */
public class Market extends Room {
    private Merchant merchant;
    private static final Market MARKET = new Market(); // instancia obchodu
    /**
     * Privatny konstruktor triedy Market inicializuje trhovisko.
     */
    private Market() {
        super(TypeOfRoom.MARKET);
    }
    /**
     * Metoda instanciu trhoviska.
     *
     * @return intancia trhoviska
     */
    public static Market getInstance() {
        return MARKET;
    }
    /**
     * Metoda spawnCharacters() inicializuje postavy hraca a obchodnika na trhovisku.
     */
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
    /**
     * Metoda vrati obchodnika na trhovisku.
     *
     * @return obchodnik na trhovisku
     */
    public Merchant getMerchant() {
        return this.merchant;
    }
}
