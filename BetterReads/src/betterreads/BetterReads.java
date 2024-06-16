/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package betterreads;

import java.util.ArrayList;

/**
 *
 *
 * @author Jaden Wickens, Joshua Souphanthong, Sam Marandi
 */
public class BetterReads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new LoginScreen().setVisible(true);

        // TODO code application logic here
        UserReviews main = new UserReviews();
        
//        main.deleteReview(1);
        main.addReview("test", "good book","bob", "3");
    }
}