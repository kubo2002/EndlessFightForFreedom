package inventory.items;

import fri.shapesge.Image;
import inventory.Item;
import inventory.TypeOfItem;

/**
 * Trieda HealingSpell predstavuje špecialnu polozku v inventari.
 * Tato trieda dedi od triedy Item a implementuje rozhranie Spell.
 *
 * @autor Jakub Gubany
 */
public class HealingSpell extends Item {
    private Image image;
    /**
     * Konstruktor triedy HealingSpell.
     * Vytvra instanciu spellu na zaklade specifikovaneho typu.
     * Inicializuje obrazok spellu na zaklade cesty k obrazku.
     *
     * @param type typ polozky
     */
    public HealingSpell(TypeOfItem type) {
        super(type);
        this.image = new Image(String.format("images/items/spells/%s.png", type.getPath()));
    }
    /**
     * Metoda na nastavenie pozicie spellu.
     *
     * @param x x-suradnica pozicie
     * @param y y-suradnica pozicie
     */
    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }


}
