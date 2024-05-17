package screens;

import room.RoomManager;

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
        //this.frame.getContentPane().setBackground(Color.black); //TODO nastavit farbu pozadia na ciernu.
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);

        this.newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManager roomManager = RoomManager.getInstance();
                StartingScreen.this.frame.dispose();
            }

        });
        this.loadPreviousGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FileInputStream input = new FileInputStream("src/saving/gameSave.bin");
                    ObjectInputStream stream = new ObjectInputStream(input);

                    RoomManager game = (RoomManager)stream.readObject();
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
