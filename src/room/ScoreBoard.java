package room;

import fri.shapesge.FontStyle;
import fri.shapesge.TextBlock;

public class ScoreBoard {
    private int score;
    private double bank;
    private TextBlock totalCoins;
    private TextBlock totalScore;

    public ScoreBoard(int score, double bank) {
        this.score = score;
        this.bank = bank;
        this.totalCoins = new TextBlock(String.format("Total coins in a pocket : %.2f", this.bank));
        this.totalCoins.changeFont("Pixelify sans", FontStyle.BOLD, 40);
        this.totalCoins.changeColor("white");
        this.totalCoins.changePosition(1220, 700);
        this.totalScore = new TextBlock(String.format("Total score is : %d", this.score));
        this.totalScore.changeFont("Pixelify sans", FontStyle.BOLD, 40);
        this.totalScore.changeColor("white");
        this.totalScore.changePosition(1220, 780);
    }
    public void showScoreOnScreen(boolean show) {
        if (show) {
            this.totalScore.makeVisible();
            this.totalCoins.makeVisible();
        } else {
            this.totalScore.makeInvisible();
            this.totalCoins.makeInvisible();
        }
    }
    public double getBank() {
        return this.bank;
    }
    public void subtractCoins(double coins) {
        this.bank -= coins;
        this.totalCoins.changeText(String.format("Total coins in a pocket : %d", this.bank));
    }
    public void addCoins(double bank) {
        this.bank += bank;
        this.totalCoins.changeText(String.format("Total coins in a pocket : %d", this.bank));
    }
    public void addScore() {
        this.score += 1;
        this.totalScore.changeText(String.format("Total score is : %d", this.score));
    }
}
