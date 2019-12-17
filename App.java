import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
 
public class App {
 
    public static void main(String[] args) {
        String imageUrl = "http://www.sothebys.com/content/dam/stb/lots/N10/N10018/186N10018_XXXXX.jpg";
  //     String imageURL = "https://skinnerinc-res.cloudinary.com/images//v1532118683/1198188/detail.jpg";
        InputStream inputStream = null;
        OutputStream outputStream = null;
 
        try {
            URL url = new URL(imageUrl);
            inputStream = url.openStream();
            outputStream = new FileOutputStream("c:\\filegiventoPawanGupta\\spring-file-upload-eclipse-setup.jpg");
 
            byte[] buffer = new byte[2048];
            int length;
 
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
 
        } catch (MalformedURLException e) {
            System.out.println("MalformedURLException :- " + e.getMessage());
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException :- " + e.getMessage());
 
        } catch (IOException e) {
            System.out.println("IOException :- " + e.getMessage());
 
        } finally {
            try {
 
                inputStream.close();
                outputStream.close();
 
            } catch (IOException e) {
                System.out.println("Finally IOException :- " + e.getMessage());
            }
        }
    }
 
}