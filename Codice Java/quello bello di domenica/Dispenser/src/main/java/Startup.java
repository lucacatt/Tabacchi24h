
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stefano
 */

public class Startup extends javax.swing.JFrame {

    public Startup() throws IOException {
        initComponents();
        Repaint rep = new Repaint(this);
        rep.start();
        KeyListener key = new KeyListener(this);
        key.start();
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        if (!Dati.getInstance().isConnected()) {
            offgc.drawImage(new javax.swing.ImageIcon("Images\\images.png").getImage(), this.getWidth() / 2 - 200, this.getHeight() / 2 - 200, 300, 314, this);
            offgc.setColor(Color.red);
            offgc.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
            offgc.drawString("AVVIO IN CORSO", this.getWidth() / 2 - 160, this.getHeight() / 2 + 80);
        } else {
            offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
            offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
            offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
            offgc.setColor(Color.white);
            for (int i = 0; i < 4; i++) {
                offgc.drawLine(320, 622 + i, 521, 622 + i);
            }
            if (Dati.getInstance().getKey() == 39) {
                if (Dati.getInstance().getSpos() == 0) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('d');
                    Dati.getInstance().setSpos(1);
                } else if (Dati.getInstance().getSpos() == 1) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('d');
                    Dati.getInstance().setSpos(2);
                } else if (Dati.getInstance().getSpos() == 2) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('d');
                    Dati.getInstance().setSpos(0);
                }
            }
            if (Dati.getInstance().getKey() == 37) {
                if (Dati.getInstance().getSpos() == 0) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('s');
                    Dati.getInstance().setSpos(2);
                } else if (Dati.getInstance().getSpos() == 1) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('s');
                    Dati.getInstance().setSpos(0);
                } else if (Dati.getInstance().getSpos() == 2) {
                    Dati.getInstance().setKey(0);
                    Dati.getInstance().setLastspos('s');
                    Dati.getInstance().setSpos(1);
                }
            }
            if (Dati.getInstance().getLastspos() == 'd') {
                offgc = Right(offgc);
            } else if (Dati.getInstance().getLastspos() == 's') {
                offgc = Left(offgc);
            }
            if (Dati.getInstance().getKey() == 10 && Dati.getInstance().getSpos() != -1) {
                this.setVisible(false);
                FrameProdotto fp = new FrameProdotto();
                fp.setVisible(true);
                fp.setExtendedState(fp.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                Dati.getInstance().setPos(Dati.getInstance().getSpos());
                Dati.getInstance().setKey(0);
                Dati.getInstance().setSpos(-1);
            }
        }
        g.drawImage(offscreen, 0, 0, null);
    }

    private Graphics Right(Graphics offgc) {
        switch (Dati.getInstance().getSpos()) {
            case 1:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(820, 622 + i, 1020, 622 + i);
                }
                return offgc;
            case 2:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(1320, 622 + i, 1580, 622 + i);
                }
                return offgc;
            case 0:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(320, 622 + i, 521, 622 + i);
                }
                return offgc;
            default:
                break;
        }
        return offgc;
    }

    private Graphics Left(Graphics offgc) {
        switch (Dati.getInstance().getSpos()) {
            case 1:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(820, 622 + i, 1020, 622 + i);
                }
                return offgc;
            case 2:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(1320, 622 + i, 1580, 622 + i);
                }
                return offgc;
            case 0:
                offgc.drawImage(new javax.swing.ImageIcon("Images\\HERO-ART-microsoft_azure_1920x1000_nologo.jpg").getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lastampatabacchi.png").getImage(), 300, 300, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\lemon-water.jpg").getImage(), 800, 300, 248, 314, this);
                offgc.drawImage(new javax.swing.ImageIcon("Images\\d9657d2229731ed2bd5debc01b20f9fa.jpg").getImage(), 1300, 300, 300, 314, this);
                offgc.setColor(Color.white);
                for (int i = 0; i < 4; i++) {
                    offgc.drawLine(320, 622 + i, 521, 622 + i);
                }
                return offgc;
            default:
                break;
        }
        return offgc;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);
        setSize(new java.awt.Dimension(1920, 1080));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     Dati.getInstance().setRefresh(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments3 ò
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Startup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Startup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Startup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Startup.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Dati data;
        data = Dati.getInstance();
        Seriale arduino = new Seriale();
        GestioneScorte scorte = new GestioneScorte();
        scorte.start();
        arduino.start();
        WebcamT web = new WebcamT();
        web.start();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Startup f = new Startup();
                    f.setVisible(true);
                    f.setPreferredSize(new Dimension(1920, 1080));
                    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    f.setUndecorated(true);
                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                } catch (IOException ex) {
                    Logger.getLogger(Startup.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    web.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    arduino.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    scorte.join();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Startup.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
