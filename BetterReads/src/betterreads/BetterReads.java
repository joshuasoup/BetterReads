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
    
//    public void addReview(String book, String review, String user, String rating){

    
    
    public static void main(String[] args) {

        new LoginScreen().setVisible(true);
        UserReviews ur = new UserReviews();
        
        ArrayList<Book> b = ur.findRecommendations();
//        ArrayList<Review> s = ur.findReviews("harry Potter and the Cursed Child");
//        for(int i = 0; i < s.size(); i++){
//            System.out.println(s.get(i).toString());
//        }
    }
}