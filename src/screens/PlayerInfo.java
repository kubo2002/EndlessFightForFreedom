package screens;

import characters.player.PlayerData;
import room.RoomManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Trieda PlayerInfo reprezentuje obrazovku, na ktorej hráč zadáva svoje meno.
 * Po potvrdení mena sa vytvorí hráč s týmto menom a obrazovka sa zatvorí.
 *
 * @autor Jakub Gubany
 */
public class PlayerInfo {
    private JPanel panel;
    private JButton submitNameButton;
    private JTextField name;
    private JFrame frame;
    /**
     * Konštruktor vytvára nové okno pre zadanie mena hráča.
     * Po stlačení tlačidla na odoslanie mena sa vytvorí hráč s daným menom.
     */
    public PlayerInfo() {
        this.frame = new JFrame("Write your name");
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        /**
         * Posle String s menom hraca do PlayerData a uchová ho počas celej hry.
         */
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
