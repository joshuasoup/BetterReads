/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterreads;

import java.util.ArrayList;

/**
 *
 * @author bmara
 */
public class Book {

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }
    
    private ArrayList<Review> reviews;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    private String name;
    
    public Book(ArrayList<Review> reviews, String name){
        setReviews(reviews);
        setName(name);
        
    }
    public String print(){
        return getName();
    }
    
}
