package inventory.items;

import fri.shapesge.Image;
import inventory.Item;
import inventory.TypeOfItem;

/**
 * Trieda Sword predstavuje mec ako specificky typ predmetu v hre.
 * Mec je implementovany ako zbran a dedi vlastnosti od triedy Item.
 *
 * @autor Jakub Gubany
 */
public class Sword extends Item implements Weapon {
    private Image image;
    private TypeOfItem type;
    /**
     * Konstruktor triedy Sword.
     * Inicializuje obrazok meca na zaklade jeho typu.
     *
     * @param type typ meca
     */
    public Sword(TypeOfItem type) {
        super(type);
        this.image = new Image(String.format("images/items/swords/%s.png", type.getPath()));
        this.type = type;
    }
    /**
     * Metoda na nastavenie pozicie meca.
     *
     * @param x x-suradnica pozicie
     * @param y y-suradnica pozicie
     */
    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

}
