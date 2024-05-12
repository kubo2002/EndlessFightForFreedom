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
    private int positionX;
    private int positionY;
    private double bank;

    public Merchant(int positionX, int positionY, Room currentRoom) {
        super(TypeOfPerson.MERCHANT, currentRoom);
        super.setPosition(positionX, positionY);
        this.offer = new HashMap<>();
        this.offer.put(new HealingSpell(), TypeOfItem.HEAL.getCost());
        this.positionX = positionX;
        this.positionY = positionY;
        this.offerSlots = new Offer(this.offer);
    }

    public HashMap<Item, Double> getOffer() {
        this.offerSlots.offerOnScreen();
        return this.offer;
    }

    public void setPlayersBank(double bank) {
        this.offerSlots.setBank(bank);
    }

}
