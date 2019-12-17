import java.io.BufferedWriter;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import jxl.write.DateTime;

public class matcherstring {
	
	private static final Pattern MATERIAL_WORDS = Pattern.compile(
			"((engravings|Vintage|Paire|watercolour|Each: steel|yarn|telone|ferro|lamiera|multigum|tecnica|alluminio|Série|scultura|Silber|Encre|tavola|acrilico|engraved|lithographed|woodengraved|woodcut|gouche|Weißgold|panelling|decorated|Épreuve|coat of arms|Crayon|Fusain|imprimés|Rosegold 585|Crayons|Crayons|frosted|farbloses Glas|Platin 950|Schale|toile|Panneau|bent|beechwood|stained bent beechwood|backrest|stained|bentwood|cane|woven|Taschenuhr|Messingguss|Keramik|solid|mirror|foam|horns|rods|tar|knife|oil assemblage|Metal|monotype printed in colours|on japan|original canvas|on cream laid|each oil on canvas board|oil and canvas|on heavy wove|on laid|on thin wove|on arches|on BFK Rives|on TH Saunders|on Van Gelder laid|on van Gelder Zonen|on Somerset satin|on glossy wove|engraving|dark|on wove|dustgrain gravure and aquatint printed in colours|plastic foam lined case|oil on masonite|pencil and fabric collage|oil on hemp cloth|drypoint with hand coloring|sliced violin and cast bronze violin inside a violin case in a Plexiglas case|MIS and Lysonic inkjet prints on Thai mulberry paper with wax|Albâtre|PANNEAU|Carton|paint|spray-paint|quatrefoil|woodcut|beide|brass|photograpy|crayon|chalk|upper left|lower left|verso|gouache|offsetlithograph|graphite|ink|leather|crayon|linocut|polished|mixed media|monoprint|digital|pastel|pen|print|plaster|tempera|pressed|vinyl| powder puff, spray pigment,|walnut|fiberglass|waterprint|digital pigment print|pienzo pigment prints|Batik|Olio|Pastello|Bubinga|Tre oli|Hershey bar|Acquerello|silk|color|decommissioned|ballpoint pen|rubber|glitter|wood|verde|pigment|c-print|plastiline|synthetic|rustoleum enamel|porcelain|jigsaw|neon lights mounted|spackle and latex on linoleum tiles|black soap|Dimensions|guitar amplifier|oil on|oil|pencil and mixed media on linen|Mahagoni|Casein|Öl auf|Pastel|photograpy|grey|oil|rosewood)([ ,].*)?" // Starts
					+ "|(.* )?(Aquarell|ivory|woods|Métal|wood|cineraria|wove paper|plastic|gesso|oil on canvas|acrylic|airbrush|albumen|ink|aluminum|bronze|ceramic|charcoal|chrome|chromogenic|cibachrome|cooper|etching|glass|glaze|gold|"
					+ "lithograph|engraving|plexiglas|Cuivre|sur|Ensemble de|ferro|walnut|tecnica|scultura|multigum|lamiera|alluminio|telone|acrilico|PANNEAU|tavola|Samtliga|Samtida|printed|Drawings|engraved|Série|paper|polished|edangered|Carton|carvings|frosted|encre|coat of arms|gouache|Albâtre|Crayons|sur|wood-engravings|printed in 5 colours|on buff paper|pencils|pencil|photogravure|sanguine|body white|wood-engraving|framing|upper corners rounded|watercolour|body colour|grey|white chalks|on laid paper|wove|chalk|sheets|ithograph|lithograh|lithographs|offsetlithograph|screen|X-ray|lithography|silkscreen|mahogany|metal|oak|on wallpaper|palladium|pattern|photograph|platinum|plywood|poster|albuminé|plomb|"
					+ "rosewood|(screen)?print|serigraph|silver|steel|teak|upholstery|watercolor|woodblock|woodcut|wool|glass|auf|bronze with wooden base|frame|Enamel|gilt|granite|hardboard|iron|volant|screenprints|wove|mauve|tissue|on japan|Pochoir|on Arches|Drypoint|aquatint|carborundum|photographic|polychrome|sissoo|polyester|handmade|and printed paper collage|wood|polymer paint|wrapper collage|on light blue translucent Plexiglas|, wax, brass, concrete,spray paint, incense|, pedal, DVD player,|encaustic and varnish|varnish|magazines|aluminium and glue|laid on |hoses|and coloured|and ink on foamcore|and enamel|antique|light box|wax crayon|wax crayon|coloured crayon|paper pulp|rhinestones|embroidery|beading|flashe|neon|UV ink|wire|linen|tin|colored|unpainted|sequins|Plexiglas|engraved|lithographed|woodengraved|woodcut|gouche|planche|particle board|screws|nails|patinated|staples|tape)([ ,\\-].*)?" // middle
					+ "|.* (on canvas|on board|on cream laid|on heavy wove|lamiera|tecnica|ferro|scultura|PANNEAU|multigum|boards|alluminio|telone|tavola|acrilico|on thin wove|stained|plinth|doors|opening|drawers|motifs|ornament|compartment|restored|patterning|panels|Série|Carton|couleurs|crayon|Crayon|encre|frosted|Crayons|paper with card support|Albâtre|on wove|stencil and screen printed paper collage on wooden skateboard deck|patina|holz|bronze|papier|leinwand|papier auf karton|on paper|on unstretched canvas|su tela|su cartone|crayons on paper|su carta|with pins|paper|and wood|brass|with hot glue|resinon linen|and iron|paper pulp|marble|resin|on paper over board|on graph paper|and painted latex|with portfolio box|on Plexiglas|with Danish oil|cibachrome print|on panel|over panel|on HMP paper|c-print|on bristol board|over panel|silhouettes|paper|puzzle| with wire, string or lace and transformer|on wood panel|and shea butter|variable|electronic equipment|on museum board|in wooden artist frame|engraved|lithographed|woodengraved|woodcut|gouche|in wooden artist|parts|patinated|toiles|on laid paper|panneaux|planches|lower left)" // Ends
					+ ").*",
			Pattern.CASE_INSENSITIVE);


	
	
