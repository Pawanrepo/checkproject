import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestUrls {
    public static void main(String[] args) {
    	String destinationFile = "c:\\filegiventoPawanGupta\\spring-file-upload-eclipse-setup.jpg";
        URL url = null;
        try {
// url = new URL("http://g.live.com/xHlysk_sk/144");
            url = new URL("http://www.sothebys.com/content/dam/sothebys-pages/Catalogue%20Covers/2019/N10018-CV.jpg");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            int code = conn.getResponseCode();
            System.out.println("Response Code was " + code);
            InputStream is = conn.getInputStream();
            
            
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
            
            
            
            
            
            /* read data from input stream */
            is.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}