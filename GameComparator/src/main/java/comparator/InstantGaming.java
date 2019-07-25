package comparator;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class InstantGaming implements Interface {

	@Override
	public void checkSource(String juego, GameComparator modelo) {
		String url=getSearchURL(juego);
		Document doc = null;
		try {
			doc=Jsoup.connect(url).get();
		}catch(Exception e){
			System.out.println("ERROR\nERROR\nERROR CON JSOUP");
		}
        try{
            String url2=getURL(doc);
            modelo.setUrlIG(url2);
            modelo.setPrecioIG(getPrice(doc));
            modelo.setUrlImagenIG(getImage(doc));
        }catch(Exception e){
            modelo.setPrecioIG("");
            modelo.setUrlIG("");
            modelo.setUrlImagenIG("");
        }
	}

	@Override
	public String getSearchURL(String juego) {
		String url = "https://www.instant-gaming.com/es/busquedas/?q=";
        
        juego = juego.replaceAll(" ", "+");
        url = url+juego;
        //System.out.println(url);
        return url;
	}

	@Override
	public String getPrice(Document doc) throws IOException {
		String precio="";		

        Elements e=doc.getElementsByClass("price");
        precio=e.first().text();
        return precio;
	}

	@Override
	public String getImage(Document doc) throws IOException {
		String urlIG="";

        Elements e=doc.getElementsByClass("picture mainshadow");
        urlIG=e.first().select("img").attr("src");
        //System.out.println("Img:" + urlIG + "\n");
        return urlIG;
	}

	@Override
	public String getURL(Document doc) throws IOException {
		String urlIG="";

        Elements e=doc.getElementsByClass("categoryBest item mainshadow");
        if (!e.isEmpty()){
            urlIG=e.first().select("a").attr("href");
            //System.out.println("URL: " + urlIG );
        }else{
            e=doc.getElementsByClass(" item mainshadow");
            urlIG=e.first().select("a").attr("href");
            //System.out.println("URL: " + urlIG );
        }
        return urlIG;
	}

}
