package characters;

import java.io.Serializable;

public class PlayerData implements Serializable {
    private int score;
    private double bank;
    private double hp;
    private static final PlayerData INSTANCE = new PlayerData();
    private PlayerData() {
        this.score = 0;
    }
    public static PlayerData getInstance() {
        return INSTANCE;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setBank(double bank) {
        this.bank = bank;
    }
    public void setHp(double hp) {
        this.hp = hp;
    }
    public int getScore() {
        return this.score;
    }
    public double getBank() {
        return this.bank;
    }
    public double getHp() {
        return this.hp;
    }
}
