
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stefano
 */
public class Resoconto extends Thread {

    @Override
    public void run() {
        while (true) {
            if(Calendar.getInstance().get(Calendar.HOUR)==0)
                try {
                    Dati.getInstance().salva(false, "");
            } catch (IOException ex) {
                Logger.getLogger(Resoconto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
