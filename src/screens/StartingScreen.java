package screens;

import characters.player.Player;
import characters.player.PlayerData;
import room.RoomManager;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * Trieda StartingScreen reprezentuje úvodnú obrazovku hry, kde hráč môže začať novú hru, načítať predchádzajúcu hru alebo ukončiť hru.
 *
 * @autor Jakub Gubany
 */
public class StartingScreen {
    private JPanel panel1;
    private JButton newGameButton;
    private JButton loadPreviousGameButton;
    private JButton exitButton;
    private JFrame frame;
    /**
     * Konštruktor vytvára nové okno úvodnej obrazovky hry.
     *
     * Po stlačení tlačidla "New game" sa otvorí okno pre vytvorenie novej hry.
     * Po stlačení tlačidla "Load previous game" sa načíta predchádzajúca hra.
     * Po stlačení tlačidla "Exit" sa hra ukončí.
     */
    public StartingScreen() {
        this.frame = new JFrame("Castle siege");
        this.frame.setContentPane(this.panel1);
        this.frame.pack();
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        /**
         * Opyta sa hraca ci chce zacat uplne novu hru.
         */
        this.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerInfo info = new PlayerInfo();
                StartingScreen.this.frame.dispose();
            }
        });
        /**
         * Opyta sa hraca ci chce nacitat posledne ulozenu hru a spustit ju.
         */
        this.loadPreviousGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream input = new FileInputStream("src/saving/gameSave.ser");
                    ObjectInputStream stream = new ObjectInputStream(input);

                    RoomManager roomManager = RoomManager.getInstance();
                    Player player = Player.getInstance();

                    var score = (PlayerData)stream.readObject();
                    score.getHp();
                    player.getScoreBoard().setScore(score.getScore());
                    player.getScoreBoard().setBank(score.getBank());
                    player.getHpBar().setHp(score.getHp());
                    player.getScoreBoard().updateScreenText();

                    PlayerData data = PlayerData.getInstance();
                    data.setNameOfPlayer(score.getName());
                    stream.close();

                } catch (Exception ex) {
                    ex.getStackTrace();
                }
                StartingScreen.this.frame.dispose();
            }

        });
        /**
         * Opyta sa hraca ci chce ukoncit dialogove okno a tym sa ani nezapne hra.
         */
        this.exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingScreen.this.frame.dispose();
            }
        });
    }
}
