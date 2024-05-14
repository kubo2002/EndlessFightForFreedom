package room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DialogWindow {
    private JPanel mainPanel;
    private JButton battleGround;
    private JButton market;
    private JButton temple;
    private RoomManager roomManager;
    private JFrame frame;
    private boolean isOn;
    public DialogWindow(RoomManager roomManager) {
        this.roomManager = roomManager;
    }
    public void showDialogWindow () {
        this.frame = new JFrame("Choose Room");
        this.frame.setContentPane(this.mainPanel);
        this.frame.pack();
        this.frame.setVisible(true);
        this.isOn = true;
        this.battleGround.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogWindow.this.roomManager.switchRoom(TypeOfRoom.BATTLEGROUND);
                DialogWindow.this.isOn = false;
                DialogWindow.this.frame.dispose();
            }
        });

        this.market.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogWindow.this.roomManager.switchRoom(TypeOfRoom.MARKET);
                DialogWindow.this.isOn = false;
                DialogWindow.this.frame.dispose();
            }
        });

        this.temple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogWindow.this.roomManager.switchRoom(TypeOfRoom.TEMPLE);
                DialogWindow.this.isOn = false;
                DialogWindow.this.frame.dispose();
            }
        });


    }
    public boolean isOn() {
        return this.isOn;
    }
}
