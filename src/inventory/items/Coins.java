package inventory.items;

import inventory.Item;
import inventory.TypeOfItem;

/**
 * Trieda Coins predstavuje predmet mince v inventári.
 * Táto trieda dedí od triedy Item a špecifikuje typ položky ako mince.
 *
 * @autor Jakub Gubany
 */
public class Coins extends Item {
    /**
     * Konštruktor triedy Coins.
     * Nastaví typ položky na mince a nastaví pozíciu na základe zadaných súradníc.
     *
     * @param positionX x-súradnica pozície mince (v hernom svete)
     * @param positionY y-súradnica pozície mince (v hernom svete)
     */
    public Coins(int positionX, int positionY) {
        super(TypeOfItem.COINS);
        super.setPosition(positionX * 90 + 45, positionY * 90 + 45);
    }
}
