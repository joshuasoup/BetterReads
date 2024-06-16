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
    private int studentRating;
    private int numOfRatings;
    private String author;
    
    
    public Book(JSONObject o){
        UserReviews ur = new UserReviews();
        JSONObject volumeInfo = o.getJSONObject("volumeInfo");
        name = volumeInfo.getString("title");
        try{
            description = volumeInfo.getString("description");
        } catch (Exception e ) {
            description = "";
            System.out.println(e);
        }
        
        try{
            pageCount = volumeInfo.getInt("pageCount");
        } catch (Exception e){
            pageCount = 0;
        }
        
        try{
            onlineRating = volumeInfo.getInt("averageRating");
        }catch (Exception e){
            System.out.println(e);
            onlineRating = 0;
        }
        
        try{
            JSONObject s = o.getJSONObject("searchInfo");
            snippet = s.getString("textSnippet");
        }catch(Exception e){
            snippet = "";
            System.out.println(e);
        }
        
        try{
            bookCover = volumeInfo.getJSONObject("imageLinks").getString("thumbnail");
        } catch (Exception e){
            System.out.println(e);
            bookCover = "";
        }
        
        try{
            author = volumeInfo.getJSONArray("authors").getString(0);
        }catch(Exception e){
            System.out.println(e);
            author = "";
        }
        
        
        //volumeInfo JObject, description String, pageCount Int, categories JSONArray
        //averageRating int, imageLinks String, searchInfo JObject - textSnippet String
    }
    
    public ArrayList<Review> getReviews() {
        return reviews;
    }
    
    public String bookInfo(){
        return((name + " | " + description + " | " + pageCount + " | " + onlineRating + " | " + snippet + " | " + bookCover));
    }
    
    public void setStudentRating(int totalRating){
        studentRating = (int)(totalRating/numOfRatings);
    }
    
    public int getStudentRating(){
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
    
    public Book(ArrayList<Review> reviews, String name){
        setReviews(reviews);
        setName(name);
        
    }
    public Book(String name){
        setName(name);
    }
    public String print(){
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

    public String getSnippet() {
        return snippet;
    }

    public String getBookCover() {
        return bookCover;
    }
    
}
