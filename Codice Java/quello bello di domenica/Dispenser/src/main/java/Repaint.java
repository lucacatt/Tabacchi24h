
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Repaint extends Thread {

    private JFrame frame;
    private Dati data;

    public Repaint(JFrame panel) {
        this.frame = panel;
        data=Dati.getInstance();
    }

    @Override
    public void run() {
       while(!data.isRefresh()){
           frame.repaint();
           try {
               Thread.sleep(7);
           } catch (InterruptedException ex) {
               Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
}
