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

		HttpRequest request = HttpRequest
				.newBuilder()
				.GET()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/k_o1yvy4b8"))
				.build();
		
		HttpClient client = HttpClient.newBuilder().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//		System.out.println(response.body());
		
		JSONObject json = new JSONObject(response.body());
//		System.out.println(json.toString(1));
		
		JSONArray itemsArray = json.getJSONArray("items");
		
		List<String> titles = new ArrayList<>();
		List<String> fullTitles = new ArrayList<>();
		List<String> urlImages = new ArrayList<>();
		List<String> years = new ArrayList<>();
		List<String> crews = new ArrayList<>();
		List<String> imDbRatings = new ArrayList<>();
		List<String> imDbRatingCounts = new ArrayList<>();
		
		for(int i = 0; i < itemsArray.length(); i++) {
			titles.add(itemsArray.getJSONObject(i).getString("title"));
			fullTitles.add(itemsArray.getJSONObject(i).getString("fullTitle"));
			urlImages.add(itemsArray.getJSONObject(i).getString("image"));
			years.add(itemsArray.getJSONObject(i).getString("year"));
			crews.add(itemsArray.getJSONObject(i).getString("crew"));
			imDbRatings.add(itemsArray.getJSONObject(i).getString("imDbRating"));
			imDbRatingCounts.add(itemsArray.getJSONObject(i).getString("imDbRatingCount"));
		}
		
		for(String str: crews) {
			System.out.println(str);
		}
	}
}
