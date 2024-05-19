package characters;

import inventory.items.HealingSpell;
import inventory.Item;
import inventory.items.Sword;
import inventory.TypeOfItem;
import shop.Offer;
import java.util.HashMap;

/**
 * Trieda reprezentujuca obchodnika v hre.
 *
 * @author Jakub Gubany
 *
 */
public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    private Offer offerSlots;

    /**
     * Konstruktor triedy Merchant.
     *
     * Obchodnik ma v nom zadefinovane itemy ktore je schopny predavat.  ocas hry.
     *
     */
    public Merchant() {
        super(TypeOfPerson.MERCHANT);
        this.offer = new HashMap<>();
        this.offer.put(new HealingSpell(TypeOfItem.HEAL_1), TypeOfItem.HEAL_1.getCost());
        this.offer.put(new HealingSpell(TypeOfItem.HEAl_2), TypeOfItem.HEAl_2.getCost());
        this.offer.put(new HealingSpell(TypeOfItem.HEAl_3), TypeOfItem.HEAl_3.getCost());
        this.offer.put(new Sword(TypeOfItem.SWORD_1), TypeOfItem.SWORD_1.getCost());
        this.offer.put(new Sword(TypeOfItem.SWORD_2), TypeOfItem.SWORD_2.getCost());
        this.offerSlots = new Offer(this.offer);
    }

    /**
     * Ukaze ponuku itemov na hracej ploche.
     *
     */
    public void showOffer() {
        this.offerSlots.offerOnScreen();
    }

    /**
     *
     * Zrusi ponuku itemov z hracej plochy.
     *
     */
    public void terminateOffer() {
        this.offerSlots.hideOffer();
    }

    /**
     * Nastavi obchodnikovi info o tom, kolko m hrac aktualne penazi.
     *
     * Podla tejto informacie vie obchodnik ponuknut prave tie itemy na ktore hrac ma dostatok finnacii.
     *
     * @param bank double objem financii hraca.
     */
    public void setPlayersBank(double bank) {
        this.offerSlots.setBank(bank);
    }

}
