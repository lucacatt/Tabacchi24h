
import arduino.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia e Stefano
 */
public class Seriale extends Thread {

    private Arduino sp;
    private FileManagment gestione;

    @Override
    public void run() {
        sp = new Arduino();
        sp.setPortDescription("COM4");
        sp.setBaudRate(19200);
        String s = "";
        do {
            if (sp.openConnection()) {
                Dati.getInstance().setConnected(true);
            } else {
                Dati.getInstance().setConnected(false);
            }
            while (Dati.getInstance().isConnected()) {
                try {
                    Thread.sleep(1000);
                    sp.openConnection();
                    s = sp.serialRead();
                    if (!"".equals(s)) {
                        gestione.stockUpdate(s);
                        Dati.getInstance().salva(true, s);
                        Dati.getInstance().setEvent(s);
                        s = "";
                        sp.closeConnection();
                    } else {
                        s = "";
                    }
                    if (!"".equals(Dati.getInstance().getWriteSerial()) && Dati.getInstance().getWriteSerial() != null) {
                        sp.openConnection();
                        sp.serialWrite(Dati.getInstance().getWriteSerial());
                        Dati.getInstance().setWriteSerial("");
                    }
                } catch (Exception e) {
                }
            }
        } while (!Dati.getInstance().isRefresh());
    }
}