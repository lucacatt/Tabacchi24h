
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia
 */
public class GestioneScorte extends Thread {

    private FileManagment file;
    private ArrayList<Prodotto> pr;
    private int lastSentCi;
    private int lastSentDr;
    private int lastSentSn;

    @Override
    public void run() {
        int count = 1;
        lastSentCi = 0;
        lastSentDr = 0;
        lastSentSn = 0;
        file = new FileManagment();
        pr = new ArrayList<Prodotto>();
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (!Dati.getInstance().isRefresh()) {
            switch (count) {
                case 1 -> {
                    if (Dati.getInstance().isWr()) {
                        file.setPath("Sigarette.txt");
                        try {
                            pr = file.ReadFile();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (int i = lastSentCi; i < pr.size(); i++, lastSentCi++) {
                            Dati.getInstance().setWriteSerial(pr.get(i).getNomeProdotto() + ";" + pr.get(i).getPrezzo() + ";" + pr.get(i).isMaggiorenne() + ";" + pr.get(i).getScorte() + ";-");
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    count++;
                }
                case 2 -> {
                    if (Dati.getInstance().isWr()) {
                        file.setPath("Bibite.txt");
                        try {
                            pr = file.ReadFile();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (int i = lastSentDr; i < pr.size(); i++, lastSentDr++) {
                            Dati.getInstance().setWriteSerial(pr.get(i).getNomeProdotto() + ";" + pr.get(i).getPrezzo() + ";" + pr.get(i).isMaggiorenne() + ";" + pr.get(i).getScorte() + ";-");
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    count++;
                }
                case 3 -> {
                    file.setPath("Snack.txt");
                    if (Dati.getInstance().isWr()) {
                        try {
                            pr = file.ReadFile();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        for (int i = lastSentSn; i < pr.size(); i++, lastSentSn++) {
                            Dati.getInstance().setWriteSerial(pr.get(i).getNomeProdotto() + ";" + pr.get(i).getPrezzo() + ";" + pr.get(i).isMaggiorenne() + ";" + pr.get(i).getScorte() + ";-");
                            try {
                                Thread.sleep(4000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(GestioneScorte.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        Dati.getInstance().setWr(false);
                    }
                    count = 1;
                }

            }
        }
    }
}