
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia e Stefano
 */
public class Dati {

    private static Dati _instance;
    private boolean refresh;
    private boolean connected;
    private String event;
    private String WriteSerial;
    private int Key;
    private int spos;
    private int pos;
    private char lastspos;
    private boolean wr;
    private ArrayList<String> nomi;
    private ArrayList<Integer> quantita;

    public synchronized boolean isWr() {
        return wr;
    }

    public synchronized void setWr(boolean wr) {
        this.wr = wr;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public synchronized char getLastspos() {
        return lastspos;
    }

    public synchronized void setLastspos(char lastspos) {
        this.lastspos = lastspos;
    }

    public synchronized int getKey() {
        return Key;
    }

    public synchronized String getWriteSerial() {
        return WriteSerial;
    }

    public synchronized void setWriteSerial(String WriteSerial) {
        this.WriteSerial = WriteSerial;
    }

    public synchronized void setKey(int Key) {
        this.Key = Key;
    }

    private Dati() {
        refresh = false;
        connected = false;
        event = "";
        spos = 0;
        lastspos = ' ';
        wr = true;
        nomi = new ArrayList<String>();
        quantita = new ArrayList<Integer>();
    }

    public int getSpos() {
        return spos;
    }

    public void setSpos(int spos) {
        this.spos = spos;
    }

    public synchronized boolean isConnected() {
        return connected;
    }

    public synchronized String getEvent() {
        if (!"".equals(event)) {
            return event;
        } else {
            return "";
        }
    }

    public synchronized void setEvent(String event) {
        this.event = event;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public synchronized boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
    }

    public static Dati getInstance() {
        if (_instance == null)
    synchronized (Dati.class) {
            if (_instance == null) {
                _instance = new Dati();
            }
        }
        return _instance;
    }

    public synchronized void salva(boolean metodo, String nome) throws IOException {
        if (metodo) {
            addProdotto(nome);
        } else {
            salvaggio();
        }
    }

    public void addProdotto(String nome) {
        boolean aggiunto = false;
        for (int i = 0; i < nomi.size(); i++) {
            if (nome == nomi.get(i)) {
                quantita.set(i, quantita.get(i) + 1);
                aggiunto = true;
            }
        }
        if (!aggiunto) {
            nomi.add(nome);
            quantita.add(1);
        }
    }

    public void salvaggio() throws IOException {
        FileManagment salva = new FileManagment();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        salva.setPath(formattedDate + ".txt");
        String save = "";
        for (int i = 0; i < nomi.size(); i++) {
            save += nomi.get(i) + quantita.get(i) + "\n";
        }
        salva.WriteToFile(save);
        nomi = new ArrayList<String>();
        quantita = new ArrayList<Integer>();
    }
}
