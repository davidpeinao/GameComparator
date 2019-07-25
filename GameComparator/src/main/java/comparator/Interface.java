package comparator;

import java.io.IOException;

import org.jsoup.nodes.Document;

public interface Interface{
	
	public void checkSource(String juego, GameComparator modelo);
	public String getSearchURL(String juego);
	public String getPrice(Document doc) throws IOException;
	public String getImage(Document doc) throws IOException;
	public String getURL(Document doc) throws IOException;
	
}