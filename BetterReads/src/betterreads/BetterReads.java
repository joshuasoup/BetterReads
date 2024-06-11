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
GoogleBooksAPI api = new GoogleBooksAPI();
        public ArrayList<Book> books = api.findBook("9786070705359");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GoogleBooksAPI api = new GoogleBooksAPI();
        ArrayList<Book> books = api.findBook("9786070705359");
        String test = books.get(0).getBookCover();
        System.out.println(books.size());
        System.out.println(test);
    }
    

}
