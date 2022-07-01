import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException{
		
		APIConsumerTop250 api = new APIConsumerTop250("k_o1yvy4b8");
		
		ToJSON itemsArray = new ToJSON(api);

		List<Movie> movieList = new JSONToList(itemsArray).getMovies();
		

		Collections.sort(movieList, new Comparator<Movie>() {
			public int compare(Movie movie1, Movie movie2) {
				return Double.compare(movie1.getRating(), movie2.getRating());
			}
		});
		
		HTMLGenerator html = new HTMLGenerator();
		
		html.insertList(movieList);

	}

}
