package screens;

import characters.PlayerData;
import room.RoomManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class EndOfGame {
    private JButton newGameButton;
    private JButton exitButton;
    private JPanel panel;
    private JButton menu;
    private JFrame frame;
    private static final EndOfGame RESET = new EndOfGame();
    private EndOfGame() {
        this.frame = new JFrame("Game over");
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PlayerData data = PlayerData.getInstance();
                    FileWriter writer = new FileWriter("src/saving/playersHistory.txt", true);
                    writer.write(String.format("Player : %s | Score : %d \n", data.getName(), data.getScore()));
                    writer.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                RoomManager manager = RoomManager.getInstance();
                manager.end();
                EndOfGame.this.frame.dispose();
            }
        });
    }
    public static EndOfGame getInstance() {
        return RESET;
    }


}