	static double  testdouble;
	
	
	public static Boolean isMaterial(String input){
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTt");
		System.out.println(MATERIAL_WORDS.matcher(input).matches());
	//	System.out.println(MATERIAL_WORDS.matcher(input).group(1));
		
		 Pattern ltm_pattern = Pattern.compile("(,)\\s"+MATERIAL_WORDS+".*(,)");
         Matcher ltm_matcher = ltm_pattern.matcher(input);
         if (ltm_matcher.find()) {
           //  String l_newDimension = l_matcher.group(2) + "" + l_matcher.group(3);
          //   l_newDimension = l_newDimension.replace(".", ",");
            
               System.out.println("l_matcher.group(3str2)pawan"+ltm_matcher.group(0).replaceAll(",", "").trim());
            //  System.out.println("Dimension*********str2pawan"+ l_newDimension);
         //    str2 = l_matcher.group(1)+l_newDimension+l_matcher.group(4);
         }
		
		
		
		
        return MATERIAL_WORDS.matcher(input).matches();
      }
	
	
	
	 
	protected static DateTimeFormatter DATE_OUT_FORMATTER = DateTimeFormat
            .forPattern("dd-MM-YYYY");
	
	private static String strinetrailling(String strind) {
		
		if(strind.startsWith(",") || strind.startsWith(".") || strind.startsWith(";"))
		{
			strind = strind.substring(1,strind.length());
		}
		
		if(strind.endsWith(",") || strind.endsWith(".") || strind.endsWith(";"))
		{
			strind = strind.substring(0,strind.length()-1);
		}
		System.out.println("ppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppLLLLLLLLLL"+strind.trim());
		return strind.trim();
				
		
	}
	
	public static void main(String args[])
	
	
	
