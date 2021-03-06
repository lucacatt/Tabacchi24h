
import java.io.File;
import com.github.sarxos.webcam.Webcam;
import com.pqscan.barcodereader.BarCodeType;
import com.pqscan.barcodereader.BarcodeResult;
import com.pqscan.barcodereader.BarcodeScanner;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia
 */
public class WebcamT extends Thread {

    @Override
    public void run() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        while (!Dati.getInstance().isRefresh()) {
            if (Dati.getInstance().getEvent().length() != 0 && 'w' == Dati.getInstance().getEvent().charAt(0)) {
                for (int i = 0; i < 5; i++) {
                    try {
                        ImageIO.write(webcam.getImage(), "PNG", new File("Barcode.png"));
                    } catch (IOException ex) {
                        Logger.getLogger(WebcamT.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                BarcodeResult[] results = BarcodeScanner.Scan("Barcode.png", BarCodeType.Code39);
                if (results != null && '0' == (results[0].getData().charAt(6))) {
                    if (Calendar.getInstance().get(Calendar.YEAR) - (2000 + Integer.parseInt(String.valueOf(results[0].getData().charAt(7)))) >= 18) {
                        Dati.getInstance().setWriteSerial("+");
                    } else {
                        Dati.getInstance().setWriteSerial("-");
                    }
                } else if (results != null && 1 >= (results[0].getData().charAt(6)) - 48 && 9 <= (results[0].getData().charAt(6)) - 48) {
                    Dati.getInstance().setWriteSerial("+");
                } else {
                    Dati.getInstance().setWriteSerial(".");
                }
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(WebcamT.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
