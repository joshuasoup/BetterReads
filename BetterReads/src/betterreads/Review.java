/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package betterreads;

/**
 *
 * @author bmara
 */
public class Review {

    private String rating;
    private String user;
    private String review;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Review(String user, String review, String rating) {
        setUser(user);
        setReview(review);
        setRating(rating);
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String printReview() {
        String print = "\" " + getReview() + "\" - " + getUser() + "*" + getRating();
        return print;
    }
}
