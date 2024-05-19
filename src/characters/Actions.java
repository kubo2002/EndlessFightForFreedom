package characters;

/**
 * Rozhranie obsahujuce metody utoku a prijatia poskodeia od nepriatela.
 *
 * Toto rozhranie implementuju vsetci okrem Obchodnika ktory je neutralnou postavou.
 *
 * @autor Jakub Gubany
 *
 */
public interface Actions {

    /**
     * Vykona utok na oponenta.
     *
     * @param person oponent ktory implementuje rovnake rozhranie.
     *
     */
    void performAttack(Actions person);

    /**
     * Prijme poskodenie od oponenta.
     *
     * @param damage hodnota poskodenia, ktore postava prijme od oponenta.
     *
     */
    void receiveAttack(double damage);
}

