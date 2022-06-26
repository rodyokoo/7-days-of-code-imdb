import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		APIConsumerTop250 api = new APIConsumerTop250("k_o1yvy4b8");
		
		ToJSON itemsArray = new ToJSON(api);

		List<Movie> movieList = new ImDbMovies(itemsArray).getMovies();
		
		HTMLGenerator html = new HTMLGenerator();
		
		html.insertList(movieList);

	}
}
