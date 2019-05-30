
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class Main {
	
	/*Este método se emplea para printear la información correspondiente a cada item del archivo*/
	public static void PrintInfo(Element e){
		System.out.println("Title: " + e.getElementsByTagName("title").item(0).getTextContent());
    	System.out.println("Link: " + e.getElementsByTagName("link").item(0).getTextContent());
    	System.out.println("Description: " + e.getElementsByTagName("description").item(0).getTextContent());
    	System.out.println("Enclosure: " + e.getElementsByTagName("enclosure").item(0).getTextContent());
    	System.out.println("Guid: " + e.getElementsByTagName("guid").item(0).getTextContent());
    	System.out.println("PubDate: " + e.getElementsByTagName("pubDate").item(0).getTextContent());
    	System.out.println("Source: " + e.getElementsByTagName("source").item(0).getTextContent());
	}

	public static void main(String[] args) {
		
		try{
			/* Abrimos el archivo desde la URL propocionada y se procede a parsearlo */
			URL xmlURL = new URL("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss");
			InputStream xml = xmlURL.openStream();
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xml);
	        
			doc.getDocumentElement().normalize();
	        
			/*Creamos una lista de Items formada por el total de Items que hay en el archivo, es decir, 60 items*/	        
	        NodeList ListaItems = doc.getElementsByTagName("item");
	        
	        /*Bucle para recorrer la lista de items almaccenados e ir mostrando su función*/
	        for (int i = 0; i < ListaItems.getLength(); i++) {
	        	
	        	Node nodo = ListaItems.item(i);
	        	
	        	System.out.println("Item "+i+": ");
	        	
	        	Element element = (Element) nodo;
	        	
	        	PrintInfo(element);
	        	
			}
	        
	        
	
		} catch (Exception e) {
            e.printStackTrace();
        }
		
		

	}
	

}
