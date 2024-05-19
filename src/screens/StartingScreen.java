package screens;

import characters.Player;
import characters.PlayerData;
import room.RoomManager;
import room.ScoreBoard;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StartingScreen {
    private JPanel panel1;
    private JButton newGameButton;
    private JButton loadPreviousGameButton;
    private JButton exitButton;
    private JFrame frame;
    public StartingScreen() {
        this.frame = new JFrame("Castle siege");
        this.frame.setContentPane(this.panel1);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);

        this.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManager roomManager = RoomManager.getInstance(); // pridat nacitaneho hraca cize nejaky setter tam dat
                StartingScreen.this.frame.dispose();
            }

        });
        this.loadPreviousGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream input = new FileInputStream("src/saving/gameSave.ser");
                    ObjectInputStream stream = new ObjectInputStream(input);

                    RoomManager roomManager = RoomManager.getInstance();
                    Player player = Player.getInstance();

                    var score = (PlayerData)stream.readObject();
                    player.getScoreBoard().setScore(score.getScore());
                    player.getScoreBoard().setBank(score.getBank());
                    player.getHpBar().setHp(score.getHp());
                    player.getScoreBoard().updateScreenText();

                    stream.close();
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
                StartingScreen.this.frame.dispose();
            }

        });
        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingScreen.this.frame.dispose();
            }

        });
    }
}
