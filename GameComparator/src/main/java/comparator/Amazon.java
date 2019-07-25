/**
 * 
 */
package comparator;

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
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Amazon{
	
	private static final String ACCESS_KEY_ID = "AKIAJ2M7Z62GFWKITXBA";
	private static final String SECRET_KEY = "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";
	private static final String ENDPOINT = "webservices.amazon.es";
	
	public void checkSource(String juego, GameComparator modelo) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
        
        String urlRequest=getSearchURL(juego);
        Document doc = db.parse(urlRequest);
        
        Node priceNode = doc.getElementsByTagName("LowestNewPrice").item(0).getChildNodes().item(2);
        Node imageNode = doc.getElementsByTagName("LargeImage").item(0).getChildNodes().item(0);
        Node urlNode = doc.getElementsByTagName("DetailPageURL").item(0);

        String price = priceNode.getTextContent();
        String image = imageNode.getTextContent();  
        String url = urlNode.getTextContent();
        
       try{
           
            modelo.setPrecioAmazon(price);
            modelo.setUrlImagenAmazon(image);
            modelo.setUrlAmazon(url);

        }catch(Exception e){
            modelo.setPrecioAmazon("");
            modelo.setUrlAmazon("");
            modelo.setUrlImagenAmazon("");
        }
	}

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
        params.put("Keywords", query + " pc");
              

        requestUrl = helper.sign(params);

       // System.out.println(" Signed URL: " + requestUrl);
                
        return(requestUrl);
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

	
	

}
