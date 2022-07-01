import java.util.ArrayList;
import java.util.List;

public class JSONToList{
	
	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}
	
	public JSONToList(ToJSON itemsArray) {
		
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
		
		this.movies = new ArrayList<>();
		
		for(int i = 0; i < itemsArray.getItemsArray().length(); i++) {
			Movie movie = new Movie();
			movie.setTitle(titles.get(i));
			movie.setImage(urlImages.get(i));
			movie.setRating(Double.parseDouble(imDbRatings.get(i)));
			movie.setYear(Integer.parseInt(years.get(i)));
			this.movies.add(movie);
		}
	}

}
