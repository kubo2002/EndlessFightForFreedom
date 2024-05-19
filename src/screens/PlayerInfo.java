package screens;

import characters.PlayerData;
import room.RoomManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerInfo {
    private JPanel panel;
    private JButton submitNameButton;
    private JTextField name;
    private JFrame frame;
    public PlayerInfo() {
        this.frame = new JFrame("Write your name");
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        this.submitNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PlayerData data = PlayerData.getInstance();
                data.setNameOfPlayer(PlayerInfo.this.name.getText());
                RoomManager roomManager = RoomManager.getInstance();
                PlayerInfo.this.frame.dispose();
            }
        });
        this.name.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerInfo.this.frame.dispose();
            }
        });
    }
}
