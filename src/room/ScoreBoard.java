package room;

import characters.player.PlayerData;
import fri.shapesge.FontStyle;
import fri.shapesge.TextBlock;
/**
 * Trieda ScoreBoard spravuje zobrazenie skore a stavu hraca na obrazovke.
 *
 * @autor Jakub Gubany
 */
public class ScoreBoard {
    private int score;
    private double bank;
    private PlayerData playerData;
    private TextBlock totalCoins;
    private TextBlock totalScore;
    /**
     * Vytvori novy scoreboard s danym skore a poctom minci.
     *
     * @param score aktualne skore hraca
     * @param bank aktualny stav banky hraca
     */
    public ScoreBoard(int score, double bank) {
        this.score = score;
        this.bank = bank;
        this.playerData = PlayerData.getInstance();
        this.playerData.setBank(this.bank);
        this.playerData.setScore(this.score);

        this.totalCoins = new TextBlock(String.format("Total coins in a packet : %.2f", this.bank));
        this.totalCoins.changeFont("Pixelify sans", FontStyle.BOLD, 40);
        this.totalCoins.changeColor("white");
        this.totalCoins.changePosition(1220, 700);

        this.totalScore = new TextBlock(String.format("Total score is : %d", this.score));
        this.totalScore.changeFont("Pixelify sans", FontStyle.BOLD, 40);
        this.totalScore.changeColor("white");
        this.totalScore.changePosition(1220, 780);
    }
    /**
     * Aktualizuje text na obrazovke.
     */
    public void updateScreenText() {
        this.totalCoins.changeText(String.format("Total coins in a packet : %.2f", this.bank));
        this.totalScore.changeText(String.format("Total score is : %d", this.score));
    }
    /**
     * Zobrazi alebo skryje skore na obrazovke.
     *
     * @param show true, ak ma byt skore zobrazene, inak false
     */
    public void showScoreOnScreen(boolean show) {
        if (show) {
            this.totalScore.makeVisible();
            this.totalCoins.makeVisible();
        } else {
            this.totalScore.makeInvisible();
            this.totalCoins.makeInvisible();
        }
    }
    /**
     * Ziska stav coinov hraca.
     *
     * @return stav coinov hraca
     */
    public double getBank() {
        return this.bank;
    }
    /**
     * Odrata z banky hraca dany pocet minci.
     *
     * @param coins pocet minci, ktory sa ma odratat
     */
    public void subtractCoins(double coins) {
        this.bank -= coins;
        this.playerData.setBank(this.bank);
        this.totalCoins.changeText(String.format("Total coins in a packet : %.2f", this.bank));
    }
    /**
     * Prida do poctu mincii hraca dany pocet minci.
     *
     * @param bank pocet minci, ktory sa ma pridat
     */
    public void addCoins(double bank) {
        this.bank += bank;
        this.playerData.setBank(this.bank);
        this.totalCoins.changeText(String.format("Total coins in a packet : %.2f", this.bank));
    }
    /**
     * Prida hracovi skore.
     */
    public void addScore() {
        this.score += 1;
        this.playerData.setScore(this.score);
        this.totalScore.changeText(String.format("Total score is : %d", this.score));
    }
    /**
     * Ziska informacie o hracovi.
     *
     * @return informacie o hracovi
     */
    public PlayerData getPlayerData() {
        return this.playerData;
    }
    /**
     * Nastavi skore hraca.
     *
     * @param score skore, ktore sa ma nastavit
     */
    public void setScore(int score) {
        this.score = score;
    }
    /**
     * Nastavi stav poctu minci hraca.
     *
     * @param bank stav poctu minci, ktory sa ma nastavit
     */
    public void setBank(double bank) {
        this.bank = bank;
    }
}
