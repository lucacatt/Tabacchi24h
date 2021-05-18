
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mattia
 */

public class FrameProdotto extends javax.swing.JFrame {

    private FileManagment file;
    private ArrayList<Prodotto> pr;
    private Prodotto p;
    private Seriale s;
    private int counter;
    private int spos;
    int begin;

    public FrameProdotto() {
        initComponents();
        KeyListener key = new KeyListener(this);
        key.start();
        Repaint r = new Repaint(this);
        r.start();
        file = new FileManagment();
        pr = new ArrayList<Prodotto>();
        Button1.setFocusPainted(false);
        jButton2.setFocusPainted(false);
        jButton1.setFocusPainted(false);
        jButton3.setFocusPainted(false);
        counter = 0;
        spos = 1;
        jButton4.setFocusPainted(false);
        p = new Prodotto();
        begin = 0;
    }

    public void setP(Prodotto p) {
        this.p = p;
    }

    @Override
    public void paint(Graphics g) {
        this.add(Button1);
        this.add(jButton2);
        this.add(jButton1);
        this.add(jButton3);
        this.add(jButton4);
        if (begin == 0) {
            if (Dati.getInstance().getPos() == 0) {
                Button1.setLabel("Inserisci Tabacchi");
                file.setPath("Sigarette.txt");
            } else if (Dati.getInstance().getPos() == 1) {
                Button1.setLabel("Inserisci Bibita");
                file.setPath("Bibite.txt");
            } else if (Dati.getInstance().getPos() == 2) {
                Button1.setLabel("Inserisci Snack");
                file.setPath("Snack.txt");
            }
            begin = 1;
        }
        try {
            pr = file.ReadFile();
            counter = pr.size();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrameProdotto.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image offscreen = createImage(this.getWidth() - 400, this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        Image off = createImage(this.getWidth() - 400, this.getHeight());
        Graphics of = offscreen.getGraphics();
        offgc.setColor(new Color(186, 186, 186));
        offgc.fill3DRect(6, 16, 305, 16, rootPaneCheckingEnabled);
        offgc.fill3DRect(311, 16, 305, 16, rootPaneCheckingEnabled);
        offgc.fill3DRect(615, 16, 305, 16, rootPaneCheckingEnabled);
        offgc.fill3DRect(920, 16, 305, 16, rootPaneCheckingEnabled);
        offgc.fill3DRect(1220, 16, 305, 16, rootPaneCheckingEnabled);
        offgc.setColor(Color.BLACK);
        offgc.drawString("Nome Prodotto", 120, 30);
        offgc.drawString("Prezzo Prodotto", 420, 30);
        offgc.drawString("Immagine Prodotto", 720, 30);
        offgc.drawString("E' Per Maggiorenni", 1020, 30);
        offgc.drawString("Scorte", 1370, 30);
        var l = 0;
        var f = 2;
        for (int i = 0; i < pr.size(); i++) {
            if (i == spos - 1) {
                if (i < 6) {
                    offgc.setColor(Color.cyan);
                    jButton4.setText("Visualizza " + pr.get(i).getNomeProdotto());
                    setP(pr.get(i));
                    offgc.fill3DRect(6, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(311, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(615, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(920, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(1220, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.setColor(Color.BLACK);
                    offgc.drawString(pr.get(i).getNomeProdotto(), 120, 15 * (i + 3) + 1 + l++);
                    offgc.drawString(pr.get(i).getPrezzo(), 450, 15 * (i + 3) + 1 + l);
                    if (pr.get(i).getImmProdotto().length() < 50) {
                        offgc.drawString(pr.get(i).getImmProdotto(), 615, 15 * (i + 3) + 1 + l);
                    } else {
                        offgc.drawString(pr.get(i).getImmProdotto().substring(0, 50) + "...", 615, 15 * (i + 3) + 1 + l);
                    }
                    if (pr.get(i).isMaggiorenne() == true) {
                        offgc.drawString("SI", 1070, 15 * (i + 3) + 1 + l);
                    } else {
                        offgc.drawString("NO", 1070, 15 * (i + 3) + 1 + l);
                    }
                    switch (Dati.getInstance().getPos()) {
                        case 0 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/20", 1370, 15 * (i + 3) + 1 + l);
                        case 1 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 1 + l);
                        default ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 1 + l);
                    }
                } else {
                    offgc.setColor(Color.cyan);
                    jButton4.setText("Visualizza " + pr.get(i).getNomeProdotto());
                    setP(pr.get(i));
                    offgc.fill3DRect(6, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(311, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(615, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(920, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(1220, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.setColor(Color.BLACK);
                    offgc.drawString(pr.get(i).getNomeProdotto(), 120, 15 * (i + 3) + 2 + f++);
                    offgc.drawString(pr.get(i).getPrezzo(), 450, 15 * (i + 3) + 2 + f);
                    if (pr.get(i).getImmProdotto().length() < 50) {
                        offgc.drawString(pr.get(i).getImmProdotto(), 615, 15 * (i + 3) + 3 + f);
                    } else {
                        offgc.drawString(pr.get(i).getImmProdotto().substring(0, 50) + "...", 615, 15 * (i + 3) + 2 + f);
                    }
                    if (pr.get(i).isMaggiorenne() == true) {
                        offgc.drawString("SI", 1070, 15 * (i + 3) + 2 + f);
                    } else {
                        offgc.drawString("NO", 1070, 15 * (i + 3) + 2 + f);
                    }
                    switch (Dati.getInstance().getPos()) {
                        case 0 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/20", 1370, 15 * (i + 3) + 2 + f);
                        case 1 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 2 + f);
                        default ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 2 + f);
                    }
                }
            } else {
                if (i < 6) {
                    offgc.setColor(new Color(230, 230, 230));
                    offgc.fill3DRect(6, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(311, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(615, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(920, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(1220, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.setColor(Color.BLACK);
                    offgc.drawString(pr.get(i).getNomeProdotto(), 120, 15 * (i + 3) + 1 + l);
                    offgc.drawString(pr.get(i).getPrezzo(), 450, 15 * (i + 3) + 1 + l);
                    if (pr.get(i).getImmProdotto().length() < 50) {
                        offgc.drawString(pr.get(i).getImmProdotto(), 615, 15 * (i + 3) + 1 + l);
                    } else {
                        offgc.drawString(pr.get(i).getImmProdotto().substring(0, 50) + "...", 615, 15 * (i + 3) + 1 + l);
                    }
                    if (pr.get(i).isMaggiorenne() == true) {
                        offgc.drawString("SI", 1070, 15 * (i + 3) + 1 + l);
                    } else {
                        offgc.drawString("NO", 1070, 15 * (i + 3) + 1 + l);
                    }
                    switch (Dati.getInstance().getPos()) {
                        case 0 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/20", 1370, 15 * (i + 3) + 1 + l);
                        case 1 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 1 + l);
                        default ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 1 + l);
                    }
                } else {
                    offgc.setColor(new Color(230, 230, 230));
                    jButton4.setText("Visualizza " + pr.get(i).getNomeProdotto());
                    setP(pr.get(i));
                    offgc.fill3DRect(6, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(311, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(615, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(920, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.fill3DRect(1220, 16 * (i + 2), 305, 16, rootPaneCheckingEnabled);
                    offgc.setColor(Color.BLACK);
                    offgc.drawString(pr.get(i).getNomeProdotto(), 120, 15 * (i + 3) + 2 + f++);
                    offgc.drawString(pr.get(i).getPrezzo(), 450, 15 * (i + 3) + 2 + f);
                    if (pr.get(i).getImmProdotto().length() < 50) {
                        offgc.drawString(pr.get(i).getImmProdotto(), 615, 15 * (i + 3) + 2 + f);
                    } else {
                        offgc.drawString(pr.get(i).getImmProdotto().substring(0, 50) + "...", 615, 15 * (i + 3) + 2 + f);
                    }
                    if (pr.get(i).isMaggiorenne() == true) {
                        offgc.drawString("SI", 1070, 15 * (i + 3) + 2 + f);
                    } else {
                        offgc.drawString("NO", 1070, 15 * (i + 3) + 2 + f);
                    }
                    switch (Dati.getInstance().getPos()) {
                        case 0 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/20", 1370, 15 * (i + 3) + 2 + f);
                        case 1 ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 2 + f);
                        default ->
                            offgc.drawString(String.valueOf(pr.get(i).getScorte()) + "/40", 1370, 15 * (i + 3) + 2 + f);
                    }
                }
            }
        }
        g.drawImage(offscreen, 0, 0, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        Button1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        setResizable(false);

        jButton2.setText("Ritorna al menu'");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Button1.setText("jButton1");
        Button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button1MouseClicked(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jButton1.setText("↑");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jButton3.setText("↓");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Visualizza");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(1561, 1561, 1561)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                    .addComponent(Button1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(148, 148, 148))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(220, 220, 220))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(Button1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(510, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Startup st;
        try {
            st = new Startup();
            Dati.getInstance().setSpos(0);
            st.setVisible(true);
            st.setExtendedState(st.getExtendedState() | JFrame.MAXIMIZED_BOTH);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(FrameProdotto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void Button1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button1MouseClicked
        InserimentoProdotto pr = new InserimentoProdotto();
        pr.setPath(file.getFilePath());
        pr.setExtendedState(pr.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        pr.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_Button1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (spos >= 2) {
            spos--;

        } else {
            spos = counter;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (spos < counter) {
            spos++;
        } else {
            spos = 1;
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        VisualizzaProdotto vis = new VisualizzaProdotto();
        vis.visP(p);
        vis.setExtendedState(vis.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setVisible(false);
        vis.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
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
            java.util.logging.Logger.getLogger(FrameProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameProdotto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrameProdotto f = new FrameProdotto();
                f.setVisible(true);
            }
        }
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    // End of variables declaration//GEN-END:variables
}
