
import javax.swing.JFrame;

public class KeyListener extends Thread {

    private JFrame frame;

    public KeyListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        KeyEvents keys = new KeyEvents(frame);
        frame.addKeyListener(keys);
        while (!Dati.getInstance().isRefresh()) {
            keys.handleKeyInput();
        }
    }
}
