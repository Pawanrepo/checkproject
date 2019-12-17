import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class imageio
{
	public static void main(String args[])
	{
		URL urlInput;
		File folderInput = new File("C://pawan/186N10018_XXXXX.jpg");
//	urlInput = new URL("http://www.sothebys.com/content/dam/sothebys-pages/Catalogue%20Covers/2019/N10018-CV.jpg");

      try {
		BufferedImage urlImage = ImageIO.read(folderInput);
		File outputfile = new File("c:\\filegiventoPawanGupta\\spring-file-upload-eclipse-setup.jpg");
		ImageIO.write(urlImage, "jpg", outputfile);
} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	}
}