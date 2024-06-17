/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package betterreads;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Jaden Wickens
 */
public class LoginScreen extends javax.swing.JFrame {

    private final int TEACHERLOGIN = 1234;
    private BufferedImage betterReadsLogo;
    private BufferedImage nhsLogo;

    /**
     * Creates new form LoginScreen
     */
    public LoginScreen() {
        //fill all variables and call all relevant methods
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
        loadImage();
        Color c = new Color(255,255,255);
        getContentPane().setBackground(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginConfirm = new javax.swing.JButton();
        idInputField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        loginMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(36, 39, 43));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        loginConfirm.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 18)); // NOI18N
        loginConfirm.setText("Login");
        loginConfirm.setToolTipText("");
        loginConfirm.setBorderPainted(false);
        loginConfirm.setOpaque(true);
        loginConfirm.setPreferredSize(new java.awt.Dimension(79, 50));
        loginConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginConfirmActionPerformed(evt);
            }
        });

        idInputField.setBackground(new java.awt.Color(240, 240, 240));
        idInputField.setFont(new java.awt.Font("Kohinoor Gujarati", 0, 18)); // NOI18N
        idInputField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idInputField.setBorder(null);
        idInputField.setRequestFocusEnabled(false);
        idInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputFieldActionPerformed(evt);
            }
        });

        loginMessage.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 48)); // NOI18N
        loginMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginMessage.setText("Scan Student Card or Enter StudentID");
        loginMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idInputField)
                    .addComponent(loginConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(300, 300, 300))
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(loginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addComponent(loginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(idInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Handles the action performed when the login button is clicked.
     * Checks the user ID entered in the text field. If the user ID matches the teacher login ID, it opens the Teacher Control Screen.
     * Otherwise, it opens the Search Screen with the entered user ID.
     * If the input is not a valid number, it prompts the user to enter a valid ID.
     * - Jaden
     * 
     * @param evt the action event triggered when the login button is clicked
     */
    private void loginConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginConfirmActionPerformed
        try {
            Long userId = Long.parseLong(idInputField.getText());
            if (userId == 1234) {
                TeacherControlScreen t = new TeacherControlScreen();
                t.setVisible(true);
                this.dispose();
            } else {
                SearchScreen s = new SearchScreen(userId);
                s.setVisible(true);
                this.dispose();
            }
        } catch (NumberFormatException e) {
            loginMessage.setText("Please enter valid ID");
            idInputField.setText("");
            idInputField.requestFocusInWindow();
        }

    }//GEN-LAST:event_loginConfirmActionPerformed

    private void idInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputFieldActionPerformed
    /**
     * Loads the images used in the login screen.
     * Attempts to read the Better Reads and NHS logos from the file system.
     * If the images are not found, an IOException is caught and the stack trace is printed.
     * - Jaden
     */
    private void loadImage() {
        try {
            betterReadsLogo = ImageIO.read(new File("Better Reads Logo (1).png"));
            nhsLogo = ImageIO.read(new File("nhslogo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * Paints the login screen, including the Better Reads and NHS logos.
     * This method overrides the paint method of the JFrame class.
     * The logos are drawn at the top-left and top-right corners, respectively.
     * The size of the logos is dynamically determined based on the screen size.
     * - Jaden
     * 
     * @param g the Graphics object used for drawing
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int size = Math.max(this.getWidth(), this.getHeight()) / 4;
        if (betterReadsLogo != null) {
            // Draw the Better Reads logo at the top-left corner
            g.drawImage(betterReadsLogo, 0, 0, size, size, null);
        }
        if (nhsLogo != null) {
            // Draw the NHS logo at the top-right corner
            int x = this.getWidth() - size;
            g.drawImage(nhsLogo, x, 0, size, size, null);
        }
    }

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
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField idInputField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginConfirm;
    private javax.swing.JLabel loginMessage;
    // End of variables declaration//GEN-END:variables
}
