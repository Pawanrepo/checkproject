

import java.io.InputStream;
import java.net.URL;
import java.net.UnknownHostException;

public class readingurl {
	public static void main(String args[]) throws Exception {
	String content  = "";
	URL url = new URL("http://m.sothebys.com/en");
    try {
    	System.out.println("theURL is"+url);
    	InputStream urlStream = url.openStream();
     //   InputStream urlStream = url.openStream();
        byte b[] = new byte[1000];
        int numRead = urlStream.read(b);
        content = new String(b, 0, numRead);
        System.out.println("contentindia"+content);
        while (numRead != -1) {
            //if (Thread.currentThread() != searchThread)
            //	break;
            numRead = urlStream.read(b);
            if (numRead != -1) {
                String newContent = new String(b, 0, numRead, "UTF-8");
                content += newContent;
                System.out.println("content"+content);
            }
        }
        urlStream.close();
    } catch (UnknownHostException uhe) {

        throw uhe;

    } catch (Exception e) {

        System.out.println("ERROR: couldn't open URL " + url);
        throw e;
    }

}
}
