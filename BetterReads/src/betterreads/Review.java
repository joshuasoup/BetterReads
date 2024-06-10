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

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Review(User user, String review){
        setUser(user);
        setReview(review);
    }
    
    private User user;
    private String review;

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    public String printReview(){
        String print = "\" " + getReview() + "\" - " + getUser().getId();
        return print;
    }
}
