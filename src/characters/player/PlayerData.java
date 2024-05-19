package characters.player;

import java.io.Serializable;

/**
 * Trieda PlayerData uchováva údaje o hráčovi, vrátane skóre, stavu banky, zdravia a mena hráča.
 * Implementuje Singleton vzor, aby sa zabezpečilo, že existuje len jedna inštancia tejto triedy.
 *
 * @autor Jakub Gubany
 */
public class PlayerData implements Serializable {
    private int score;
    private double bank;
    private double hp;
    private String nameOfPlayer;

    // Statická inštancia triedy PlayerData
    private static final PlayerData INSTANCE = new PlayerData(); // instancia triedy PlayerData.

    /**
     * Súkromný konštruktor, aby sa zabránilo vytváraniu nových inštancií.
     */
    private PlayerData() {
        this.score = 0;
    }
    /**
     * Metóda na získanie jedinej inštancie triedy PlayerData.
     *
     * @return jediná inštancia triedy PlayerData
     */
    public static PlayerData getInstance() {
        return INSTANCE;
    }
    /**
     * Nastaví skóre hráča.
     *
     * @param score nové skóre hráča
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * Nastaví stav banky hráča.
     *
     * @param bank nový stav banky hráča
     */
    public void setBank(double bank) {
        this.bank = bank;
    }
    /**
     * Nastaví hp hráča.
     *
     * @param hp nové hp hráča
     */
    public void setHp(double hp) {
        this.hp = hp;
    }
    /**
     * Získa aktuálne skóre hráča.
     *
     * @return aktuálne skóre hráča
     */
    public int getScore() {
        return this.score;
    }
    /**
     * Získa aktuálny stav financii hráča.
     *
     * @return aktuálny stav financii hráča
     */
    public double getBank() {
        return this.bank;
    }
    /**
     * Získa aktuálne hp hráča.
     *
     * @return aktuálne hp hráča
     */
    public double getHp() {
        return this.hp;
    }
    /**
     * Nastaví meno hráča.
     *
     * @param nameOfPlayer nové meno hráča
     */
    public void setNameOfPlayer(String nameOfPlayer) {
        this.nameOfPlayer = nameOfPlayer;
    }
    /**
     * Získa meno hráča.
     *
     * @return meno hráča
     */
    public String getName() {
        return this.nameOfPlayer;
    }

}
