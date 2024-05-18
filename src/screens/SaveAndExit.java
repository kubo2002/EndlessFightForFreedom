package screens;

import room.RoomManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveAndExit {
    private JButton saveAndExitButton;
    private JButton exitWithoutSaveButton;
    private JPanel panel;
    private JFrame frame;

    public SaveAndExit() {
        this.frame = new JFrame("Castle siege");
        this.frame.setContentPane(this.panel);
        this.frame.pack();
        //this.frame.getContentPane().setBackground(Color.black); //TODO nastavit farbu pozadia na ciernu.
        this.frame.setSize(1920, 1080);
        this.frame.setVisible(true);
        this.saveAndExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RoomManager room = RoomManager.getInstance();
                try {
                    File file = new File("src/saving/gameSave.ser");
                    FileOutputStream input = new FileOutputStream(file);
                    ObjectOutputStream stream = new ObjectOutputStream(input);
                    stream.writeObject(room);
                    stream.close();
                } catch (Exception ex) {
                    ex.getStackTrace();
                }
                room.end();
                SaveAndExit.this.frame.dispose();
            }
        });
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
