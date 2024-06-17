/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterreads;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bmara
 */
public class UserReviews {
    
    File reviews = new File("BetterReadsReviews.txt");
    File reviewsOnly = new File("BetterReadsReviewsOnly.txt");
    
    
    public void addReview(String book, String review, String user, String rating){
        String newReview = "\" " + review + "\" - " + user + "*" + rating + "-" + book;
        
        File temp;
        try {
            Scanner s = new Scanner(reviewsOnly);
            temp = File.createTempFile("temp-file-name", ".tmp");
        
        BufferedReader br = new BufferedReader(new FileReader(reviews));
        PrintWriter pw =  new PrintWriter(new FileWriter(temp));
        PrintWriter pwTwo =  new PrintWriter(new FileWriter(reviewsOnly, true));
        String line;
        int lineCount = 0;
        while ((line= br.readLine()) != null) {
            pw.println(line);
            if(line.toLowerCase().equals(book.toLowerCase())){
                pw.println(newReview);
            }
        }
            pwTwo.println(newReview);
            pwTwo.close();
            br.close();
            pw.close();
            s.close();
            reviews.delete();
            temp.renameTo(reviews);
        } catch (IOException ex) {
            System.out.println("ji");
        }
    }
    
    public ArrayList<Book> findRecommendations(){
        int numOfRecommendedBooks = 3;
        ArrayList<Book> recommendedBooks = new ArrayList<>();
        for(int i = 0; i < numOfRecommendedBooks; i++){
            Book s = new Book(0);
            recommendedBooks.add(s);
        }
        ArrayList<Book> books = getBooks();
        for(Book b: books){
            ArrayList<Review> reviews = findReviews(b.getName());
            if(reviews == null){
                continue;
            }
            for(Review r: reviews){
                b.setStudentRating(parseFloat(r.getRating()));
            }
            float rating = b.getStudentRating();
            for(int i = numOfRecommendedBooks - 1; i >= 0; i--){
                if (rating > recommendedBooks.get(i).getStudentRating() && i == 0){
                    recommendedBooks.addFirst(b);
                } else if(rating > recommendedBooks.get(i).getStudentRating() && rating <= recommendedBooks.get(i-1).getStudentRating()){
                    recommendedBooks.add(i,b);
                } else if (rating > recommendedBooks.get(i).getStudentRating()){
                    continue;
                } else {
                    break;
                }
            }
            try{
                recommendedBooks.remove(numOfRecommendedBooks);
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        return recommendedBooks;
    }
    
    public ArrayList<Book> getBooks(){
        ArrayList<Book> bookShelf = new ArrayList<>();
        GoogleBooksAPI api = new GoogleBooksAPI();
        String currLine;
        try{
            BufferedReader br = new BufferedReader(new FileReader(reviews));
            
            while((currLine = br.readLine()) != null){
                if(currLine.charAt(0) != 34){
                    bookShelf.add(api.findBook(currLine).get(0));
                }
            }
            br.close();
            return bookShelf;
            
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    
    public void deleteReview(int count){
        File temp;
        File tempTwo;
        
        try {
            temp = File.createTempFile("temporary-file-name", ".tmp");
            tempTwo = File.createTempFile("temporaryTwo-file-name", ".tmp");
            int counter=0;
        
        BufferedReader br = new BufferedReader(new FileReader(reviewsOnly));
        PrintWriter pw =  new PrintWriter(new FileWriter(temp), true);
        BufferedReader brTwo = new BufferedReader(new FileReader(reviews));
        PrintWriter pwTwo =  new PrintWriter(new FileWriter(tempTwo),true);
        String deletedReview = "";
        String line;
        String lineTwo;
        while ((line = br.readLine()) != null) {
            counter++;
            if(!(counter == count)){
                pw.println(line);
            }
            else {
                deletedReview = line;
            }
        }
        while ((lineTwo = brTwo.readLine()) != null) {
            if(!(lineTwo.toLowerCase().equals(deletedReview.toLowerCase()))){
                pwTwo.println(lineTwo);
            }
        }
        br.close();
        pw.close();
        brTwo.close();
        pwTwo.close();
        reviewsOnly.delete();
        reviews.delete();
        temp.renameTo(reviewsOnly);
        tempTwo.renameTo(reviews);
        } catch (IOException ex) {
            Logger.getLogger(UserReviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Review> getAllReviews(){
        ArrayList<Review> reviews = new ArrayList<Review>();
        
        try {
            Scanner s = new Scanner(reviewsOnly);
            while (s.hasNext()){
                String line = s.nextLine();
                String[] parts;
                parts = line.split("[\\-*]");
                Review newReview = new Review(parts[0].trim().replace("\"", ""), parts[1].trim(), parts[2].trim(), parts[3].trim());
                reviews.add(newReview);
            }
            System.out.println(reviews.toString());
            s.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Hold up, wait a minute, something aint right");
        } catch (Exception e){
            System.out.println(e);
        }
        
        return reviews;
    }
    
    public void addBook(Book book){
        
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(reviews, true));
            PrintWriter pw2 = new PrintWriter(new FileWriter(reviewsOnly, true));
            pw.println(book.print());
            for (Review reviews: book.getReviews()){
                pw.println(reviews.printReview());
                pw2.println(reviews.printReview());
            }
            pw.flush();
            pw.close();
            pw2.flush();
            pw2.close();
        } catch (IOException ex) {
            System.out.println("Something went wrong");
        }
        
    }
    
    public ArrayList<Review> findReviews(String name){
        
        ArrayList<Review> reviewsList = new ArrayList<Review>();
        try {
            Scanner s = new Scanner(reviews);
            String data = s.nextLine();
            name = name.toLowerCase();
            data = data.toLowerCase();
            while (!data.equals(name)){
                data = s.nextLine();
                data = data.toLowerCase();
            }
            
            while (s.hasNextLine()) {
                
                data = s.nextLine();
                    if (data.startsWith("\"")) {
                        String[] parts;
                        parts = data.split("[\\-*]");
                        Review newReview = new Review(parts[0].trim().replace("\"", ""), parts[1].trim(), parts[2].trim(), parts[3].trim());
                        reviewsList.add(newReview);
                    }
                    else {
                break; // Exit the loop if the line does not start with a quotation mark
                }
            }
            s.close();
            return reviewsList;
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        } 
        return null;
    }
    public boolean findBook(String name){
        
        try {
            Scanner s = new Scanner(reviews);
            name = name.toLowerCase();
            String data = s.nextLine();
            while (!data.toLowerCase().equals(name.toLowerCase())){
                data = s.nextLine();
            }
            if (data.toLowerCase().equals(name.toLowerCase())){
                return true;
            }
            s.close();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return false;
    }
    
}