	{
		
		String abcdefghij = "10 7/8  by 8 5/8  in.; 27.5 by 21.8 cm. ";
		String artwork_measurements_height = null;
		String artwork_measurements_width = null;
		String artwork_measurements_depth = null;
		
		double artwork_measurements_height1;
		double artwork_measurements_width1;
		double artwork_measurements_depth1;;
		String auction_measureunit = null;
		String[] splitvalue = abcdefghij.split(";");
	String finalvalue = splitvalue[1].trim();
	//	Pattern lt_pattern = Pattern.compile("(,)\\s(signed).*(,)");
		Pattern l_pattern = Pattern.compile("(.*)(by)(.*)cm");
		
	/*	Pattern l_pattern = Pattern.compile(
				"[\\s]*(([\\D]*)([\\d]+[\\.]{0,1}[\\d]*)[\\s]*[\\D]*(x)[\\s]*([\\d]+[\\.]{0,1}[\\d]*)[\\s]*(x)[\\s]*([\\d]+[\\.]{0,1}[\\d]*)[\\s]*(cm)*)(.*)");
	Matcher	l_matcher = l_pattern.matcher(abcdefghij.replace("xtttttt", "x").replace("ttttttt", "x") 
				.replace("ttttttcm", "cm").replace("in. x", "x").replace("by", ""));*/
				Matcher	l_matcher =l_pattern.matcher(finalvalue);
		if (l_matcher.find()) {
			artwork_measurements_height = l_matcher.group(0);
			artwork_measurements_width = l_matcher.group(1);
			artwork_measurements_depth = l_matcher.group(3);
			auction_measureunit = "cm";
		} else {
			l_pattern = Pattern.compile(
					"[\\s]*(([\\D]*)([\\d]+[\\.]{0,1}[\\d]*)[\\s]*[\\D]*(x)[\\s]*([\\d]+[\\.]{0,1}[\\d]*)[\\s]*(cm)*)(.*)");
			l_matcher = l_pattern.matcher(abcdefghij.replace("xtttttt", "x").replace("tttt", "x")
					.replace("tcm", "cm").replace("in. x", "x").replace("by", ""));
			if (l_matcher.find()) {
				artwork_measurements_height = l_matcher.group(3);
				artwork_measurements_width = l_matcher.group(5);
				artwork_measurements_depth = "0";
				auction_measureunit = "cm";
			}
		}
		
		System.out.println("**********&&&&&&***"+ artwork_measurements_height);
		System.out.println("**********&&&&&&***"+ artwork_measurements_width);
		System.out.println("**********&&&&&&***"+ artwork_measurements_depth);
		System.out.println("**********&&&&&&***"+ auction_measureunit);
		
		
		
		
		
		String abc = strinetrailling(", pawan kaushik;");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"+abc);
		
	
		int eurocategory1=200;
		int eurocategory2=5000;
		int dollarcategory1=500;
		int dollarcategory2=7500;


		int poundcategory1=200;
		int poundcategory2=5000;

		int hongkongcategory1=2200;
		int hongkongcategory2=55000;

		int CHFcategory1=250;
		int CHFcategory2=6250;

		int AUDcategory1=320;
		int AUDcategory2=8000;

		int SEKcategory1=1900;
		int SEKcategory2=47500;

		int DKKcategory1=1600;
		int DKKcategory2=40000;

		int MXNcategory1=3800;
		int MXNcategory2=95000;

		int CZKcategory1=6000;
		int CZKcategory2=150000;

		int CADcategory1=300;
		int CADcategory2=7500;

		
		
		String currency ="euro";
		double prop1 =0;
		double cat1 = 0;
		double cat2 = 0;
		double cattemp1 = 0;
		double cattemp2 = 0;
		int cat3 =0;
		String cat4 ="";
		
		if (currency.equalsIgnoreCase("euro") || currency.equalsIgnoreCase("EUR")) {
            cattemp1 = 200;
            cattemp2 =5000;
            		
    } else if (currency.equalsIgnoreCase("british pound")) {
    	cattemp1 = 200;
        cattemp2 =5000;
    } else if (currency.equalsIgnoreCase("us dollar") || currency.equalsIgnoreCase("USD")||currency.equalsIgnoreCase("US Dollar")) {
    	cattemp1 = 500;
        cattemp2 =7500;
    } else if (currency.equalsIgnoreCase("hong kong dollar")) {
    	cattemp1 = 2200;
        cattemp2 =55000;
    } else if (currency.equalsIgnoreCase("swiss franc")) {
    	cattemp1 = 250;
        cattemp2 =6250;
    } else if (currency.equalsIgnoreCase("australian dollar")) {
    	cattemp1 = 320;
        cattemp2 =8000;
    }else if (currency.equalsIgnoreCase("swedish krona")) {
    	cattemp1 = 1900;
        cattemp2 =47500;
    }
    else if (currency.equalsIgnoreCase("CAD")) {
            
            cattemp1 = 300;
            cattemp2 =7500;
    }
		
		cat1 = cattemp1;
    	cat2 = cattemp2;
		
		System.out.println("cat3333333333333333333333333333"+cat2);
		
		System.out.println("cat3333333333333333333333333333"+cat1);
		
		if(testdouble==0.0)
			 System.out.println("hello double");
		 else
			 System.out.println("Not double");
		
		
		Pattern l_pattern_temp = Pattern.compile("(.*)(by)(.*)cm.");
		
		String value ="23 1/2 by 28 in.; 59.7";
		value = value.replaceAll(" 1/2", ".50");
		Matcher	l_matcher_temp =l_pattern_temp.matcher(value.replace("x", "by"));
if (l_matcher_temp.find()) {
	System.out.println("inside018888888888888888888888888888888888888");
	System.out.println("KKKKKKKKKKKKKKKKKKKKKK"+l_matcher_temp.group(0));
	artwork_measurements_height1 = Double.parseDouble(l_matcher_temp.group(1));
	System.out.println("HHHHHHH"+artwork_measurements_height1);
	System.out.println("inside02");
	
	artwork_measurements_width1 = Double.parseDouble(l_matcher_temp.group(3));
	System.out.println("HHHHHHH"+artwork_measurements_width1);
	System.out.println("inside03");
	artwork_measurements_depth1 = Double.parseDouble(l_matcher_temp.group(3));
	auction_measureunit = "cm";
}
String artwork_materials ="lower left: no. 10";

if (MATERIAL_WORDS.matcher(artwork_materials).matches()) {
	System.out.println("InsideMaterialWords********************************");
	if (!"".equals(value)) {
		artwork_materials = artwork_materials + ", " + value;
		System.out.println("UUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU");
		System.out.println(artwork_materials);
	} else {
		artwork_materials = value;
		System.out.println("LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
		System.out.println("artwork_materials");
	}
}
if (value.contains("inches") || value.contains("in."))
	
		{
	Pattern l_pattern_temp1 = Pattern.compile("(.*)(by)(.*)(in.|inches)");
	Matcher	l_matcher_temp1 =l_pattern_temp1.matcher(value.replace("x", "by"));
	if (l_matcher_temp1.find()) {
		System.out.println("inside011111111177777777777777777777777777777777777777777777777777777777777777777");
		artwork_measurements_height1 = Double.parseDouble(l_matcher_temp1.group(1).replace(",", ""));
		System.out.println("inside0222222222222");
		artwork_measurements_width1 = Double.parseDouble(l_matcher_temp1.group(3));
		System.out.println("inside03333333333333");
		artwork_measurements_depth1 = 0.0;
		auction_measureunit = "in";
	}
	else {
		System.out.println("HEL))))))))))))))))))))))))))))))))))))))))))))))");
	}
		}



		
String value1 = "Pen and brown ink and wash, heightened with white, over black chalk on paper washed brown, 320 by 225 mm";

if(value1.contains("mm") ) {
	System.out.println("IIIIIIIIIII22222222222222insidevalue");
if(value1.contains(","))
{
	String[] values = value1.split(",");
value1 = values[values.length-1];
} 
	Pattern l_pattern_temp1 = Pattern.compile("(.*)(by)(.*)mm");
	

			Matcher	l_matcher_temp1 =l_pattern_temp1.matcher(value1.replace("x", "by"));
	if (l_matcher_temp1.find()) {
		System.out.println("inside0111111111");
		artwork_measurements_height1 = Double.parseDouble(l_matcher_temp1.group(1).replace(",", ""))/10;
		System.out.println("HHHHHHHKKKKKKKKKKKKKKKKKKKKKKKKKKK"+artwork_measurements_height1);
		System.out.println("inside0222222222222");
		artwork_measurements_width1 = Double.parseDouble(l_matcher_temp1.group(3))/10;
		System.out.println("HHHHHHHKKKKKKKKKKKKKKKKKKKKKKKKKKK"+artwork_measurements_width1);
		System.out.println("inside03333333333333");
		artwork_measurements_depth1 = 0.0;
		auction_measureunit = "cm";
	}
}





		try {
			
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

			Date date = simpleDateFormat.parse("2018-09-09");
			
			DateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

			Date today = new Date();
			
			Date todayWithZeroTime = formatter1.parse(formatter1.format(today));
			System.out.println("Todaydatevvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv"+DATE_OUT_FORMATTER.print(new Date().getTime())) ;
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String strDate= formatter.format(new java.util.Date());
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
				DateTimeFormatter DATE_FORMATTER = DateTimeFormat.forPattern("dd/MM/YYYY");
				org.joda.time.DateTime dts = DATE_FORMATTER.parseDateTime(strDate);
				System.out.println("Todaydate"+dts.toLocalDate());
				Date date1=dateFormat.parse(strDate);
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^"+dateFormat.parse(strDate));
			//date1 = new SimpleDateFormat("dd-MM-yyyy").parse(new SimpleDateFormat("dd-MM-yyyy").format(new java.util.Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 //       System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDd"+date1);
		
		
		
		
		
		
		 
	String PATH = "${environment.default.path}";
		
		System.out.println("PATH"+PATH);
		 String l_material = "Hello pawan, Brass and cast iron, India won";
		 
		 

		 matcherstring ms = new matcherstring();
		 ms.isMaterial(l_material);
		 
		String l_dimension1 =	"14 x 11 inches (36 5 x 28 5 cm)";
		String l_dimension ="7 3/8 x 9 3/8 inches (190 x 240 mm)";
		String tempnum = "(pawan kaushik) hello";
		String[] tempnum_arr = tempnum.split("\\)");
			System.out.println("HHHHHHHHHHHHOOOOOOO"+tempnum_arr[1]);	
				String pktemp = " i am a cowboy 1998";
				if(pktemp.trim().matches("[A-Za-z].*\\s\\d{4}"))
				{
					System.out.println("PLLLLLLL"+ pktemp.trim().substring(pktemp.lastIndexOf(' ') + 1).trim());
					System.out.println("SKKKKKKKK"+ pktemp.trim().substring(0, pktemp.lastIndexOf(' ')).trim());
				}
		String pk = "pawan kaushik Example hello";
		String new_str = pk.substring(pk.indexOf("Example"));
		
		System.out.println("NEWSTR"+new_str);
		
		
		String localString = "designed pawan, signed by kaushik,dinanath";
		if(localString.matches(".*(signed).*(,).*"))
		{
			System.out.println("HELLLLLLLLEEEEEEEELLLLLLLLLLLLLLLLEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		System.out.println("PLLLLLLL"+ localString.trim().substring(localString.lastIndexOf(',') + 1).trim());
		System.out.println("SKKKKKKKK"+ localString.trim().substring(0, localString.lastIndexOf(',')).trim());
	//	String requiredString = localString.substring(localString.indexOf(",") + 1, localString.indexOf(","));
	//	System.out.println("requiredstring"+requiredString);
	//	System.out.println("hello"+localString.substring(localString.indexOf("signed"),localString.indexOf(","))) ;
		
		} else
			System.out.println("NOTMATCHEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
	
		
		if(localString.matches(".*(signed).*(,).*")) {
        	System.out.println("Pawan*****");;
         	 Pattern lt_pattern = Pattern.compile("(,)\\s(signed).*(,)");
         Matcher lt_matcher = lt_pattern.matcher(localString);
         if (lt_matcher.find()) {
           //  String l_newDimension = l_matcher.group(2) + "" + l_matcher.group(3);
          //   l_newDimension = l_newDimension.replace(".", ",");
             System.out.println("l_matcher.group(1str2)pawan"+lt_matcher.group(1));
             System.out.println("l_matcher.group(2str2)pawan"+lt_matcher.group(2));
               System.out.println("l_matcher.group(3str2)pawan"+lt_matcher.group(0).replaceAll(",", "").trim());
            //  System.out.println("Dimension*********str2pawan"+ l_newDimension);
         //    str2 = l_matcher.group(1)+l_newDimension+l_matcher.group(4);
         }
		
		}
		
		
		
		
	//	String  sizeNote = l_dimension1.replaceAll("[^a-zA-Z]"," ").replace("inche", "").replace("x", "").replace("X", "").replace("mm", "").replace("s", "");
//	System.out.println("*******************sizeote"+sizeNote);
		String stringbracket = "[ANONYMOUS] Untitled [Portrait of";
		String l_artistName ="[SIGNED PHOTOBOOKS] CARTIER-BRESSON, HENRI. Three volumes inscribed to Anne Horton.";
	/*	if(l_artistName.contains(" , "));
		{
		String[] artistsplit = l_artistName.split(",");
		String[] artistsplitremoveextra =  artistsplit[0].split(" ");
				String[] artistsplitremoveextralastname =  artistsplit[1].split(" ");
		l_artistName = artistsplitremoveextra[1]+ " , " + artistsplitremoveextralastname[0];
		System.out.println("lartist"+ l_artistName);
		}
	*/	
		String str1 = "China. Qing-Dynastie. 18. Jh. <br /><br />Porzellan. Teller mit geritztem, Pinselwascher mit Reliefdekor. Gelb und Grün glasiert. Höhe 3,9cm. Tellerchen Höhe 2.6cm, Ø 10.6cm. Zustand A/B. Beilage: Vase mit Pflaumenzweigen. Steinzeug mit dunkelgrüner Glasur. Angetöpferter Sockel auf vier Füßen, braun glasiert. China. 18. Jh. H.14cm. Zustand A/B. ";
		String str2 = "China. 19. Jh. <br /><br />Porzellan, bemalt mit Aufglasurfarben. Im Vordergrund unter großen Kiefern Häuser, Pavilions und Personen am Seeufer. Ein <br />Bogentor im Hof als Zugang in die übereinander geschichteten Berge in Grün-Blau-Malerei. <br />In der Fernen Reihen von Kiefern und weitere Berge im Nebel. Im Himmel die Sonne von <br />einzelnen Wolken verdeckt. 52 x 51cm. Zustand A/B. Unten links minimale Ausplatzungen des Emails. ";
		String str3 ="52 x 51cm";
	//	String str4= "<strong> Château Léoville Las Cases 2003  </strong> (2 mags)<br/>Scuffed labels<br/> <strong> Château Pavie 2006  </strong> (1 dm)<br/><br/>2 mags and 1 d.mag - 3 litres (cn)<br/><br/><span" style="font-style:italic;font-size:smaller;">Estimates are per lot</span><br/></div>";
String str5 = "Ech&eacute;zeaux";
String str8 = Normalizer.normalize(str5, Normalizer.Form.NFD);
//str5 = str5.replaceAll("\\p{M}", "");

String tempone ="Muhamed Ali, Ohne Titel - Charity auction 2019/02/25 - Realized price:  EUR 300 - Dorotheum";
String[] splitstringtemp = tempone.split("-");
System.out.println("&&&&&&&&***********(((((((((((("+splitstringtemp[0]);
String str9900 = "41x40x42 cm";
if(str9900.matches(".*\\d.*cm$"))
	System.out.println("HELLLLLLLLLLLLLLLL");
else
{
	System.out.println("UKKKKKKKKKKKKKKKKKKKK");
}

String str990 = "1947,pawan";
String temppaw ="Mischtechnik auf Papier www.art-andje.at www.art-andje.at";
String[] tempaw_arr = temppaw.split("www");
System.out.println("KKKKKKKKKKKKKKKK"+tempaw_arr[0]);
String pawtemp ="gerahmt 52 x 41 cm";
pawtemp = pawtemp.replaceAll("(\\d+)(.*)x(.*)(\\d+)(.*)cm", "");
System.out.println("PPPPPPPPJJJJJJJJJJJ"+pawtemp);

if(str990.matches("^\\d{4}.*")) {
	System.out.println("Helloindiapawan***************************************************");
}
else {
	System.out.println("Hellopawankaushikindia&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
}

String str7 = str8.replaceAll("[^\\p{ASCII}]", "");
System.out.println("pppppppppppppp"+str7);
		String patternStr = "([\\d]{1,2}[\\s]*[\\w]*[\\s]*[\\d]{4})";
		String dateind= "08 December 2018";
		String patternString = "(.*) *((Provenance:|(Provenance :|Provenance:) *(.*)))";
		 Pattern patternStri = Pattern.compile(patternString);
		    Matcher matcherInd = patternStri.matcher(str5);
		    if(matcherInd.find()){
		    	System.out.println("UUUUUUUUUUUUUUUUUhelloindiapawan");
		    }
		    	else
		    	{
		    		System.out.println("HelloIndiapawankaushik");
		    	}
		    	
		    
		    
		    
		    
		    
	    Pattern patternind = Pattern.compile(patternStr);
	    Matcher matcherind = patternind.matcher(dateind);
	    
	    if(matcherind.find()){
	    	System.out.println("UUUUUUUUUUUUUUUUU"+matcherind.group(0));
	    String	l_date = matcherind.group(0);
	    	
	    	
	    	System.out.println("UUUUUUUUUUUUUUUUU%%%%%%%%"+matcherind.group(1));
	    System.out.println("****************************************************pawan");
	    }
	    
	    int coma = str3.indexOf(".*\\x");
		System.out.println("comma"+coma);
		String str6 = str3.substring(coma+1).trim();
		System.out.println("pawanindia777777777777777"+str6);
		String[] myStringsnestedindind = str3.split(" ");
		System.out.println("pawanindia"+myStringsnestedindind[0]);
		System.out.println("pawanindia1"+myStringsnestedindind[1]);
	/*	if(str1.matches("(.*)(\\d+[.]\\d[c][m])(.*)")) {
        	
	       	 Pattern l_pattern = Pattern.compile("(.*)(\\d+[.]\\d[c][m])");
	       Matcher l_matcher = l_pattern.matcher(str1);
	       if (l_matcher.find()) {
	           String l_newDimension = l_matcher.group(1);
	           System.out.println("Dimension*********"+ l_newDimension);
	       }
			}
			
		*/
	//	2.6cm, Ø 10.6cm.
	/*	System.out.println("beforestring***************************");
		if(str1.matches("(.*)(\\d+[.]\\d[c][m]).*(\\d+[.]\\d[c][m])(.*)")) {
        	System.out.println("Pawan*****");;
         	 Pattern l_pattern = Pattern.compile("(.*)(\\d+[.]\\d[c][m]).*(\\d{2}+[.]\\d[c][m])(.*)");
         Matcher l_matcher = l_pattern.matcher(str1);
         if (l_matcher.find()) {
             String l_newDimension = l_matcher.group(2) + "" + l_matcher.group(3);
             l_newDimension = l_newDimension.replace(".", ",");
             System.out.println("l_matcher.group(1str2)pawan"+l_matcher.group(1));
             System.out.println("l_matcher.group(2str2)pawan"+l_matcher.group(2));
               System.out.println("l_matcher.group(3str2)pawan"+l_matcher.group(3));
               System.out.println("Dimension*********str2pawan"+ l_newDimension);
             str2 = l_matcher.group(1)+l_newDimension+l_matcher.group(4);
         }
         }
		
		System.out.println("beforestring");
		if(str1.matches("(.*)(\\d\\d+[.]\\d[c][m])(.*)")) {
        	System.out.println("Beforestring1*********");
       	 Pattern l_pattern = Pattern.compile("(.*)(\\d{2}[.]\\d+[c][m])(.*)");
       Matcher l_matcher = l_pattern.matcher(str1);
       if (l_matcher.find()) {
           String l_newDimension = l_matcher.group(1);
           System.out.println("l_matcher.group(2)"+l_matcher.group(1));
          System.out.println("l_matcher.group(3)"+l_matcher.group(2));
           System.out.println("Dimension*********&&&&&"+ l_newDimension);
       }
		}
		System.out.println("Beforestring2");
		
		*/
		
		Pattern pattern = Pattern.compile(".*\\s.*,.*");
		Matcher matcher = pattern.matcher(l_artistName);
		while (matcher.find()) {
		    System.out.println(matcher.group(0));
		}
		
		
		
		
		if(l_artistName.startsWith("["))
		{
		String[] pawanstring =	l_artistName.split("] ");
			System.out.println("pawan"+ pawanstring[1]);
		System.out.println("hello"+l_artistName.substring(1,l_artistName.indexOf("] "))) ;
		}
	
		String requiredString = l_artistName.substring(l_artistName.indexOf("]") + 1, l_artistName.indexOf(","));
	System.out.println("requiredstring"+requiredString);
		
	if(l_artistName.matches("\\[.*\\].*"))
	{
		System.out.println("String match");
	}
	
	else{
		System.out.println("String not match");
	}
	
	
		String material1 = "pawan kaushik vintage india, hello yarn ram printer. aarush engraved with kaushik ";
	String material = material1;
	boolean z = true;
	for(int i=0;i<3;i++)
	{
		if(i==0)
		{
			System.out.println("insidezero");
		}
		
		else if(i==1)
		{
			System.out.println("insideone");
		}
		else if(i==2 && z==false)
		{
			System.out.println("insidetwo");
		}
		else if(i==2 || i==3)
		{
			System.out.println("insidetwoandthree");
		}
		
	}
	String[] myStrings = material.split("[.,]+");
	/* String patternString = ".*w";
	
	Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
	String[] myStrings = pattern.split(material); */
	
	if(material1.contains("with")){
    	System.out.println("material"+material);
    String	siglocal = material.substring(material.indexOf("with"));
    	System.out.println("siglocalindia111111111*************"+siglocal);
	}
	for(int x=0; x< myStrings.length;x++)
			{
		 System.out.println("helloindia"+myStrings[x]);
		String[] myStringsnested = myStrings[x].split(" ");
		for(int k=0; k< myStringsnested.length;k++)
	   
	    if(myStringsnested[k].contains("engraved123")) {
	        //the extension expression is contained in the string
	        System.out.println("expression found");
	        System.out.println("foundserial"+myStrings[x]);
	 /*   }
	    else if(myStringsnested[k].contains("with")){
	    	System.out.println
        String	siglocal = myStringsnested[k].substring(myStringsnested[k].indexOf("with"));
        	System.out.println("siglocalindia*************"+siglocal);
	       break;  */
	    }
	    
			}
	
/*	fileXtensionMatcher = MATERIAL_WORDS.matcher(material);
	if(fileXtensionMatcher.find()) {
        //the extension expression is contained in the string
        System.out.println("Extension expression found.");
        System.out.println(fileXtensionMatcher.group());
    } */
	
	}
	

}
