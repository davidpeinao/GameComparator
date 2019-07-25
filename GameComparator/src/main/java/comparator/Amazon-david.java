package comparator;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jsoup.nodes.Document;
import org.w3c.dom.Node;

public class Amazon implements Interface {
	private static final String ACCESS_KEY_ID = "AKIAJ2M7Z62GFWKITXBA";
	private static final String SECRET_KEY = "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";
	private static final String ENDPOINT = "webservices.amazon.es";
	
	@Override
	public void checkSource(String juego, GameComparator modelo) {
		String url=getSearchURL(juego);
        try{
            String url2=getURL(url);
            modelo.setUrlAmazon(url2);
            modelo.setPrecioAmazon(getPrice(url2));
            modelo.setUrlImagenAmazon(getImage(url2));
        }catch(Exception e){
            modelo.setPrecioAmazon("");
            modelo.setUrlAmazon("");
            modelo.setUrlImagenAmazon("");
        }
	}

	@Override
	public String getSearchURL(String query) {
		SignedRequestsHelper helper;

        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, ACCESS_KEY_ID, SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } 

        String requestUrl = null;

        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", "AKIAJ2M7Z62GFWKITXBA");
        params.put("AssociateTag", "ikor0b-21");
        params.put("SearchIndex", "All");
        params.put("ResponseGroup", "Images,ItemAttributes,Offers");
        params.put("Keywords", query);
              

        requestUrl = helper.sign(params);

       // System.out.println(" Signed URL: " + requestUrl);
                
        return SendHTTP(requestUrl);
	}

	
	public String getPrice(String requestUrl) {
		String price = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(requestUrl);
            
            Node priceNode = doc.getElementsByTagName("FormattedPrice").item(0);
            price = priceNode.getTextContent();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return price;
	}

	public String getImage(String requestUrl) {
		String image = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(requestUrl);
            
            Node imageNode = doc.getElementsByTagName("LargeImage").item(0);
            image = imageNode.getTextContent();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return image;
	}

	public String getURL(String requestUrl) {
		String url = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            org.w3c.dom.Document doc = db.parse(requestUrl);
            
            Node urlNode = doc.getElementsByTagName("DetailPageURL").item(0);
            url = urlNode.getTextContent();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return url;
	}
	
	
	private String SendHTTP( String url) {
		
	    HttpURLConnection connection;
	    BufferedReader response;
	    String res = "";
	    try {
				
		connection = (HttpURLConnection) new URL( url ).openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestMethod("GET");
				
		connection.connect();	
	        response = new BufferedReader(new InputStreamReader(connection.getInputStream()));		
	            res = ReadBuffer(response);


		} catch (MalformedURLException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
			}

		return res;
		}

	    
	private String ReadBuffer(BufferedReader buffer) {  /// Get all placed in a buffer and stores it inside String
			String read = "";
			String line = "";
			try {
				while((line = buffer.readLine()) != null) {
					read += line;
					//System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return read;
		}

	@Override
	public String getPrice(Document doc) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(Document doc) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getURL(Document doc) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
*/