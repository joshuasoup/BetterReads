/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package betterreads;

import java.util.ArrayList;

/**
 *
 * @author menot
 */
public class BetterReads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserReviews main = new UserReviews();
        User userOne = new User("1");
        Review reviewOne = new Review (userOne, "this i greaet!");
        ArrayList<Review> reviews = new ArrayList<Review>();
        reviews.add(reviewOne);
        Book bookOne = new Book(reviews, "BookThree");
        //main.addBook(bookOne);
        System.out.println(main.findReviews("BookTwo"));
        main.addReviewsToFile();
        

    }
    
}
