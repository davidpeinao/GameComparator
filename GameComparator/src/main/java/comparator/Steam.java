package comparator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Steam implements Interface {

	
	// de momento se deja todo lo de kinguin como este
	// por si no sirve esta fuente de datos
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
		String url = "https://store.steampowered.com/search/?term=";
        
        juego = juego.replaceAll(" ", "+");
        url = url+juego;
        System.out.println(url);
        return url;
	}

	@Override
	public String getPrice(Document doc) throws IOException {
		String precio="";		
        
        Elements e=doc.getElementsByClass("col search_price  responsive_secondrow");
        precio=e.first().text();
        System.out.println("Steam \nPrecio: " + precio);
        return precio;
	}

	@Override
	public String getImage(Document doc) throws IOException {
		String urlSteam="";
		
        Elements e=doc.getElementsByClass("col search_capsule");
        urlSteam=e.first().select("img").attr("src");
        System.out.println("Img:" + urlSteam + "\n");
        return urlSteam;
        
	}

	@Override
	public String getURL(Document doc) throws IOException {
		String urlSteam="";
		
        Element e=doc.getElementById("search_result_container");
        urlSteam = e.select("a").attr("href");
            System.out.println("URL: " + urlSteam );
        return urlSteam;
	}

}
