import java.io.FileOutputStream;
 import java.io.IOException;
 import java.io.InputStream;
 import java.io.OutputStream;
 import java.net.URL;

public class SaveImageFromUrl {

public static void main(String[] args) throws Exception {
    String imageUrl = "https://www.sothebys.com/content/dam/sothebys-pages/Catalogue%20Covers/2019/N10018-CV.jpg";
    String destinationFile = "c:\\filegiventoPawanGupta\\spring-file-upload-eclipse-setup.jpg";

    saveImage(imageUrl, destinationFile);
}

public static void saveImage(String imageUrl, String destinationFile) throws IOException {
    URL url = new URL(imageUrl);
    InputStream is = url.openStream();
    OutputStream os = new FileOutputStream(destinationFile);

    byte[] b = new byte[2048];
    int length;

    while ((length = is.read(b)) != -1) {
        os.write(b, 0, length);
    }

    is.close();
    os.close();
}

}