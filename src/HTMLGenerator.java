import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLGenerator {

	private static File file; 
	public HTMLGenerator(List<Movie> movies){
		file = new File("index.html");
		StringBuilder html = new StringBuilder();
		html.append("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor\" crossorigin=\"anonymous\">\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./style.css\"/>\r\n"
				+ "  	<title>#7daysofcode</title>\r\n"
				+ "  </head>\r\n"
				+ "  <body>\r\n"
				+ "		<div>\r\n"
				+ "    		<h1>Top 250 ImDb Movies</h1>\r\n");
		html.append("<div class=\"card-deck\">\r\n");
		for(Movie movie : movies) {
			html.append("  <div class=\"card\">\r\n"
					+ "    <img class=\"card-img-top\" src=\"" + movie.getImage() + "\" alt=\"Card image cap\">\r\n"
					+ "    <div class=\"card-body\">\r\n"
					+ "      <h5 class=\"card-title\">" + movie.getTitle() + "</h5>\r\n"
					+ "    </div>\r\n"
					+ "    <div class=\"card-body\">\r\n"
					+ "      <p class=\"card-text\">Ano: " + movie.getYear() + "</p>\r\n"
					+ "    </div>\r\n"
					+ "    <div class=\"card-body\">\r\n"
					+ "      <p class=\"card-text\">Nota: " + movie.getRating() + "</p>\r\n"
					+ "    </div>\r\n"
					+ "  </div>\r\n");
		}
		html.append("</div>\r\n");
		html.append("</div>\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html>");
		insertHtml(html.toString());
	}
	
	public void insertHtml(String html) {
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(html);
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
