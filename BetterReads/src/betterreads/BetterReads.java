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
//GoogleBooksAPI api = new GoogleBooksAPI();
//        public ArrayList<Book> books = api.findBook("9786070705359");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        UserReviews main = new UserReviews();
        User userOne = new User("1");
        //Review reviewOne = new Review (userOne, "this i greaet!", "4");
        ArrayList<Review> reviews = new ArrayList<Review>();
       // reviews.add(reviewOne);
        Book bookOne = new Book(reviews, "BookThree");
        main.addBook(bookOne);
        //main.addReviewsToFile();
        main.addReview("BookThree", "gugg", "user5", "4");
        


        GoogleBooksAPI api = new GoogleBooksAPI();
        api.findBook("9782226403292");
        ArrayList<Book> books = api.findBook("9786070705359");
        String test = books.get(0).getBookCover();
        System.out.println(books.size());
        System.out.println(test);
//                UserReviews main = new UserReviews();
//
//         //TODO code application logic here
//        User userOne = new User("1");
//        Review reviewOne = new Review (userOne, "this i greaet!", "4");
//        ArrayList<Review> reviews = new ArrayList<Review>();
//        reviews.add(reviewOne);
//        Book bookOne = new Book(reviews, "BookThree");
//        main.addBook(bookOne);
//        //main.addReviewsToFile();
////        main.addReview("BookThree", "gugg", "user5", "4");
//        
//        GoogleBooksAPI api = new GoogleBooksAPI();
//        ArrayList<Book> books = api.findBook("9786070705359");
//        String test = books.get(0).getBookCover();
//        System.out.println(books.size());
//        System.out.println(test);

    }
    

}
