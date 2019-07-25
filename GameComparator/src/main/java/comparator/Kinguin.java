package comparator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Kinguin implements Interface {

	@Override
	public void checkSource(String juego, GameComparator modelo) {
		String url=getSearchURL(juego);
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
		}catch(Exception e){
			System.out.println("ERROR\nERROR\nERROR CON JSOUP");
		}
		
		String url2=""; 
        try{
        	url2=getURL(doc);
            modelo.setUrlKinguin(url2);
        }catch(Exception e){
            if (modelo.getPrecioKinguin() == "" ||
            		modelo.getPrecioKinguin() == null)
				modelo.setPrecioKinguin("no data");
        }
        
        try{
            modelo.setPrecioKinguin(getPrice(doc));
        }catch(Exception e){
            if (modelo.getUrlKinguin() == "" ||
            		modelo.getUrlKinguin() == null)
            	modelo.setUrlKinguin("no data");
        }
        try{
            modelo.setUrlImagenKinguin(getImage(doc));
        }catch(Exception e){          
            if (modelo.getUrlImagenKinguin() == "" ||
            		modelo.getUrlImagenKinguin() == null)
            	modelo.setUrlImagenKinguin(modelo.getUrlImagenIG());
        }
	}

	@Override
	public String getSearchURL(String juego) {
		String url = "https://www.kinguin.net/catalogsearch/result/index/?q=";
        
        juego = juego.replaceAll(" ", "+");
        url = url+juego;
        //System.out.println(url);
        return url;
	}

	@Override
	public String getPrice(Document doc) throws IOException {
		String precio="";
		
        Elements e=doc.getElementsByClass("actual-price");
        try{
            precio=e.first().text();
        }catch(Exception exception){
        	precio="No hemos podido encontrarlo";
            
        }
        return precio;
	}

	@Override
	public String getImage(Document doc) throws IOException {
		String urlKinguin="";
		
        Elements e=doc.getElementsByClass("main-image");
        
    	if (e.first().select("img").size() > 1)
    		urlKinguin=e.first().select("img").remove(1).attr("src").toString();
    	else
    		urlKinguin=e.first().select("img").attr("src").toString();
        return urlKinguin;
        
	}

	@Override
	public String getURL(Document doc) throws IOException {
		String urlKinguin="";
		
        Elements e=doc.getElementsByClass("all-offers");
        urlKinguin=e.first().select("a").attr("href");
        return urlKinguin;
	}

}
