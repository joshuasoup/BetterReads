package betterreads;

// import org.json.JSONObject;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import java.net.*;

public class GoogleBooksAPI {

    private final String isbn = "9786070705359";
    URL url;
    HttpURLConnection req;

    public GoogleBooksAPI() {
        try {
            url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + isbn);
            req = (HttpURLConnection) url.openConnection();
            req.setRequestMethod("GET");

            Object o = req.getContent();
            System.out.println(o);
            BufferedReader in = new BufferedReader(new InputStreamReader(req.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            // JSON jobject = new JSONObject(response.toString());

            // Close the input stream
            in.close();
            // System.out.println("Response: " + response.toString());

        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
