package javacourses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Class is for analysing html-documents, devided on tokens
 * Have only static methods
 * @autor Polly Lapteva
 */
public class TextAnalyzer {
    /**
     * Check token is word or not.
     * Word is only RUSSIAN word.
     * @param a - word to check
     * @return return boolean
     */
    public static boolean isWord(String a) {
        Pattern p2 = Pattern.compile(".*[\\u0410-\\u044F]+.*");
        Matcher m2 = p2.matcher(a);
        return  m2.matches();
    }
    /**
     * Check token is web-reference or not.
     * Reference can be full or local.
     * @param a - token to check
     * @return return boolean
     */
    public static  boolean isRef(String a) {
        Pattern p = Pattern.compile("((https?:\\/)?(\\/([\\/\\w \\.-])+))?([\\da-z\\.-]+)\\.((com|html?|ru|ua))([\\/\\w-]*)*\\/?");
        Matcher m = p.matcher(a);
        return  m.matches();
    }
    /**
     * Form the word without additional signs(.,!< and so on)
     * @param word - word to trim - must be RUSSIAN
     * @return return "bare" word
     */
    public static  String trim(String word){
        StringBuilder str = new StringBuilder(word);
        Pattern p1 = Pattern.compile(".*[\\u0410-\\u044F]+[^\\u0410-\\u044F]+");
        Matcher m1 = p1.matcher(str);
        while(m1.matches()) {
            str.deleteCharAt(str.length()-1);
            m1 = p1.matcher(str);
        }
        Pattern p2 = Pattern.compile("[^\\u0410-\\u044F]+[\\u0410-\\u044F]+");
        Matcher m2 = p2.matcher(str);
        while(m2.matches()) {
            str.deleteCharAt(0);
            m2 = p2.matcher(str);
        }
        return str.toString();

    }
    /**
     * Form the main URL of the site to help forming right urls with local references later
     * @param source - URL adreess
     * @return return URL, that end is (com|ru|ua), if source is not URL return ""
     */
    public static String trimSource(String source) throws NotBuildedURLException {
        if(source==null) throw new NotBuildedURLException("Wrong URL");
        Pattern p = Pattern.compile("((https?:\\/)(\\/([\\/\\w \\.-])+))?([\\da-z\\.-]+)\\.((com|ru|ua))");
        StringBuilder res= new StringBuilder(source);
        Matcher m = p.matcher(res);
        while (!m.matches()&res.length()>0){
            res.deleteCharAt(res.length()-1);
            m = p.matcher(res);
        }
        if("".equals(res.toString())) throw new NotBuildedURLException("Wrong URL");
        return res.toString();
    }
    /**
     * Form the URL from local references
     * @param a - local reference
     * @param mainURL - main part of URL of this site, must be trimed in trimSource {@link TextAnalyzer#trimSource}
     * @return return global URL
     */
    public static  String createURL(String a, String mainURL) throws NotBuildedURLException {
        if(mainURL ==null||mainURL=="") throw new NotBuildedURLException("Can't build full URL, see only local adress");
        Pattern p = Pattern.compile("((https?:\\/)(\\/([\\/\\w \\.-])+))?([\\da-z\\.-]+)\\.((com|html?|ru|ua))([\\/\\w-]*)*\\/?");
        Matcher m = p.matcher(a);
        if(m.matches())return a;
        return mainURL+a;
    }
}
