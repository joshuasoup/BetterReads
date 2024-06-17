/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package betterreads;

import betterreads.Book;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Jaden Wickens
 */
public class SearchScreen extends javax.swing.JFrame {

    private final Long userId;

    private BufferedImage betterReadsLogo;
    private BufferedImage nhsLogo;
    private final GoogleBooksAPI api = new GoogleBooksAPI();
    private ArrayList<Book> books;
    private boolean actualAcctionPerformed = false;
    private ArrayList<Book> topBooks;
    private javax.swing.JLabel[] labels;
    private javax.swing.JTextArea[] textAreas;
    private UserReviews Urev = new UserReviews();

    /**
     * Creates new form SearchScreen
     * - Jaden
     *
     * @param userId allows the inputted userId on the login screen to be sent
     * to this screen
     */
    public SearchScreen(long userId) {
        //fill relevant variables and call all relevant methods
        this.userId = userId;
        topBooks = Urev.findRecommendations();
        initComponents();
        labels = new javax.swing.JLabel[]{book1Image, book2Image, book3Image};
        textAreas = new javax.swing.JTextArea[]{book1Info, book2Info, book3Info};
        setExtendedState(this.MAXIMIZED_BOTH);
        bookSelector.setEnabled(false);
        bookSelector.setVisible(false);
        loadImage();
        loadBookImagesAndInfo();
        Color c = new Color(255, 255, 255);
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

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        searchConfirm = new javax.swing.JButton();
        logOut = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        scanBookLabel = new javax.swing.JLabel();
        bookSelector = new javax.swing.JComboBox<>();
        book1Image = new javax.swing.JLabel();
        book2Image = new javax.swing.JLabel();
        book3Image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        book1Info = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        book2Info = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        book3Info = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

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

        searchConfirm.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 18)); // NOI18N
        searchConfirm.setText("Search");
        searchConfirm.setBorder(null);
        searchConfirm.setOpaque(true);
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

        searchInput.setBackground(new java.awt.Color(240, 240, 240));
        searchInput.setFont(new java.awt.Font("Kohinoor Gujarati", 0, 18)); // NOI18N
        searchInput.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchInput.setBorder(null);
        searchInput.setOpaque(true);
        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        scanBookLabel.setFont(new java.awt.Font("Kohinoor Gujarati", 1, 48)); // NOI18N
        scanBookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scanBookLabel.setText("Scan Book Barcode or Enter Book Title");

        bookSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        bookSelector.setBorder(null);
        bookSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSelectorActionPerformed(evt);
            }
        });

        book1Info.setColumns(20);
        book1Info.setRows(5);
        book1Info.setText("Insufficient Reviews");
        book1Info.setFocusable(false);
        jScrollPane1.setViewportView(book1Info);

        book2Info.setColumns(20);
        book2Info.setRows(5);
        book2Info.setText("Insufficient Reviews");
        book2Info.setFocusable(false);
        jScrollPane2.setViewportView(book2Info);

        book3Info.setColumns(20);
        book3Info.setRows(5);
        book3Info.setText("Insufficient Reviews");
        book3Info.setFocusable(false);
        jScrollPane3.setViewportView(book3Info);

        jLabel1.setText("Top Rated Books:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scanBookLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchInput))
                .addGap(300, 300, 300))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(book1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(book2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(book3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(scanBookLabel)
                .addGap(18, 18, 18)
                .addComponent(bookSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(book1Image, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(book3Image, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(book2Image, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logOut)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Draws the BetterReads and NHS logos.
     * - Jaden
     *
     * @param g the Graphics object
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int imageSize = Math.max(this.getWidth(), this.getHeight()) / 4;
        if (betterReadsLogo != null) {
            // Draw the Better Reads logo at the top-left corner
            g.drawImage(betterReadsLogo, 0, 0, imageSize, imageSize, null);
        }
        if (nhsLogo != null) {
            // Draw the NHS logo at the top-right corner
            int x = this.getWidth() - imageSize;
            g.drawImage(nhsLogo, x, 0, imageSize, imageSize, null);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    /**
     * Handles the search button action event. Searches for books using the
     * input from the search field and displays the results. If there is more
     * than one book, open a combo box to allow the user to choose the correct
     * book.
     * - Jaden
     *
     * @param evt the ActionEvent object
     */
    private void searchConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchConfirmActionPerformed
        //get search value from user
        String bookIdentifier = searchInput.getText();
        //get the arraylist of possible books based on the users input
        books = api.findBook(bookIdentifier);
        if (books.isEmpty()) {
            //If there are no books prompt user to try again
            scanBookLabel.setText("No books found with the given ID. If issue persists, check network connection.");
            bookSelector.setEnabled(false);
            return;
        }
        if (books.size() == 1) {
            //if there is one book, open the book discription screen for that book
            Book book = books.get(0);
            BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
            b.setVisible(true);
            this.dispose();
        }
        //create condition that bookSelectorActionPerformed() wont be triggered by updating the contents of the book selector
        actualAcctionPerformed = true;
        bookSelector.removeAllItems();

        // Add the names of the books to the selector
        for (Book book : books) {
            bookSelector.addItem(book.getName());
        }
        //allow for bookSelectorActionPerformed() to be triggered
        actualAcctionPerformed = false;
        // Enable the JComboBox
        bookSelector.setVisible(true);
        bookSelector.setEnabled(true);
        //Instruct uer to choose a book
        scanBookLabel.setText("Choose book from menu");
    }//GEN-LAST:event_searchConfirmActionPerformed

    /**
     * Logs out user when log out button is pressed. Essentially restarts
     * program
     * - Jaden
     *
     * @param evt the ActionEvent object
     */
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
    /**
     * Handles the book selector combo box action event. Allows users to pick
     * the book then want, then openBookDescriptionScreen with that book.
     * - Jaden
     *
     * @param evt the ActionEvent object
     */
    private void bookSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSelectorActionPerformed
        //Only perform actions when the user chooses a book, not when the slector is populated
        if (!actualAcctionPerformed) {
            int selectedIndex = bookSelector.getSelectedIndex();
            // If a valid selection is made
            if (selectedIndex >= 0) {
                //call the book discription scene with that book
                Book book = books.get(selectedIndex);
                BookDescriptionScreen b = new BookDescriptionScreen(userId, book);
                b.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_bookSelectorActionPerformed
    /**
     * Loads images and information for the top recommended books. Retrieves
     * book covers, book names, authors, and ratings and displays them. Displays
     * up to three books on the SearchScreen.
     * - Jaden
     */
    private void loadBookImagesAndInfo() {
        //Find the number of books the will be diplayed. This number is 3, unless there is less than 3 books with ratings.
        int length = Math.min(3, topBooks.size());
        for (int i = 0; i < length; i++) {
            //if there is actually a book in this location
            if (topBooks.get(i) != null && topBooks.get(i).getName() != null) {
                //call the load image function with the image url and the correct label
                loadImage(topBooks.get(i).getBookCover(), labels[i]);
                //update the text area with the info of the book
                textAreas[i].setText(topBooks.get(i).getName() + "\n\n" + topBooks.get(i).getAuthor() + "\n\n" + topBooks.get(i).getStudentRating() + "/5 stars out of " + topBooks.get(i).getNumOfRatings() + " ratings");
            } else {
                //if there is an empty slot print to console
                System.out.println("Book at index " + i + " is null");
            }
        }
    }

    /**
     * Loads the Better Reads and NHS logos from local files. Displays these
     * logos on the SearchScreen.
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
     * Loads an image from a specified URL and sets it to a JLabel. Resizes the
     * image to fit the label dimensions using Image.SCALE_SMOOTH.
     * - Jaden
     *
     * @param imageURL the URL of the image to load
     * @param label the JLabel where the loaded image will be displayed
     */
    private void loadImage(String imageURL, javax.swing.JLabel label) {
        //Make sure the url is not empty
        if (imageURL == null || imageURL.isEmpty()) {
            return;
        }

        try {
            //Convert the URL to an image of the correct size.
            URL url = new URL(imageURL);
            BufferedImage img = ImageIO.read(url);
            Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(dimg);
            //Put the image in the label
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
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
    private javax.swing.JLabel book1Image;
    private javax.swing.JTextArea book1Info;
    private javax.swing.JLabel book2Image;
    private javax.swing.JTextArea book2Info;
    private javax.swing.JLabel book3Image;
    private javax.swing.JTextArea book3Info;
    private javax.swing.JComboBox<String> bookSelector;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logOut;
    private javax.swing.JLabel scanBookLabel;
    private javax.swing.JButton searchConfirm;
    private javax.swing.JTextField searchInput;
    // End of variables declaration//GEN-END:variables
}
