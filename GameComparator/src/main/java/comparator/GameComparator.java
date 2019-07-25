package comparator;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="GameComparator")
@XmlType(propOrder={
		"juego",
		"precio" 
})
public class GameComparator implements Serializable {
    private String juego="";
    private String urlImagenIG="";
    private String urlImagenKinguin="";
    private String urlImagenAmazon="";
    private String urlIG="";
    private String urlKinguin="";
    private String urlAmazon="";
    private String precioIG="";
    private String precioKinguin="";
    private String precioAmazon="";

    public GameComparator() {
        this.juego=null;
        this.urlImagenIG=null;
        this.urlImagenKinguin=null;
        this.urlImagenAmazon=null;
        this.urlIG=null;
        this.urlKinguin=null;
        this.urlAmazon=null;
        this.precioIG=null;
        this.precioKinguin=null;
        this.precioAmazon=null;
    }
    
    public GameComparator(String juego, String urlImagenIG, 
            String urlImagenKinguin, String urlImagenAmazon, 
            String urlIG, String urlKinguin, String urlAmazon, 
            String precioIG, String precioKinguin, String precioAmazon) {
        this.juego=juego;
        this.urlImagenIG=urlImagenIG;
        this.urlImagenKinguin=urlImagenKinguin;
        this.urlImagenAmazon=urlImagenAmazon;
        this.urlIG=urlIG;
        this.urlKinguin=urlKinguin;
        this.urlAmazon=urlAmazon;
        this.precioIG=precioIG;
        this.precioKinguin=precioKinguin;
        this.precioAmazon=precioAmazon;
    }

    @XmlElement(required=true)
    public String getJuego() {
        return juego;
    }

    @XmlElement(required=true)
    public String getUrlImagenIG() {
        return urlImagenIG;
    }

    @XmlElement(required=true)
    public String getUrlImagenKinguin() {
        return urlImagenKinguin;
    }

    @XmlElement(required=true)
    public String getUrlImagenAmazon() {
        return urlImagenAmazon;
    }

    @XmlElement(required=true)
    public String getUrlIG() {
        return urlIG;
    }

    @XmlElement(required=true)
    public String getUrlKinguin() {
        return urlKinguin;
    }

    @XmlElement(required=true)
    public String getUrlAmazon() {
        return urlAmazon;
    }

    @XmlElement(required=true)
    public String getPrecioIG() {
        return precioIG;
    }

    @XmlElement(required=true)
    public String getPrecioKinguin() {
        return precioKinguin;
    }

    @XmlElement(required=true)
    public String getPrecioAmazon() {
        return precioAmazon;
    }

    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    
    public void setJuego(String juego) {
        this.juego = juego;
    }

    public void setUrlImagenIG(String urlImagenIG) {
        this.urlImagenIG = urlImagenIG;
    }

    public void setUrlImagenKinguin(String urlImagenKinguin) {
        this.urlImagenKinguin = urlImagenKinguin;
    }

    public void setUrlImagenAmazon(String urlImagenAmazon) {
        this.urlImagenAmazon = urlImagenAmazon;
    }

    public void setUrlIG(String urlIG) {
        this.urlIG = urlIG;
    }

    public void setUrlKinguin(String urlKinguin) {
        this.urlKinguin = urlKinguin;
    }

    public void setUrlAmazon(String urlAmazon) {
        this.urlAmazon = urlAmazon;
    }

    public void setPrecioIG(String precioIG) {
        this.precioIG = precioIG;
    }

    public void setPrecioKinguin(String precioKinguin) {
        this.precioKinguin = precioKinguin;
    }

    public void setPrecioAmazon(String precioAmazon) {
        this.precioAmazon = precioAmazon;
    }
    
}
