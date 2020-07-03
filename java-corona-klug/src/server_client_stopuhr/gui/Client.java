package server_client_stopuhr.gui;

import com.google.gson.Gson;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server_client_stopuhr.Request;
import server_client_stopuhr.Response;

/**
 *
 * @author Simon Klug
 */
public class Client extends javax.swing.JFrame {
    
    private boolean trytoStart;
    private boolean trytoStop;
    private boolean trytoClear;
    private boolean trytoEnd;
    
    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
        setTitle("Stopwatch");
        setMinimumSize(new Dimension(300, 220));
        setSize(new Dimension(400, 300));
        jlabTimer.setText("0.000");
        jbutConnect.setEnabled(true);
        jbutDisconnect.setEnabled(false);
        jbutStart.setEnabled(false);
        jbutStop.setEnabled(false);
        jbutClear.setEnabled(false);
        jbutEnd.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpanButtons = new javax.swing.JPanel();
        jbutConnect = new javax.swing.JButton();
        jbutDisconnect = new javax.swing.JButton();
        jbutStart = new javax.swing.JButton();
        jbutStop = new javax.swing.JButton();
        jbutClear = new javax.swing.JButton();
        jbutEnd = new javax.swing.JButton();
        jpanNorth = new javax.swing.JPanel();
        jlabs = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jlabms = new javax.swing.JLabel();
        jpanCenter = new javax.swing.JPanel();
        jlabTimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpanButtons.setLayout(new java.awt.GridBagLayout());

        jbutConnect.setText("Connect");
        jbutConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutConnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 24;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutConnect, gridBagConstraints);

        jbutDisconnect.setText("Disconnect");
        jbutDisconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutDisconnectActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutDisconnect, gridBagConstraints);

        jbutStart.setText("Start");
        jbutStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutStartActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutStart, gridBagConstraints);

        jbutStop.setText("Stop");
        jbutStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutStopActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 46;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutStop, gridBagConstraints);

        jbutClear.setText("Clear");
        jbutClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 42;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutClear, gridBagConstraints);

        jbutEnd.setText("End");
        jbutEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutEndActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.insets = new java.awt.Insets(1, 2, 1, 3);
        jpanButtons.add(jbutEnd, gridBagConstraints);

        getContentPane().add(jpanButtons, java.awt.BorderLayout.LINE_END);

        jlabs.setText("Refreshrate: 1s");
        jpanNorth.add(jlabs);

        jSlider1.setMaximum(99);
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpanNorth.add(jSlider1);

        jlabms.setText("1ms");
        jpanNorth.add(jlabms);

        getContentPane().add(jpanNorth, java.awt.BorderLayout.PAGE_START);

        jpanCenter.setFont(new java.awt.Font("Dialog", 0, 72)); // NOI18N
        jpanCenter.setLayout(new java.awt.GridBagLayout());

        jlabTimer.setFont(new java.awt.Font("Dialog", 1, 72)); // NOI18N
        jlabTimer.setText("0.000");
        jpanCenter.add(jlabTimer, new java.awt.GridBagConstraints());

        getContentPane().add(jpanCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbutDisconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutDisconnectActionPerformed
        jbutConnect.setEnabled(true);
        jbutDisconnect.setEnabled(true);
        jbutStart.setEnabled(true);
        jbutStop.setEnabled(false);
        jbutClear.setEnabled(false);
        jbutEnd.setEnabled(false);
    }//GEN-LAST:event_jbutDisconnectActionPerformed

    private void jbutStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStopActionPerformed
        trytoStop = true;
    }//GEN-LAST:event_jbutStopActionPerformed

    private void jbutEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutEndActionPerformed
        trytoEnd = true;
    }//GEN-LAST:event_jbutEndActionPerformed

    private void jbutConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutConnectActionPerformed
        jbutConnect.setEnabled(false);
        jbutDisconnect.setEnabled(true);
        jbutStart.setEnabled(true);
        jbutStop.setEnabled(false);
        jbutClear.setEnabled(false);
        jbutEnd.setEnabled(true);

        System.out.println("Button pressed" + Thread.currentThread().getId());
        ConnectionWorker worker = null;
        try {
            worker = new MyConnectionWorker(8080, "127.0.0.1");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        worker.execute();
    }//GEN-LAST:event_jbutConnectActionPerformed

    private void jbutStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutStartActionPerformed
        trytoStart = true;
    }//GEN-LAST:event_jbutStartActionPerformed

    private void jbutClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutClearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbutClearActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    private class MyConnectionWorker extends ConnectionWorker {

        private Response resp;
        private Socket socket;
        private boolean tryToStart;
        private boolean tryToStop;
        private boolean tryToClear;
        private boolean tryToEnd;

        private MyConnectionWorker(int port, String host) throws IOException {
            super(port, host);
        }

        
        @Override
        protected void done() {
            try {
                String ergebnis = (String) get();
                System.out.println(ergebnis + " " + Thread.currentThread().getId());
                jlabTimer.setText(ergebnis);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(Client.this, "Unbekannter Fehler", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }

        @Override
        protected void process(List<Response> list) {

            for (Response resp : list) {
                if (resp.isMaster()) {
                    jbutConnect.setEnabled(false);
                    jbutDisconnect.setEnabled(true);
                    jbutStart.setEnabled(true);
                    jbutStop.setEnabled(true);
                    jbutClear.setEnabled(true);
                    jbutEnd.setEnabled(true);
                } else {
                    jbutConnect.setEnabled(false);
                    jbutDisconnect.setEnabled(true);
                    jbutStart.setEnabled(false);
                    jbutStop.setEnabled(false);
                    jbutClear.setEnabled(false);
                    jbutEnd.setEnabled(false);
                }

                if (resp.isRunning()) {
                    jbutStart.setEnabled(false);
                    jbutStop.setEnabled(true);
                    jbutClear.setEnabled(true);
                } else {
                    jbutStart.setEnabled(true);
                    jbutStop.setEnabled(false);
                    jbutClear.setEnabled(false);
                }
                jlabTimer.setText(String.format("%.3f", resp.getTime()));
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton jbutClear;
    private javax.swing.JButton jbutConnect;
    private javax.swing.JButton jbutDisconnect;
    private javax.swing.JButton jbutEnd;
    private javax.swing.JButton jbutStart;
    private javax.swing.JButton jbutStop;
    private javax.swing.JLabel jlabTimer;
    private javax.swing.JLabel jlabms;
    private javax.swing.JLabel jlabs;
    private javax.swing.JPanel jpanButtons;
    private javax.swing.JPanel jpanCenter;
    private javax.swing.JPanel jpanNorth;
    // End of variables declaration//GEN-END:variables
}
