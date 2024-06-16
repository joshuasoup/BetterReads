package betterreads;

import org.json.JSONObject;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.net.*;
import java.util.ArrayList;
import org.json.JSONArray;

public class GoogleBooksAPI {
    URL url;
    HttpURLConnection req;

    public ArrayList<Book> findBook (String searchTerm){
        ArrayList<Book> books = new ArrayList<>();
        try {
            
            url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + searchTerm);
            req = (HttpURLConnection) url.openConnection();
            req.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }             
            JSONObject jObject = new JSONObject(response.toString());
            JSONArray jArray = jObject.getJSONArray("items");
            
            //iterate through the different books with matching isbns
            for(int i = 0; i < jArray.length(); i++){
                Book b = new Book(jArray.getJSONObject(i));
                books.add(b);
            }
            
            // Close the input stream
            in.close();
            

        } catch (Exception e) {
            System.out.println(e);
            
        } 
        return books;
    }
}
