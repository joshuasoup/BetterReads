/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package betterreads;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Jaden Wickens
 */
public class AddReviewScreen extends javax.swing.JFrame {

    

    private final long userId;
    private final Book book;
    private final String bookTitle;
    private int rating = 1;

    private BufferedImage yellowStar;
    private BufferedImage greyStar;

    /**
     * Creates new form AddReviewScreen
     */
    public AddReviewScreen(long userId, Book book) {
        this.userId = userId;
        this.book = book;
        bookTitle = book.getName();
        loadImages();
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int starSize = 30;

        int x = 75;
        int y = this.getHeight() - (70 + starSize);

        for (int i = 0; i < 5; i++) {
            if (i < rating) {
                g.drawImage(yellowStar.getScaledInstance(starSize, starSize, Image.SCALE_DEFAULT), x + i * (starSize + 5), y, null);
            } else {
                g.drawImage(greyStar.getScaledInstance(starSize, starSize, Image.SCALE_DEFAULT), x + i * (starSize + 5), y, null);
            }
        }
    }

    private void loadImages() {
        try {
            yellowStar = ImageIO.read(new File("YellowStar.png"));
            greyStar = ImageIO.read(new File("GreyStar.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reviewCancel = new javax.swing.JButton();
        reviewConfirm = new javax.swing.JButton();
        bookTitleLabel = new javax.swing.JLabel();
        reviewContentInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        starRatingSelector = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        reviewCancel.setText("Cancel Review");
        reviewCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewCancelActionPerformed(evt);
            }
        });

        reviewConfirm.setText("Confirm Review");
        reviewConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewConfirmActionPerformed(evt);
            }
        });

        bookTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        bookTitleLabel.setText(bookTitle);

        reviewContentInput.setText("Write Review Here");
        reviewContentInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewContentInputActionPerformed(evt);
            }
        });

        jLabel1.setText("Rating out of 5");

        starRatingSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        starRatingSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starRatingSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reviewContentInput)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reviewCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(62, 62, 62)
                                .addComponent(reviewConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(starRatingSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(67, 67, 67)))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(bookTitleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reviewContentInput, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(starRatingSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewCancel)
                    .addComponent(reviewConfirm))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reviewCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewCancelActionPerformed
        BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reviewCancelActionPerformed

    private void starRatingSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starRatingSelectorActionPerformed
        JComboBox<String> comboBox = (JComboBox<String>) evt.getSource();
        rating = Integer.parseInt((String) comboBox.getSelectedItem());
        repaint();
    }//GEN-LAST:event_starRatingSelectorActionPerformed

    private void reviewConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewConfirmActionPerformed
        String reviewContent = reviewContentInput.getText();
        String reviewRating = starRatingSelector.getSelectedItem().toString();
        UserReviews main = new UserReviews();
        if (main.findBook(bookTitle)){
            main.addReview(bookTitle, reviewContent, String.valueOf(userId), reviewRating);
        }
        else{
            Book book = new Book(bookTitle);
            ArrayList<Review> reviews = new ArrayList<>();
            reviews.add(new Review(reviewContent, String.valueOf(userId), reviewRating));
            book.setReviews(reviews);
            main.addBook(book);
        }
        BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
        b.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_reviewConfirmActionPerformed

    private void reviewContentInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewContentInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reviewContentInputActionPerformed

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
            java.util.logging.Logger.getLogger(AddReviewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReviewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReviewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReviewScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public static GoogleBooksAPI api = new GoogleBooksAPI();
            public static ArrayList<Book> books = api.findBook("9786070705359");
            public void run() {
                new AddReviewScreen(0, books.get(0)).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton reviewCancel;
    private javax.swing.JButton reviewConfirm;
    private javax.swing.JTextField reviewContentInput;
    private javax.swing.JComboBox<String> starRatingSelector;
    // End of variables declaration//GEN-END:variables
}
