package betterreads;

import org.json.JSONObject;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.net.*;
import java.util.ArrayList;
import org.json.JSONArray;

/**
 * This class is responsible for interacting with the Google Books API.
 * It provides a method to find books based on a search term.
 *@author Josh Souphanthong
 */
public class GoogleBooksAPI {
    URL url;
    HttpURLConnection req;

    /**
     * This method takes a search term and returns a list of books that match the term.
     * It does this by making a GET request to the Google Books API and parsing the response.
     *
     * @param searchTerm The term to search for in the Google Books API.
     * @return An ArrayList of Book objects that match the search term.
     */
    public ArrayList<Book> findBook (String searchTerm){
        ArrayList<Book> books = new ArrayList<>();

        try {
            // Replace spaces in the search term with URL-friendly characters
            searchTerm = searchTerm.replaceAll(" ", "%20");

            // Create a URL object with the Google Books API endpoint and the search term
            url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + searchTerm);

            // Open a connection to the URL
            req = (HttpURLConnection) url.openConnection();

            // Set the request method to GET
            req.setRequestMethod("GET");

            // Create a BufferedReader to read the response from the API
            BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            // Read the response line by line and append it to the response StringBuilder
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            // Convert the response to a JSONObject so I can have everything structured nicely
            JSONObject jObject = new JSONObject(response.toString());

            // Get the "items" array from the JSONObject
            JSONArray jArray = jObject.getJSONArray("items");

            // Iterate through the items in the array
            for(int i = 0; i < jArray.length(); i++){
                Book b = new Book(jArray.getJSONObject(i));
                books.add(b);
            }
            in.close();

        } catch (Exception e) {
            // Print any exceptions that occur
            System.out.println(e);
        }

        // Return the list of books
        return books;
    }
}
