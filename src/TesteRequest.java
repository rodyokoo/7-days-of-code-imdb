import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

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
		System.out.println(json.toString(2));
	}
}
