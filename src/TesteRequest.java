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

public class TesteRequest {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		APIConsumerTop250 api = new APIConsumerTop250("k_o1yvy4b8");
		
		ToJSON itemsArray = new ToJSON(api);
		
		List<String> titles = new ArrayList<>();
		List<String> fullTitles = new ArrayList<>();
		List<String> urlImages = new ArrayList<>();
		List<String> years = new ArrayList<>();
		List<String> crews = new ArrayList<>();
		List<String> imDbRatings = new ArrayList<>();
		List<String> imDbRatingCounts = new ArrayList<>();
		
		for(int i = 0; i < itemsArray.getItemsArray().length(); i++) {
			titles.add(itemsArray.getItemsArray().getJSONObject(i).getString("title"));
			fullTitles.add(itemsArray.getItemsArray().getJSONObject(i).getString("fullTitle"));
			urlImages.add(itemsArray.getItemsArray().getJSONObject(i).getString("image"));
			years.add(itemsArray.getItemsArray().getJSONObject(i).getString("year"));
			crews.add(itemsArray.getItemsArray().getJSONObject(i).getString("crew"));
			imDbRatings.add(itemsArray.getItemsArray().getJSONObject(i).getString("imDbRating"));
			imDbRatingCounts.add(itemsArray.getItemsArray().getJSONObject(i).getString("imDbRatingCount"));
		}
		
		List<Movie> movies = new ArrayList<>();
		
		for(int i = 0; i < itemsArray.getItemsArray().length(); i++) {
			Movie movie = new Movie();
			movie.setTitle(titles.get(i));
			movie.setImage(urlImages.get(i));
			movie.setRating(Double.parseDouble(imDbRatings.get(i)));
			movie.setYear(Integer.parseInt(years.get(i)));
			movies.add(movie);
		}
		
//		movies.forEach(System.out::println);
		HTMLGenerator html = new HTMLGenerator();
		html.insertList(movies);

	}
}
