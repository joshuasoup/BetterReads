/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package betterreads;

import betterreads.Book;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author menot
 */
public class SearchScreen extends javax.swing.JFrame {

    private final Long userId;

    private BufferedImage betterReadsLogo;
    private BufferedImage nhsLogo;
    private final GoogleBooksAPI api = new GoogleBooksAPI();
    ArrayList<Book> books;
    private boolean isPopulatingComboBox = false;


    /**
     * Creates new form SearchScreen
     *
     * @param userId allows the inputted userId on the login screen to be sent
     * to this screen
     */
    public SearchScreen(long userId) {
        this.userId = userId;
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
        bookSelector.setEnabled(false);
        loadImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchConfirm = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        scanBookLabel = new javax.swing.JLabel();
        bookSelector = new javax.swing.JComboBox<>();

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setRequestFocusEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Scan Student Card or Enter StudentID");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        searchConfirm.setText("Search");
        searchConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchConfirmActionPerformed(evt);
            }
        });

        logOut.setText("Log Out");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        searchInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        scanBookLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        scanBookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scanBookLabel.setText("Scan Book Barcode or Enter Book Title");

        bookSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bookSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scanBookLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchInput))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(scanBookLabel)
                .addGap(34, 34, 34)
                .addComponent(bookSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(logOut)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadImage() {
        try {
            betterReadsLogo = ImageIO.read(new File("Better Reads Logo (1).png"));
            nhsLogo = ImageIO.read(new File("nhslogo.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

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
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void searchConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchConfirmActionPerformed
        String bookIdentifier = searchInput.getText().replaceAll(" ", "%20");

        books = api.findBook(bookIdentifier);
        System.out.println(books.size());
        if (books.isEmpty()) {
            scanBookLabel.setText("No books found with the given ID. If issue persists, check network connection.");
            bookSelector.setEnabled(false);
            return;
        }
        if (books.size() == 1){
            Book book = books.get(0);
            BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
            b.setVisible(true);
            this.dispose();
        }
        isPopulatingComboBox = true;
        bookSelector.removeAllItems();

        // Add the names of the books to the JComboBox
        for (Book book : books) {
            bookSelector.addItem(book.getName());
        }
        isPopulatingComboBox = false;
        // Enable the JComboBox
        bookSelector.setEnabled(true);
        scanBookLabel.setText("Choose book from menu");
    }//GEN-LAST:event_searchConfirmActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

    private void bookSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSelectorActionPerformed
         if (!isPopulatingComboBox) { // Only perform action if not populating
            int selectedIndex = bookSelector.getSelectedIndex();
            // If a valid selection is made
            if (selectedIndex >= 0) {
                Book book = books.get(selectedIndex);
                BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
                b.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_bookSelectorActionPerformed

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
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchScreen(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bookSelector;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logOut;
    private javax.swing.JLabel scanBookLabel;
    private javax.swing.JButton searchConfirm;
    private javax.swing.JTextField searchInput;
    // End of variables declaration//GEN-END:variables
}
