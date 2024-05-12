package characters;

import inventory.HealingSpell;
import inventory.Item;
import room.Room;
import shop.Offer;

import java.util.HashMap;

public class Merchant extends Person {
    private HashMap<Item, Double> offer;
    private int positionX;
    private int positionY;
    private double bank;

    public Merchant(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.MERCHANT, currentRoom);
        super.setPosition(positionX, positionY);
        this.offer = new HashMap<>();
        this.offer.put(new HealingSpell(), 2.4);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public HashMap<Item, Double> getOffer() {
        var offerSlots = new Offer(this.offer, this.bank);
        offerSlots.drawOfferOnScreen();
        return this.offer;
    }

    public void setPlayersBank(double bank) {
        this.bank = bank;
    }

}
