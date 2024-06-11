/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterreads;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bmara
 */
public class UserReviews {
    
    File users = new File("BetterReadsUsers");
    File reviews = new File("BetterReadsReviews.txt");
    File reviewsOnly = new File("BetterReadsReviewsOnly.txt");
    
    public void addReview(Book book, String review, String user, String rating){
        User newUser = new User(user);
        Review newReview = new Review(newUser, user, rating);
        book.getReviews().add(newReview);
    }
    
    public void addBook(Book book){
        
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(reviews, true));
            pw.println(book.print());
            for (Review reviews: book.getReviews()){
                pw.println(reviews.printReview());
            }
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        
    }
    public void addReviewsToFile(){
            String print = "";
            PrintWriter pw;
        try {
            pw = new PrintWriter(new FileWriter(reviewsOnly, true));
        
            Scanner s = new Scanner(reviews);
            String data = s.nextLine();
            while (s.hasNextLine()) {
                data = s.nextLine();
                if (data.startsWith("\"")) {
                    print += data + "\n";
                }
            }
            String cleanedPrint = print.toString().replaceAll("[\\r\\n]+$", "");
            pw.print(cleanedPrint);
            pw.flush();
            pw.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
    }
    public String findReviews(String name){
        
        try {
            String print = "";
            Scanner s = new Scanner(reviews);
            String data = s.nextLine();
            while (!data.equals(name)){
                data = s.nextLine();
            }
            
            while (s.hasNextLine()) {
                data = s.nextLine();
                if (data.startsWith("\"")) {
                    print += data + "\n";
                } else {
                break; // Exit the loop if the line does not start with a quotation mark
                }
            }
            String cleanedPrint = print.toString().replaceAll("[\\r\\n]+$", "");
            return cleanedPrint;
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        return null;
    }
    public String findBook(String name){
        
        try {
            String print = "";
            Scanner s = new Scanner(reviews);
            String data = s.nextLine();
            while (!data.equals(name)){
                data = s.nextLine();
            }
            
            while (s.hasNextLine()) {
                data = s.nextLine();
                if (data.startsWith("\"")) {
                    print += data + "\n";
                } else {
                break; // Exit the loop if the line does not start with a quotation mark
                }
            }
            String cleanedPrint = print.toString().replaceAll("[\\r\\n]+$", "");
            return cleanedPrint;
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        return null;
    }
    
}

