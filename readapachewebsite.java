import java.io.IOException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.ResponseException;
import com.jaunt.SearchException;
import com.jaunt.UserAgent;

public class readapachewebsite {

    public static void main(String[] args) throws IOException {
    	
    	
    	UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser)
    	try {
			userAgent.visit("http://www.sothebys.com/en/auctions/2018/finest-rarest-wines-n09950.html");
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}          //visit google
    	
    	     
    	String links = userAgent.getSource() ; //find search result links
    	/*for(Element link : links)
			try {
				System.out.println(link.getAt("class"));
			} catch (NotFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  */
    			
    			System.out.println(links);
    }
    }
