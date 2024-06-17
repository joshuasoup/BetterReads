/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package betterreads;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jaden Wickens
 */
public class BookDescriptionScreen extends javax.swing.JFrame {

    private final long userId;
    private Book book;
    GoogleBooksAPI api = new GoogleBooksAPI();
    private UserReviews Urev = new UserReviews();
    private ArrayList<Review> curBookReview;

    /**
     * Creates new form BookDescriptionScreen
     *
     * @param userId
     */
    public BookDescriptionScreen(long userId, Book book) {
        //fill relevant variables and call all relevant methods
        curBookReview = Urev.findReviews(book.getName());
        if (curBookReview == null) {
            curBookReview = new ArrayList<>();
        }
        Urev.findRecommendations();
        this.userId = userId;
        this.book = book;
        initComponents();
        setExtendedState(this.MAXIMIZED_BOTH);
        loadImage(book.getBookCover());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JButton();
        LogOut = new javax.swing.JButton();
        addReviewButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        studentReviewsDisplay = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        LogOut.setText("Log Out");
        LogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutActionPerformed(evt);
            }
        });

        addReviewButton.setText("Add Review");
        addReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReviewButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText(book.getName());

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText(book.getDescription());
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Page count: " + book.getPageCount());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Online Rating: " + book.getOnlineRating());

        studentReviewsDisplay.setColumns(20);
        studentReviewsDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentReviewsDisplay.setLineWrap(true);
        studentReviewsDisplay.setRows(5);
        studentReviewsDisplay.setText(getCurrentBookReviews());
        studentReviewsDisplay.setFocusable(false);
        jScrollPane2.setViewportView(studentReviewsDisplay);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Student Rating: " + getbookAvgRating());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Reviews from your classmates:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Author: " + book.getAuthor());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 72, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back)
                                .addGap(46, 46, 46)
                                .addComponent(addReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(47, 47, 47)
                                .addComponent(LogOut)))
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back)
                    .addComponent(LogOut)
                    .addComponent(addReviewButton))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Handles the action when the 'Back' button is clicked. Opens the
     * SearchScreen for the specified userId. - Jaden
     *
     * @param evt The ActionEvent triggered when the button is clicked.
     */
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        //Creates new search screen with current user, and disposes of the current frame.
        SearchScreen s = new SearchScreen(userId);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * Handles the action when the 'Log Out' button is clicked. Logs the user
     * out by closing the current window and opening a new LoginScreen window. -
     * Jaden
     *
     * @param evt The ActionEvent triggered when the button is clicked.
     */
    private void LogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_LogOutActionPerformed
    /**
     * Handles the action when the 'Add Review' button is clicked. Opens the
     * AddReviewScreen for the specified userId and book, and disposes the
     * current window. - Jaden
     *
     * @param evt The ActionEvent triggered when the button is clicked.
     */
    private void addReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReviewButtonActionPerformed
        AddReviewScreen s = new AddReviewScreen(userId, book);
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addReviewButtonActionPerformed
    /**
     * Calculates the average rating for the current book based on its reviews.
     * - Jaden
     *
     * @return The average rating as a double value. Returns 0 if no valid
     * ratings are found.
     */
    private double getbookAvgRating() {
        //Variable to hold numbers during calculations
        double ratingTemp = 0;
        //for every review of the current book
        for (Review x : curBookReview) {
            try {
                //add together all tatings
                ratingTemp += Integer.parseInt(x.getRating());
            } catch (NumberFormatException e) {
                System.out.println("Rating not integer value");
            }
        }
        //return the total rating devided by the number of ratings (aka. the average)
        return ratingTemp / curBookReview.size();
    }

    /**
     * Generates a formatted text containing all reviews for the current book.
     * Each review is appended with its rating in stars format. - Jaden
     *
     * @return A String containing formatted text listing all reviews for the
     * current book, or null if there are no reviews.
     */
    private String getCurrentBookReviews() {
        // StringBuilder to build the formatted text
        StringBuilder bookReviewsText = new StringBuilder();
        // Flag to determine whether to add a line separator between reviews
        boolean addLine = false;
        // Iterate through each Review object in curBookReview
        for (Review x : curBookReview) {
            // Add line separator if it's not the first review
            if (addLine) {
                bookReviewsText.append("________\n\n");
            }
            addLine = true;
            // Retrieve rating and review text from the Review object
            String rating = x.getRating();
            String review = x.getReview();
            // Append formatted review information to the StringBuilder
            bookReviewsText.append(review + " - " + rating + "/5 Stars\n");
        }

        // Check if there are any reviews in bookReviewsText
        if (bookReviewsText.length() > 0) {
            // Return the formatted reviews as a String
            return bookReviewsText.toString();
        }
        // Return null if there are no reviews
        return null;
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
            java.util.logging.Logger.getLogger(BookDescriptionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookDescriptionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookDescriptionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDescriptionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookDescriptionScreen(0, new Book(new ArrayList(), "BookThree")).setVisible(true);
            }
        });
    }

    /**
     * Loads and displays an image from the specified URL into jLabel4 to show
     * the image of the book. - Jaden
     *
     * @param imageURL The URL of the image to load.
     */
    private void loadImage(String imageURL) {
        //Make sure the url is empty
        if (imageURL == null || imageURL.isEmpty()) {
            return;
        }
        try {
            //Convert the URL to an image of the correct size.
            URL url = new URL(imageURL);
            BufferedImage img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(jLabel4.getWidth(), jLabel4.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            //Put the image in the label
            jLabel4.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOut;
    private javax.swing.JButton addReviewButton;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea studentReviewsDisplay;
    // End of variables declaration//GEN-END:variables
}
