package screens;

import room.RoomManager;
import room.TypeOfRoom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Singleton DialogWindow reprezentuje dialógové okno na výber miestnosti.
 * Umožňuje hráčovi vybrať, do ktorej miestnosti chce vstúpiť.
 *
 * @autor Jakub Gubany
 */
public class DialogWindow {
    private JPanel mainPanel;
    private JButton battleGround;
    private JButton market;
    private JButton temple;
    private JFrame frame;
    private boolean isOn;
    private final RoomManager roomManager = RoomManager.getInstance();
    private static final DialogWindow INSTANCE = new DialogWindow();

    /**
     * Konstruktor triedy.
     */
    private DialogWindow() {

    }
    /**
     * Vráti inštanciu dialógového okna.
     *
     * @return inštancia dialógového okna
     */
    public static DialogWindow getInstance() {
        return INSTANCE;
    }
    /**
     * Zobrazí dialógové okno.
     */
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
    /**
     * Overí, či je dialógové okno zapnuté.
     *
     * @return true, ak je okno zapnuté, inak false
     */
    public boolean isOn() {
        return this.isOn;
    }
}
