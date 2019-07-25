
package comparator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.StringBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.io.BufferedReader;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;




import comparator.SignedRequestsHelper;
import java.util.HashMap;
import java.util.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("serial")
@WebServlet(name="GameComparatorServlet",
			value = "/search") 
public class GameComparatorServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(GameComparatorServlet.class.getName());
	  
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String juego=req.getParameter("juego");
        log.info("Juego valor: " + juego);
  	  
        GameComparator modelo=new GameComparator();
        // hacer trim de juego?
        modelo.setJuego(juego);
        if(juego.length()>0 && juego.indexOf(" ")!=-1 && juego.indexOf(" ")!=0){
        	InstantGaming IG = new InstantGaming();
        	IG.checkSource(juego, modelo);
        	Kinguin KG = new Kinguin();
        	KG.checkSource(juego, modelo);
        	//Steam ST = new Steam();
        	//ST.checkSource(juego, modelo);
        	Amazon AM = new Amazon();
        	try {
				AM.checkSource(juego, modelo);
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SAXException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	// cambiar y poner de steam
            log.info("URL Steam: " + modelo.getUrlKinguin());
            log.info("IMG Steam: " + modelo.getUrlImagenKinguin());
            // si hay imagen para al menos 1 pagina entra en el if
            if(modelo.getUrlImagenKinguin() != null || 
               modelo.getUrlImagenIG() != null || 
               modelo.getUrlImagenAmazon() != null){
                //resp.getWriter().println(" hay imagenes");
                try{
                    req.setAttribute("juego", modelo);
                    RequestDispatcher rd = req.getRequestDispatcher("GameComparator.jsp");
                    rd.forward(req, resp);
                }catch(Exception e){
                    resp.sendRedirect("/error.html");
                }
            }else{
                resp.sendRedirect("/error.html");
            }
        }else{
            resp.sendRedirect("/badName.html");
        }	
    }
}
