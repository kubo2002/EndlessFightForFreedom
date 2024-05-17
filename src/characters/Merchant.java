package characters;

import inventory.HealingSpell;
import inventory.Item;
import inventory.TypeOfItem;
import room.Room;
import shop.Offer;

import java.util.HashMap;

public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    private Offer offerSlots;

    public Merchant() {
        super(TypeOfPerson.MERCHANT);
        this.offer = new HashMap<>();
        this.offer.put(new HealingSpell(), TypeOfItem.HEAL.getCost());
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
