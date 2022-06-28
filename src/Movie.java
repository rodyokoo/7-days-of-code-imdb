
public class Movie implements Content{
	
	private String title;
	private String image;
	private double rating;
	private int year;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Title: " + title + ", \nImage: " + image + ", \nRating: " + rating + ", \nYear: " + year + "\n";
	}
	@Override
	public String title() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String image() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double rating() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int year() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
