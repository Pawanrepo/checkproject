import java.util.regex.Pattern;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PatternMatchesExample {

    public static void main(String[] args) {

        String text    =
                  "kaushikindia John writes about this, and John Doe writes about that," +
                          " and John Wayne writes about everything."
                ;

        String patternString1 = "(John) ";

        Pattern      pattern      = Pattern.compile(patternString1);
        Matcher      matcher      = pattern.matcher(text);
        StringBuffer stringBuffer = new StringBuffer();

        while(matcher.find()){
            matcher.appendReplacement(stringBuffer, "Joe Blocks ");
            System.out.println("pawan"+stringBuffer.toString());
        }
        matcher.appendTail(stringBuffer);

        System.out.println("kaushik"+stringBuffer.toString());
    }
}