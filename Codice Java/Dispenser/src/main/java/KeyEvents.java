
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class KeyEvents implements KeyListener {

    private JFrame frame;
    public static ArrayList<Integer> keys;

    public KeyEvents(JFrame frame) {
        this.frame = frame;
        keys = new ArrayList<Integer>();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains((Integer) e.getKeyCode())) {
            keys.add((Integer) e.getKeyCode());
        }
    }

    public void handleKeyInput() {

        if (keys.contains(10)) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            Dati.getInstance().setKey(10);
        }
        if (keys.contains(37)) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            Dati.getInstance().setKey(37);
        }
        if (keys.contains(39)) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            Dati.getInstance().setKey(39);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keys.contains((Integer) e.getKeyCode())) {
            keys.remove((Integer) e.getKeyCode());
        }
    }

}
