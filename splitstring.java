import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class splitstring {
	
	public static void main(String args[])
	{
	//	String str = "ADD ME:DMID%SNID%MEID%MENAME%METYPE%TEMP%MEVER%MEVER%MEVD,^ADD ME:DMID=[0-9]*[^\\s]SNID=[0-9]*[^\\s]MEID=[0-9]*[^\\s]MENAME=[^\\s]*METYPE=[^\\s]*";
	String str = ", 1930s. Vintage gelatin silver print, 7 3/8 x 9 3/8 inches (190 x 240 mm), dry-mounted to thin card, with Abbott's 56 West 53rd Street stamp on mount verso, with a stamped guardsheet. Some soiling to the mount, which is somewhat friable. Minor silvering, printed toned towards sepia, a few ferrotyping artefacts, in all an attractive example. ";
	String str1 ="Lot 9; ABBOTT, BERENICE (1898-1991) [Trinity Churchyard]; , 1930s. Vintage gelatin silver print, 7 3/8 x 9 3/8 inches (190 x 240 mm), dry-mounted to thin card, with Abbott's 56 West 53rd Street stamp on mount verso, with a stamped guardsheet. Some soiling to the mount, which is somewhat friable. Minor silvering, printed toned towards sepia, a few ferrotyping artefacts, in all an attractive example. ; ; ;   ;";
	String str2 ="Lot 10; ABBOTT, BERENICE (1898-1991) [Barclay Street Station, New York]; , [1930]. Vintage gelatin silver print, 7 3/8 x 9 3/8 inches (190 x 240 mm), with Abbott's 56 West 53rd Street stamp on mount verso. Apparently once mounted before Abbott stamped it; dry mount adhesive residue on verso. Minor silvering, in all a very attractive image attractive example. ; ; ;   ;";
	String str3 = " , [1930]. Vintage gelatin silver print, 7 3/8 x 9 3/8 inches (190 x 240 mm), with Abbott's 56 West 53rd Street stamp on mount verso. Apparently once mounted before Abbott stamped it; dry mount adhesive residue on verso. Minor silvering, in all a very attractive image attractive example.";
	String nameind = "[SIGNED PHOTOBOOKS] ";
	String str4 = nameind.replace("[SIGNED PHOTOBOOKS] ", "").trim();
	String str5 = "with Abbott's 56 West 53rd Street stamp on mount verso, with a stamped guardsheet. Some soiling to the mount, which is somewhat friable. Minor silvering, printed toned towards sepia, a few ferrotyping artefacts, in all an attractive example"; 
	String str7 ="Some soiling to the mount which is somewhat friable Minor silvering printed toned towards sepia a few ferrotyping artefacts in all an attractive example";
	String str910 ="2019/03/08 Charity auction (77 items) - Dorotheum";
	String str9100 = str910.substring(str910.indexOf("(") +1 );
	String checktest = " AEG, Berlin";
	String jiotest = "Provenance:Galerie Fahnemann, BerlinPrivate Collection, Germany";
	String[] splitjiotest = jiotest.split("Provenance:");
	System.out.println("**********************************************88888888888888888888888888888888"+splitjiotest[1]);
//String patternString = "\\.\\"(checktest)
	
	String pawantest = "Description: D. 26.5 cm. Made by AEG, Berlin, 1910/20s. Sheet brass, dark brown patina, sheet metal, painted black, clear glass, cr&egrave;me-white dial face, black and red numerals, black hands. Marked: AEG Synchron; maker's plaque.";
	
	Pattern l_pattern_dimension3412  =   Pattern.compile("[^\\.;]+(Made by)[^\\.;]+");
	//Pattern l_pattern_dimension3412  =   Pattern.compile("\\.(.*)(newstring)\\s+\\.");
	    Matcher l_matcher_dimension3412  =   l_pattern_dimension3412.matcher(pawantest);
	    if(l_matcher_dimension3412.find())
	    	System.out.println("String Matched");
	  else
	  		System.out.println("&&&&&&&&&&&&&&&&&&&&&notmatchedpppp");
	    System.out.println("9999999999999999999LLLL99999999999999LLLLLLLLLLLpppppppppp"+l_matcher_dimension3412.group(0));
	String[] splitdimension = pawantest.split(l_matcher_dimension3412.group(0));
	String restdim =splitdimension[1].replaceFirst(".","").trim();
	System.out.println("nnnnnnnnnnnnnnnnnnnn"+ restdim);
	String starstr ="3401* -                     A187 PostWar &amp; Contemporary -                                             Saturday, 08. December 2018,                        02.00 PM                                    ";
	String[] starstrarr = starstr.split("\\*");
	System.out.println("starttttttttttttttttttttttttttttttttttt"+starstrarr[0]);
	
	
	if(restdim.contains("Marked"))
	{
		String[] splitMarked = restdim.split("Marked");
				String tempMaterial = splitMarked[0].trim();
				System.out.println("OOOOOOOOOOOOOOOOOOOOOOOOOOO"+tempMaterial);
				String tempCondition = splitMarked[1].trim();
				System.out.println("KKKKKKKKKKKKKKKKKKKKKKKMarked"+tempCondition);;
	}
	    String[] splitstr = pawantest.split(l_matcher_dimension3412.group(0));
	String[] splitstrind = splitstr[1].split(".");
	//System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLL"+ splitstrind[1].replace(".", "").trim());
	String pawantestind = "Description: H. 19 cm, D. 36 cm. Nickel-plated sheet brass, white glass.";
	
	Pattern l_pattern_dimension34123  =   Pattern.compile("(cm.)(.*)");
	 Matcher l_matcher_dimension34123  =   l_pattern_dimension34123.matcher(pawantestind);
	 if(l_matcher_dimension34123.find())
	 {
	    	System.out.println("String Matched******************************************777777777");
	    	String[] splitdescri = pawantestind.split("cm\\.");
	    	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&ppppp"+ splitdescri[1].trim());
	    		
	 }

	 String teststring123 = "~ CHRISTIAN ROECKENSCHUSS~  (Dresden 1929 - 2011 Berlin) <div> 19b (K355). 1958. <div> Acrylic and lacquer on masonite. <div> Titled, dated and with measurements on a label on the reverse: Bild 19b 60/60 30./31.8. - 1./3.9.58. <div> 61 x 61 cm. <div> <br />Provenance: Estate Christian Roeckenschuss. <br /> <br />Literature: K&ouml;ppe Contemporary: Christian Roeckenschuss. Avantgardist des Minimalismus. Das Werk I. 1948 - 1970, Berlin 2018, p. 89. <div> <br /> ~ <div> <div> <div> <div class=detail-lot-schaetzung>  CHF 1 500 / 2 500 ~  � 1 320 / 2 190 ~   Sold for CHF 1 875 (including buyer's premium) <br /> All information is subject to change. ~";
	 teststring123 = teststring123.replaceAll("~\\s+\\(", "<div>(");
	 
	 System.out.println("replacestring888888888888888888888"+teststring123);
	 
	 String testarray = "Hello Pawan";
	 if(testarray.split(",").length >1)
	 {
	 String test12 = testarray.split(",")[1];
	 
	 System.out.println("&&&&&&&&&&&&&&&&&&&6666666666666"+test12);
	}
	 
	 String testname = " <br />Provenance: Estate Christian Roeckenschuss. <br /> <br />Literature: K&ouml;ppe Contemporary: Christian Roeckenschuss. Avantgardist des Minimalismus. Das Werk I. 1948 - 1970 Berlin 2018 p. 89. ";
	 if((testname.toLowerCase().contains("provenance:")
             || testname.toLowerCase().contains("provenienz:")
             || testname.toLowerCase().contains("proveniance:")) )
			 {
		 Pattern l_p = Pattern.compile("(.*)((Provenance:|Provenienz:|Proveniance:)(.*))");                               
         Matcher l_m    =   l_p.matcher(testname);
         if(l_m.find()){
        	 if(l_m.group(0).contains("<br />Literature:"))
        			 {
        		 String l_provenance = l_m.group(0).split("<br />Literature:")[0];
        		 String l_literature =  l_m.group(0).split("<br />Literature:")[1];
        		 System.out.println("provenance&&&&"+ l_provenance.replace("Provenance:", "").replaceAll("<br />", "").trim());
        			System.out.println("Liteature********"+l_literature);
        			 
        			 }
        	 else
        	 {
             System.out.println("**********&&&&&&&&^^^^^^^^^^^"+l_m.group(0));
        	 }
         }  
         else 
         {
        	 System.out.println("JKJKJKJKJKJKJKJKKJKJKJKJKJ");
         }
			 }
	 
	 
	 
	 String lotstring = "Lot 3411 - A187 PostWar & Contemporary - Saturday 08 December 2018, 02.00 PM";
	 Pattern l_pattern_lotstring  =   Pattern.compile("(Lot)(\\s)\\d{4}");
	 Matcher matcherlotstring = l_pattern_lotstring.matcher(lotstring);
		if (matcherlotstring.find())
		{
		    System.out.println("KKKKKKKKKKKKKKKKKKKKKJJJJJJJJJJJJJJJJJJJJJJJ"+matcherlotstring.group(0));
		    String[] tempstringarr = lotstring.split(matcherlotstring.group(0));
		    String truncString = tempstringarr[1];
		    System.out.println("KKKKKKKKKKKKKKKKKKKKKJJJJJJJJJJJJJJJJJJJJJJJ"+truncString);
		}
		
		else
		{
			System.out.println("**********************notmatched");
		}
	 
	 
	 
	String dimtext =  " 100 x 57 x 107 cm";
	if(dimtext.contains("cm"))
	{
		System.out.println("HELLLLLLLLLLLLLLLLLLIIIIIIIIIIIII");
	}
	else 
	{
		System.out.println("KKKKKKKKKKKKFFFFFFFFFFFFFFFFFFF");
	}
	
	if(pawantest.contains(checktest)) {
	//	pawantest = pawantest.replace(checktest, "newstring");
	
	//if(pawantest.matches("\\.(.*)(newstring)(.*)\\."))
	//{
	//
	Pattern l_pattern_dimension341  =   Pattern.compile("[^\\.;]+(" + checktest +")[^\\.;]+");
//Pattern l_pattern_dimension341  =   Pattern.compile("\\.(.*)(newstring)\\s+\\.");
    Matcher l_matcher_dimension341  =   l_pattern_dimension341.matcher(pawantest);
    if(l_matcher_dimension341.find())
    	System.out.println("String Matched");
  else
  		System.out.println("&&&&&&&&&&&&&&&&&&&&&notmatched");
    System.out.println("9999999999999999999LLLL99999999999999LLLLLLLLLLL"+l_matcher_dimension341.group(0));
    System.out.println("9999999999999999999LLLL99999999999999LLLLLLLLLLL"+l_matcher_dimension341.group(0).replace(".", "").trim());
	
}
	
	
	
	
	//String[] pawantestarrtemp = pawantest.split("\\.(.*)(newstring\"(.*)\\.\",3);
	//System.out.println("999999999999999999999999999999999888888888"+ pawantestarrtemp[1].trim());
	String[] pawantestarr = pawantest.split(" ");
	if(pawantestarr.length<2)
	System.out.println(pawantestarr[2]);
	else 
		System.out.println("***********&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&pass");
	
//	Pattern pattern = Pattern.compile(patternString);
    
 //  String pattern2 = pattern.pattern();
	
	
//	String str91000 = strtempfinal.substring(strtempfinal.indexOf("\\d+\\..*cm$") +1 );
	//System.out.println("(((((((((((((("+str91000);
	
//	System.out.println("*******kkkkkk&&&&&"+(strtempfinal.substring(0, strtempfinal.indexOf("\\d+\\..*cm$"))).trim());
	//System.out.println("******************&&&&&&"+strtempfinal.substring(3, strtempfinal.lastIndexOf(" ")).trim());
//	System.out.println("%%%%%%%%%%%%%%%%%%%%%kkkkkkkkkkkkkkkkkkkkkkkkkkkk"+ (strtempfinal.substring(strtempfinal.lastIndexOf(" x ") + 1)).trim());

	
	String mydata = "some string with 2.4 x 3.4 cm";
	Pattern pattern123 = Pattern.compile("\\d(.*?)cm");
	Matcher matcher123 = pattern123.matcher(mydata);
	if (matcher123.find())
	{
	    System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLL99999999999999LLLLLLLLLLL"+matcher123.group(0));
	}
	
	String pawangtemp = "hello, pawan";
	System.out.println("pawankkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"+ pawangtemp.replaceAll(",", ""));
	
	String divlength = " Daguerreotype. Circa 1845. ";
	 if (divlength.trim().charAt(divlength.trim().length() - 1) == '.') {
		 divlength = divlength.substring(0, divlength.trim().length());
		 System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+divlength.trim());
		 String[] l_token_material_arr = divlength.trim().split("\\.");
		 System.out.println("&&&&&&&&&&&&&&&&&************88888888888888"+l_token_material_arr[0]);
     }
	 else
	 {
		 System.out.println("NOTNOTNOTNOTNOT^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	 }
	String devcm = " <div> (1851-1911). <div> Nomad in the desert. <div> Tinted gelatin silver print. Vintage. Circa 1900. <div> 23 x 58.5 cm";
	
	 Pattern l_pattern_dimension1  =   Pattern.compile(".*[<div>](.*?cm[\\,]*.*?).*");
     Matcher l_matcher_dimension1  =   l_pattern_dimension1.matcher(devcm);
     if(l_matcher_dimension1.find()){
        String l_dim_text=l_matcher_dimension1.group(1);
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&kkkkkkkkkkkkkkkkkkkkkkk&&&&&&&&&&&&&"+l_dim_text);
	
     }
	String temppawankaushik = "(1928).";
	 Pattern l_pattern_dimension3  =   Pattern.compile(".*(\\()\\d{4}(\\)).*");
     Matcher l_matcher_dimension3  =   l_pattern_dimension3.matcher(temppawankaushik);
     if(l_matcher_dimension3.find()){
    	 System.out.println("temppawankaushikkkkkkkkkkkk9999999999"+temppawankaushik.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("\\.", ""));
     }
     String temppawan ="(Lausanne 1865 - 2019 Paris)";
     Pattern l_pattern_dimension2  =   Pattern.compile(".*\\s\\d+\\s(-)\\s\\d+.*");
     Matcher l_matcher_dimension2  =   l_pattern_dimension2.matcher(temppawan);
     if(l_matcher_dimension2.find()){
    	 String[] splitbar_arr = temppawan.split(" - ");
    	 String birthyear = splitbar_arr[0].split(" ")[1];
    	 System.out.println("helloindia"+splitbar_arr[1].split(" ")[0]);
    	 if(splitbar_arr[1].split(" ")[0].matches("\\d+"))
    	 {
    	 String deathyear = splitbar_arr[1].split(" ")[0];
    	 System.out.println("birthyear"+birthyear);
    	 System.out.println("deathyear"+deathyear);
    	 }
    	 System.out.println("helooooooooooooooooooooooooooookkkkkk");
     }
     else
    	 System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
     
     
	String temppawanfullstop = " ";
	if(!temppawanfullstop.isEmpty() && !temppawanfullstop.equals(" "))
	{
	 if (temppawanfullstop.trim().charAt(temppawanfullstop.trim().length() - 1) == '.') {
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLKKKKKKKKKKKKKKKKLLLLLLLLLLL");
     }
	}
	String temppawan123 = "Varying image sizes on wove paper 12 x 165.6 cm";
	Pattern testpattern = Pattern.compile("\\s+\\d+(.*)\\s+(x)\\s+\\d+(.*)(cm)");
	Matcher tempmatch = testpattern.matcher(temppawan123);
			if(tempmatch.find()){
				System.out.println(tempmatch.group(0).trim().replace("cm", ""));
				System.out.println(temppawan123.substring(tempmatch.start(), tempmatch.end()).replace("cm", "").trim());
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Matchstring");
			}
			else 
			{
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^NotMatchstring");
			}
	String divtemp = "<div> (1803-1863) <div> Val閞ie & Emilie Meyer-Birchen b. 28/4 1841 2/10 1842 in Basel. Portrait of two young girls. <div> Daguerreotype. Circa 1845. <div> Sixth of plate; octagonal section ca. 6.8 x 5.8 cm. <div> Verso mounted lithographed photographer's label with handwritten annotation. <div> Ernst war urspr黱glich Mechaniker und Ingenieur, der sich die Technik der Daguerreotypie bereits fr黨 aneignete. Als Wanderphotograph besuchte er verschiedene Orte in der Schweiz und war ab 1844 in Basel t鋞ig. <div> ";
String divtemprep = divtemp.replaceAll("\"", "\"");
	String[] divtemp_arr = divtemprep.split("<div>");
System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ"+divtemp_arr[0]);
	String strtempfinal = " <div> (1803-1863) <div> &quot;Val&eacute;rie & Emilie Meyer-Birchen b. 28/4 1841 2/10 1842 in Basel&quot;. Portrait of two young girls. <div> Daguerreotype. Circa 1845. <div> Sixth of plate; octagonal section ca. 6.8 x 5.8 cm";
	Pattern heading12 = Pattern.compile("(ca.|Albums)\\s\\d+(.*?)\\s(x)(.*?)cm");
    Matcher matcher12 = heading12.matcher(strtempfinal);
    if (matcher12.find()) {
    	System.out.println("insideiiiiiiiiiiiiiiiiiii");
    	String title123 = matcher12.group(0);
    	title123 = title123.replace("ca.", "").replaceAll("Albums", "");
   	 System.out.println("***********************Patttttttttttthhhhhhhhhhhhhhhhtttttttt"+title123.trim());
    
   	 
   	
   	 
   	 
   	 
    	String truncString = strtempfinal.substring(matcher12.start(), matcher12.end());
    	System.out.println("ture**************************"+ truncString);
   	String title = matcher12.group(0);
   	 System.out.println("***********************Patttttttttttttttttttt"+title);
    }
    else
    {
   	 System.out.println("&&&&&&&&&&&&&&&&&&&&&KKKKKKKKKKKKKKKKKK");
    }
    
    
    
    String testpawankaushik = "hello,kaushik,india,pawan";
    String[] splittestpawankaushik = testpawankaushik.split(",");
    if(splittestpawankaushik.length > 4)
    {
    	System.out.println(splittestpawankaushik[3]);
    	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&helloindia");
    }
    else
    {
    	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&elseindia");
    }
    
    
    String firststring ="signed ,dated ,  titled and numbered on the reverse ,edition label on the reverse";
    String secondstring = "edition label on the reverse";
    if(!firststring.contains(secondstring.trim()))
    {
    	System.out.println("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
    }
  /*  else {
    	System.out.println("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN");
    } */
    
    String titledoro ="";
    String titledoro1 ="";
    String stringdoro = "T1976-E5, 1976, signed and dated Hartung 76; inscribed on the reverse: fait le 16𤾉6 Hartung and with the archive number T1976-E5, acrylic on canvas, 73 x 100 cm, framed";
	//stringdoro = stringdoro.replace("/", "t^");
   /*	Pattern headingdomo = Pattern.compile("\\d{4}(/)\\d{4}");
    Matcher matchdoro = headingdomo.matcher(stringdoro);
    if (matchdoro.find()) {
    	System.out.println("insidepppppppppppppppppppppp");
    	titledoro = matchdoro.group(0);
    	System.out.println(titledoro);
    }
    else {
   	 System.out.println("***********************Pattsssssssssssssssssssssssssssssss"+titledoro.trim());
   	 
    } */
    Pattern headingdomo1 = Pattern.compile("\\d{4}");
    Matcher matchdoro1 = headingdomo1.matcher(stringdoro);
    if (matchdoro1.find()) {
    	System.out.println("insidepppppppppppppppppppppp");
    	titledoro1 = matchdoro1.group(0);
    	System.out.println(titledoro1);
    }
    else {
   	 System.out.println("***********************Pattsssssssssssssssssssssssssssssss"+titledoro.trim());
   	 
    }
    
    
    String stringdorotemp = "(born in Dessau in 1940)Revolver I Ed., 2002/2008, signed, dated, titled and numbered on the reverse, collage, acrylic on plastic film collage, no. 2 from the edition of 5 unique pieces, edition label on the reverse, 46.5 x 62.5 cm, framed  Provenance:Galerie Fahnemann, BerlinPrivate Collection, Germany";
	if(stringdorotemp.matches("(.*)\\d{4}(/)\\d{4}(.*)"))
	{
			System.out.println("MatchesINDIA%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
	}
	else
	{
		System.out.println("NOTMATCHES+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
	}
    
	
    
    
    
	
    String testnav = "Hello pawan";
    String[] stringArray = testnav.split(" ");
	int numberofblankspace = stringArray.length;
	System.out.println("HelloModi********************************"+numberofblankspace);
	
	
	
	if(numberofblankspace ==2)
	{
		System.out.println("*****************Hellofriend");
		String FirstName = testnav.substring(0, testnav.lastIndexOf(" ")).trim();
		String LastName	= testnav.substring(testnav.lastIndexOf(" ")).trim();
		System.out.println("firstname******************************"+ FirstName);
		System.out.println("firstname******************************"+ LastName);
		
		
	}
	else
	{
		System.out.println("**************************HelloNotFriend");
	}
	
	String abctemp = "Object description~ A mahogany Josef Frank cabinet, Svenskt Tenn, model B 2217, three shelves, height 162, length 85.5, depth 35 cm";
	String testtt1234567 = "2217";
	if(abctemp.matches("(.*)(height)(\\s+)\\d+(.*)"))
	{

	Pattern l_pattern_dimension34  =   Pattern.compile("(height)(\\s+)\\d+");
    Matcher l_matcher_dimension34  =   l_pattern_dimension34.matcher(abctemp);
    if(l_matcher_dimension34.find())
    	System.out.println("String Matched");
    
  //  System.out.println("9999999999999999999LLLL99999999999999LLLLLLLLLLL"+l_matcher_dimension34.group(0));
   String[] l_dimension_local = l_matcher_dimension34.group(0).split(" ");
   System.out.println(l_dimension_local[1]);
	}
else 
	System.out.println("HelloPawanKaushikindianotinindia77777777777777**********88888888888888888888");
	if(abctemp.contains(testtt1234567))
		System.out.println("hellocontain&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
	String[] mainString = abctemp.split(testtt1234567);
	System.out.println("today9999999999999999999999999"+mainString[1]);
	String temp_description = null;
	if(temp_description == null && mainString[1].contains("height"))
	{
		String[] descriptionStr = mainString[1].split("height");
		System.out.println("Helloheight&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+ descriptionStr[0].replace(",","").trim());
	}
	String strin8888 = "pawan14x8,21 cm";
	String tempstr = "A pair of Bj鰎n Tr鋑錼dh easy chairs, Firma Svenskt Tenn 1930磗, height 74 cm";
	if(tempstr.matches("(.*)\\d{4}(磗)(.*)"))
	{
			System.out.println("MatchesINDIA%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+tempstr.substring(0, tempstr.lastIndexOf("磗")).trim()+"磗");
	}
	else
	{
		System.out.println("NOTMATCHES+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	String str98989 = "ohne Titel 2018";
	if (str98989.matches("[A-Za-z](.*)\\d{4}")) {
		System.out.println("KKKKKKKLLLLKKK");
	}
	else
	{
		System.out.println("HELLLLLLLLLLLLLLLLLLL");
	}
	System.out.println("******************&&&&&&"+str98989.substring(0, str98989.lastIndexOf(' ')).trim());
	System.out.println("%%%%%%%%%%%%%%%%%%%%%"+ (str98989.substring(str98989.lastIndexOf(' ') + 1)).trim());
	String patternStrpk1 = ".*\\d,\\d{2}.*";
	Pattern patternpk1 = Pattern.compile(patternStrpk1);
	Matcher matcherpk1 = patternpk1.matcher(strin8888);
	if(matcherpk1.find()){
		String str999999 = strin8888.replaceAll("(.*)(\\d+)(,)(\\d+)(.*)","$1$2.$4$5");
		
		System.out.println("HelloOOOOOOOOOOOOOOOOOO"+str999999);
			}
	else{
		System.out.println("UUUUUKKKIND");
	}
	
	
	
	System.out.println("*************"+str9100);
	String[] splitString = str9100.split(" ");
	System.out.println(splitString[0]);
	
	String str99991 = "Andje pawan, S. Freud,2012 100x70 cm, Mischtechnik auf Papier www.art-andje.at";
	
	String str99992 = "Andje pawan, S. Freud,2012 Mischtechnik auf Papier www.art-andje.at , 100x70 cm";
	String[] finalstr99992 = str99992.split(",");
	
	String[] finalstr9999 = str99991.split(",");
			System.out.println(finalstr9999[0].trim());
			String artistName = finalstr9999[0].trim();
			String[] splitartistName = artistName.split(" ");
			if(splitartistName.length >1)
			{
				System.out.println("firstname"+ splitartistName[0]);
				System.out.println("lastname"+ splitartistName[1]);
				
			}
			else 
			{
				System.out.println("Size is zero");
				System.out.println("firstname"+ splitartistName[0]);
				
			}
	System.out.println(finalstr9999[1].trim());
//	System.out.println(finalstr9999[2].trim());
	String splitstring = finalstr9999[2].trim();
	String splitstring2 = finalstr99992[2].trim();
	
	
	if (splitstring2.matches(".*\\d{4}\\s[A-Z].*")) {
		
			
			String[] splitdim = splitstring2.split(" ");
		System.out.println("*******&&&&&"+(splitstring2.substring(0, splitstring2.indexOf(' '))).trim());
		System.out.println("&&&&&*****"+(splitstring2.substring(splitstring2.indexOf(' ') + 1)).trim());
		
		
		}
		else{
			System.out.println("helloindikaltakKKKKKKKKKKKKKKKKKKKKKKK^^^^^^^^^^^^^^^^^");
		}
	
	
	
	
	
	
	System.out.println("**************OOOOO"+splitstring);
	if (splitstring.matches(".*\\d{4}\\s\\d+x.*")) {
	if(splitstring.contains("cm"))
	{
		
		String[] splitdim = splitstring.split(" ");
	System.out.println(splitdim[0].trim());
	System.out.println(splitdim[1].trim());
	
	}
	}
	else{
		System.out.println("helloindikaltak^^^^^^^^^^^^^^^^^");
	}
	
String stri10 = "preSaleLot':true,'condRep':'/en/auctions/ecatalogue/2019/burgundy-and-more-cellar-of-marcus-d-hiles-n10018/lot.101.html#conditionsOfSaleModal";
	String[] stri11 = stri10.split(",");
	String str9999 = "Auction Date: 08.03.2019, 19:00 Location: Galerie/Studio Elena Mildner, Burggasse 21, 1070 Wien";
	
	Pattern heading = Pattern.compile("(.*)(Auction Date:)[\\s](.*)(Location:)(.*)");
     Matcher matcheri = heading.matcher(str9999);
     if (matcheri.matches()) {
    	String title = matcheri.group(4);
    	 System.out.println("***********************Patttttttttttttttttttt"+title);
     }
     else
     {
    	 System.out.println("&&&&&&&&&&&&&&&&&&&&&KKKKKKKKKKKKKKKKKK");
     }
     
     
	
	
	
	
	System.out.println("IIIIIIIIIIIIIIIII"+stri11[1]);
	String str18 = "2008 lots found";
String str88 ="�2,640";
String str67 = "(k2*80)/100";
String str991 = "Konvex gew&ouml;lbte Wandplatte. ";
System.out.println("hello"+str991);
System.out.println("pawankaushikindiaaaa"+ str991.replace("&Ouml;", "O"));
String l_nextLine = "Initial閑 et dat閑 au crayon \"S.F. 18\" dans la marge inf閞ieure � droite et num閞ot閑 \"51/350\" dans la marge inf閞ieure � gauche / Initialled and dated in pencil \"S.F. 18\" in the lower right margin and numbered \"51/350\" in the lower left margin";

String UnknownLanguage = null;
String EnglishLanguage = null;
String paw = null;
String qui ="Description: Watercolor on firm, chamois-colored paper. 5.6 x 8.9 cm. Verso inscribed: Heinrich von Sybel (brown ink), other illegible signs. On the back of the cardboard inscribed (pencil, technical data) and stamp of the art dealer Wilfried K&auml;fer, Marburg.";
//String pawan = qui.substring(0, qui.indexOf("\n"));
//System.out.println("Pawankaushkindddd"+pawan);
//paw = qui.substring(qui.indexOf("\n") + 1);
//System.out.println("pawankaushikindkkkkk"+paw);

String finalstr = "Not deframed.Chapter:<br /> Art &amp; Antiques ;Fields of collection:<br /> Art, Watercolour";
//String[] strfinal = paw.split(".");
//String strfinal = paw.substring(0, paw.indexOf("."));
//System.out.println("stringfinal"+strfinal);
String splitdim = "pawankaushik working in idia.hello";
System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPPP"+ splitdim.substring(0, splitdim.indexOf(".")));
if(!(splitdim.substring(splitdim.indexOf(".") +1 )).equals(""))
{
	System.out.println("OOOOOOOOOOOOOOOO"+splitdim.substring(splitdim.indexOf(".") +1 ));
	System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLLPPPPPPPPPPP");
}/*String[] splitdimin = splitdim.split(".");
System.out.println("HELLLLLLLLLLLLLLLLLLLLLLLLLLLL"+ splitdimin[0]);

	if(!splitdimin[1].equals(null))
	{
		System.out.println("HEEEEEEEEEEEEEEEEEEE"+ splitdimin[1]);
	} */
String[] pawa = qui.split("cm.");
System.out.println("PawanKaushikindiiiii"+pawa[1].trim());
if(l_nextLine.contains("Initialled"))
{
	   UnknownLanguage = l_nextLine.replace("-", "").substring(0, l_nextLine.replace("-", "").indexOf(" Initialled"));
	    EnglishLanguage = l_nextLine.replace("-", "").substring(l_nextLine.replace("-", "").indexOf(" Initialled") + 1);
	   
}
System.out.println("9999999"+EnglishLanguage);
String name1 ="Pierre Alechinsky et Jean-Michel Reynard";
String nickname = name1.substring(0, name1.indexOf(' '));
String content = name1.substring(name1.indexOf(' ') + 1);
System.out.println("NNNNNNN"+nickname);
System.out.println("CCCCCCC"+content);
String pawankaushik = " Lithograph on Japan (Gampi Toriknoko paper). 76.2 x 51.1 cm";
String[] splitstringpk = pawankaushik.split("\\d+\\..*cm$");
System.out.println("PPPPPPPPPPPPPKKKKKKKKKKKKOOOOOOOOO"+ splitstringpk[0]);

System.out.println("PKPKPKPKPKPK"+pawankaushik.replaceAll(splitstringpk[0], ""));
System.out.println("PPPPPPPPPPPPPKKKKKKKKKKKKOOOOOOOOO"+ splitstringpk.length);
for(String word: splitstringpk){
    System.out.println("***************"+word);
}
String patternStrpk = ".*\\d.*cm$";
Pattern patternpk = Pattern.compile(patternStrpk);
Matcher matcherpk = patternpk.matcher(pawankaushik);
if(matcherpk.find()){
	System.out.println("UUUUUUUUUUUUUUUUU"+matcherpk.group(0));
	
//System.out.println("OOOOOOOOOOOOOOOO"+matcher.start());//this will give you index
//int comma = matcher.start();
//String str11 = str10.substring(comma+1).trim();
System.out.println("PPPPPPPPPPPPPPPPKKKKKKKKKKKKKKKfound");

}
else
{
	System.out.println("OOOOOOOOOOOOOOOOOnotfound");
}







String l_tempData = "24,7 x 31,3 cm";
String[] z=l_tempData.split("(\\.)",2);
System.out.println("IIIIIIIIIIIIIIIIIIIII"+z.length);
if(z.length>0)
{
	System.out.println("EXist*****************");
}


if(str67.contains("80)/100"))
		{
	System.out.println("matchestehrecord");
		}
else {
	System.out.println("desnotmachrecord");
}
String Str111 ="1667 pawan";
String material = "Gelbgold, rhodiniert, Gesamtgewicht: 3,5g. EU-RM: 54. 1 Altschliff-Diamant, D.ca. 6,6-7,1mm.";
System.out.println("helloinde"+material.substring(material.indexOf("Gesamtgewicht:")));
System.out.println("helloindestartend"+material.substring(0,material.indexOf("Gesamtgewicht:")));
String dimension =null;
if(dimension != null )
{
	System.out.println("Empty************");
}
else
{
	System.out.println("NotEmpty************");
}

String str888 = "pawan kaushik india - pawan";
String artworkTitle = "pawan";
String removeString = "- "+artworkTitle;
str888 = str888.replace(removeString, "-");
System.out.println("removingstring************"+str888);
System.out.println("*************************************"+removeString);
String str112 = "pawa";



String descriptio = ", Di-faced &pound; 10 note a Barely legal, ,  ,6x14,3 cm, gr. 1,34. Bibliografia: - \"Banksy, gli anni di Bristol\", a cura di Steve Wright, Edizioni L'Ippocampo, pagina 73.";
System.out.println("descriptio"+ descriptio.length());
System.out.println("Index"+ descriptio.indexOf(";"));
Integer i1 = new Integer(descriptio.length());
Integer j1 = new Integer(descriptio.indexOf(";")).intValue()+1;
System.out.println("value of J"+j1);
for(int i=0;i<descriptio.length();i++) {
    if("0123456789".contains(""+descriptio.charAt(i))) {
        if(descriptio.contains(";")) {
if(i < descriptio.indexOf(";"))
	dimension       = descriptio.substring(i,descriptio.indexOf(";")+1);
else
        	 dimension       = descriptio.substring(descriptio.indexOf(";")+1,i);  	
    //      dimension       = descriptio.substring(new Integer(descriptio.indexOf(";")).intValue()+1,i);
System.out.println("dddd"+dimension);
        	
        }
        
    }
}
double printnumber = 5.2;
System.out.println("&^^^^^^^^&&&&&&&&&&^^^^^^^^^^^^^^^^^^^^^^^^^^"+(int)printnumber);

if(!str112.isEmpty())
{
	System.out.println("HELLLOINDIA!!!!!!!!!!!");
}
else {
	
	System.out.println("HELLLORSMMMMMMMMMMM");
}
if(Str111.matches("(.*)\\d{4}(.*)"))
{
	System.out.println("HEEEEEEEEEEEEEEEEEEEEEE");
}
else
{
	System.out.println("SHEEEEEEEEEEEEEEEEEEEEEEE");
}
int limit = 10; 
int countind = 0; 
String re = "olio su tela ";
String description =", , olio su tela, firma e anno in alto a destra, titolo, anno e timbro della Galleria Bergamini (MI) al retro, opera registrata presso l'Archivio Giuseppe Banchieri come da dichiarazione a cura di Gianna Rossi Maggini su foto.";
description = description.replace(re,"");
System.out.println("HELLOIND"+description);
/* Iterator it = URL_SET.keySet().iterator();
while (it.hasNext()) { 
	it.next(); 
	countind++; 

	// Check if first four i.e, (equal to N) 
	// integers are iterated. 
	if (countind > limit) { 

		// If yes then remove all the remaining integers. 
		it.remove(); 
	} 
} 
*/
String kollarscraper = "19b (K355).";
String[] kollarscraperarr = kollarscraper.split("\\.");
System.out.println("Kolaarscraper***************************"+kollarscraperarr[0]);
String str99 = "Pawan kaushik";
if(!(str99.contains(",")))
System.out.println("DoesNotcontain");
else 
	System.out.println("contain");
	System.out.println("pawankaushikninnnn"+str88.replace("$", "").replace("�", "").replaceAll(",", "").trim());
String str45 =" 161 Ferrari 2007 F430 Spider 244";
Pattern p1 = Pattern.compile("\\d{4}");
Matcher m1 = p1.matcher(str18);

int count = 0;
while(m1.find()) {
    count++;
    System.out.println("found: " + count + " : "
            + m1.start() + " - " + m1.end());
    String truncString = str18.substring(m1.start(), m1.end());
System.out.println("ture"+ truncString);
}

if(m1.find())
{
System.out.println("english");
System.out.println(m1.group(1));
}
if (str45.matches("\\d{4}")) {
    System.out.println("HelloSuccess");
    
}


System.out.println("hindi"+new Scanner(str45).useDelimiter("[^\\d{4}.*]").nextInt());
int coma15 = str45.indexOf(".*\\d{4}.*");
System.out.println("comma66666666666666666666pawankaushik"+coma15);

String[] str19 = str18.split(" ");
System.out.println("*****************"+ str19[0]);
String str15 = "1968 Mercededz benz,";
String Str16 = str15.replaceAll("^\\d+|\\d+$", "");
String Str17 = Str16.replaceAll("^\\s+|\\s+$|\\,$", "");
String str21 = "$35,000";
String str100 = "English/American, 1911-194";
String key ="977";
key = returnCountryName(key);
System.out.println("KEY**************"+key);
if(str100.matches(".*\\,\\s\\d{4}\\-\\d{4}.*"))
{
	
	System.out.println("**&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*************pawanmatching");
}
else{
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&doesnotmatch");
}
System.out.println("sr21*********"+str21.replace("$","").replaceAll(",", ""));
System.out.println("PPPPPPPPPPPPPPPPPPPPPP"+Str17);
	String[] str8 = 	str7.split(" ");
String str9 = str8[0] + " " + str8[1];
	str5.substring(0,str5.indexOf(str9));
	System.out.println("(((((((((((((((((("+str5);
	System.out.println("kkkkkkkk"+ str5.substring(0,str5.indexOf("Some soiling to the mount")));
	String str10 = " Both approximately 8 x 6 1/2 inches (210 x 170 mm)";
	
	if(str10.matches("\\s[a-z|a-z].*"))
	{
		System.out.println("&&&&&&&&&&&&&&&&&&&&&String marches");
		
		String patternStr = "\\w\\s\\d";
	    Pattern pattern = Pattern.compile(patternStr);
	    Matcher matcher = pattern.matcher(str10);
	    if(matcher.find()){
	    	System.out.println("UUUUUUUUUUUUUUUUU"+matcher.group(0));
	    System.out.println("OOOOOOOOOOOOOOOO"+matcher.start());//this will give you index
	    int comma = matcher.start();
	    String str11 = str10.substring(comma+1).trim();
		System.out.println("PPPPPPPPPPPPPPPP"+str11);

	    }
			int coma = str10.indexOf("image");
			System.out.println("comma"+coma);
			String str11 = str10.substring(coma+1).trim();
			System.out.println("PPPPPPPPPPPPPPPP"+str11);

		    
	}
	else
		System.out.println("&&&&&&&&&&&&&&&&&&&&&String not marches");	
	
	if(str5.endsWith("."))
	{ 
		System.out.println("replacewith&&&&&&&&&&&&&&&&"+ str5.substring(0,str5.length() - 1));
	}
	System.out.println("hello"+str5);
	int coma5 = str5.indexOf(".*\\[.,");
	System.out.println("comma66666666666666666666"+coma5);
	if(str5.matches(".*\\d{4}\\).*$"))
	{
		String splitbracket[] = str5.split("\\)");
		System.out.println("hellosplitfirstpart"+ splitbracket[1]);
		System.out.println("str5hello");
	} else if(str5.matches(".*\\s\\,\\s.*[^(].*$"))
	{
		int coma = str5.indexOf(".*\\[.,");
		System.out.println("comma"+coma);
		String str6 = str5.substring(coma+1).trim();
		System.out.println("kaushikjapan"+ str6);
		int comma1 = str6.indexOf(" ");
		System.out.println("pawankaushikindia^^^^^^^^^"+str6.substring(comma1+1).trim());
		String splitbracketelseif[] = str5.split(" ");
		System.out.println("insideelseifbracket"+ splitbracketelseif[4]);
		System.out.println("insideelseif");
	}
		else 
		{
		System.out.println("str5india"+str5);
		}
		System.out.println("string4"+ str4);
	
	String[] splited12 = str3.split(",");
	
	String name ="[two} pawaidddndia, [india] kaushik";
			int coma = name.indexOf(",");
			
			if (name.indexOf("{") < coma-1)
			{
				
			System.out.println("onlyfirstname"+name.substring(0, coma).trim());
			String onlyfirstname = name.substring(0, coma).trim();
			
			if(onlyfirstname.contains("{"))
			{
				int comabracketi = onlyfirstname.indexOf("}");
				System.out.println(onlyfirstname.substring(comabracketi+1).trim());
			}
			else
			{
			System.out.println(onlyfirstname.substring(0, coma).trim());
			}
				
			}	
			String lastname = name.substring(coma+1).trim();
			System.out.println("lastname"+ lastname);
			if(lastname.contains("["))
			{
				int comabracketi = lastname.indexOf("]");
				System.out.println("firstnamelastindex"+lastname.substring(comabracketi+1).trim());
			}
			
		
			String fulllastname = name.substring(coma+1).trim();
			
			int coma1 =  fulllastname.indexOf(" ");
			System.out.println("firstname***********"+fulllastname.substring(0, coma1).trim());
	System.out.println("^^^^^^^"+ splited12.length);
	System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+splited12[3]);
	if(splited12[3].contains(";"))
	   {
		  String splitne = splited12[3].replace(";", " #"); 
		  System.out.println("***************************"+splitne);
		 String[] splitednested = splitne.split("#");
		String  l_signature = splitednested[0];
		System.out.println("**********************"+ l_signature);
	   }
	
	if(str.contains("."))
	{
			String[] splited = str2.split(";");
			System.out.println("lenght"+splited.length);
		System.out.println("pawanindia"+splited[0]);
		System.out.println("helloindia" + splited[1]);
		if(splited[1].contains("."))
		{
			String splitne = splited[1].replace(".", " #");
			System.out.println("lll"+splitne);
			String[] splitednested = splitne.split("#");
					System.out.println("kaushik"+splitednested[1]);
		}
	
	/*	System.out.println(splited[2]);
		System.out.println(splited[3]);
	*/	int length = splited.length;
	System.out.println("pawan"+length);
	
		 for (String lineone : splited) {
		//	 System.out.println(splited.length);
			 System.out.println("pawankaushik"+lineone);
		 }
		 
		 
		 int f = 0;
		 int j = 0;
		 if (f != j) {
		      System.out.println("true");
		 }
		 else
		 {
			 System.out.println("hello");
		 }
	}
	
		
	}
	
	private static String returnCountryName(String key)
	{
		String countryName = null;
		if(key == "1")
			countryName = "usa";
		if(key == "91")
			countryName = "India";
		if(key == "977")
			countryName = "Nepal";
		if(key == "94")
			countryName = "SriLanka";
		return countryName;
	}
	
	

}
