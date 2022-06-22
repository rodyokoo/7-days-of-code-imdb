import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class APIConsumerTop250 {
	
	private HttpResponse<String> response;
	
	public APIConsumerTop250(String key){
		HttpRequest request = HttpRequest
				.newBuilder()
				.GET()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/" + key))
				.build();
		
		HttpClient client = HttpClient.newBuilder().build();
		try {
			this.response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

	public HttpResponse<String> getResponse() {
		return response;
	}	
}
