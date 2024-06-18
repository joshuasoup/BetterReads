/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterreads;

import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author bmara
 */
public class Book {

    private ArrayList<Review> reviews;
    private String name;
    private String description;
    private int pageCount;
    private int onlineRating;
    private String snippet;
    private String bookCover;
    private float studentRating;
    private int numOfRatings;
    private String author;
    private float totalRating;
    
    /**
     * This constructor takes a JSONObject and extracts various book details from it.
     * If a detail is not found, a default value is assigned.
     *
     * @author Josh Souphanthong
     * @param o The JSONObject containing book details.
     */
    public Book(JSONObject o) {
        // Create a new UserReviews object
        UserReviews ur = new UserReviews();

        // Get the "volumeInfo" object from the JSONObject
        JSONObject volumeInfo = o.getJSONObject("volumeInfo");

        // Get the book's title
        name = volumeInfo.getString("title");

        // Try to get the book's description, if it doesn't exist, set it to an empty string
        try {
            description = volumeInfo.getString("description");
        } catch (Exception e) {
            description = "";
        }

        // Try to get the book's page count, if it doesn't exist, set it to 0
        try {
            pageCount = volumeInfo.getInt("pageCount");
        } catch (Exception e) {
            pageCount = 0;
        }

        // Try to get the book's online rating, if it doesn't exist, set it to 0
        try {
            onlineRating = volumeInfo.getInt("averageRating");
        } catch (Exception e) {
            onlineRating = 0;
        }

        // Try to get the book's snippet, if it doesn't exist, set it to an empty string
        try {
            JSONObject s = o.getJSONObject("searchInfo");
            snippet = s.getString("textSnippet");
        } catch (Exception e) {
            snippet = "";
        }

        // Try to get the book's cover image link, if it doesn't exist, set it to an empty string
        try {
            bookCover = volumeInfo.getJSONObject("imageLinks").getString("thumbnail");
        } catch (Exception e) {
            bookCover = "";
        }

        // Try to get the book's author, if it doesn't exist, set it to an empty string
        try {
            author = volumeInfo.getJSONArray("authors").getString(0);
        } catch (Exception e) {
            author = "";
        }
    }

    
    public Book(int rating){
        studentRating = rating;
    }
    
    
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public String bookInfo() {
        return ((name + " | " + description + " | " + pageCount + " | " + onlineRating + " | " + snippet + " | " + bookCover));
    }
    
    /**
    * This method is used to set the student's rating.
    * It does this by adding the new rating to the total rating, incrementing the number of ratings,
    * and then calculating the average rating.
    *
    * @author Josh Souphanthong
    * @param rating The new rating to be added.
    */
   public void setStudentRating(float rating){
       // Add the new rating to the total rating
       totalRating += rating;

       // Increment the number of ratings
       numOfRatings ++;

       // Calculate the average rating
       studentRating = (totalRating/numOfRatings);
   }

    
    public float getStudentRating(){
        return studentRating;
    }
    

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(ArrayList<Review> reviews, String name) {
        setReviews(reviews);
        setName(name);

    }

    public Book(String name) {
        setName(name);
    }

    public String print() {
        return getName();
    }

    public String getDescription() {
        return description;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getOnlineRating() {
        return onlineRating;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSnippet() {
        return snippet;
    }

    public String getBookCover() {
        return bookCover;
    }
    
    @Override
    public String toString(){
        return name;
    }

    public int getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(int numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public float getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(float totalRating) {
        this.totalRating = totalRating;
    }
}
