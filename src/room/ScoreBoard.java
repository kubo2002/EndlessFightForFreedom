package room;

public class ScoreBoard {
    private int score;
    public ScoreBoard(int score) {
        this.score = score;
    }
    public void addScore() {
        this.score += 1;
    }
}
