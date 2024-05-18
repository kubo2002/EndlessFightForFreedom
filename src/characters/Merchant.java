package characters;

import inventory.HealingSpell;
import inventory.Item;
import inventory.Sword;
import inventory.TypeOfItem;
import shop.Offer;
import java.util.HashMap;

public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    private Offer offerSlots;

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

    public HashMap<Item, Double> getOffer() {
        this.offerSlots.offerOnScreen();
        return this.offer;
    }

    public void terminateOffer() {
        this.offerSlots.hideOffer();
    }

    public void setPlayersBank(double bank) {
        this.offerSlots.setBank(bank);
    }

}
