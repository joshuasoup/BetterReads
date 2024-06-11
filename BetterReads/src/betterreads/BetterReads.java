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
        GoogleBooksAPI api = new GoogleBooksAPI();
        api.findBook("9786070705359");
    }
    

}
