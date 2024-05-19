package screens;

import characters.player.Player;
import room.RoomManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Trieda SaveAndExit reprezentuje obrazovku,
 * na ktorej hráč môže uložiť svoje rozohrane skore a ukončiť hru alebo ukončiť hru bez ukladania.
 *
 * @autor Jakub Gubany
 */
public class SaveAndExit {
    private JButton saveAndExitButton;
    private JButton exitWithoutSaveButton;
    private JPanel panel;
    private JFrame frame;
    /**
     * Konštruktor vytvára nové okno pre uloženie a ukončenie hry.
     * Po stlačení tlačidla save&exit sa hráčovo skóre uloží a hra sa ukončí.
     * Po stlačení tlačidla exit bez ukladania sa hra ukončí bez uloženia pokroku.
     */
    public SaveAndExit() {
        this.frame = new JFrame("Castle siege");
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        /**
         * Ulozi aktualnu hru do binarneho suboru.
         */
        this.saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManager room = RoomManager.getInstance();
                Player player = Player.getInstance();
                try {
                    File file = new File("src/saving/gameSave.ser");
                    FileOutputStream input = new FileOutputStream(file);
                    ObjectOutputStream stream = new ObjectOutputStream(input);
                    stream.writeObject(player.getScoreBoard().getPlayerData());
                    stream.close();
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
                room.end();
                SaveAndExit.this.frame.dispose();
            }
        });
        /**
         * Ukonci hru bez jej ulozenia.
         */
        this.exitWithoutSaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManager room = RoomManager.getInstance();
                room.end();
                SaveAndExit.this.frame.dispose();
            }
        });
    }
}
