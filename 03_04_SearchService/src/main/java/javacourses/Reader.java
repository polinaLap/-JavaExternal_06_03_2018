package javacourses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Class is for reading html-documents, deviding them on tokens
 * Can find references and russian words in the web-page
 * @autor Polly Lapteva
 */
public class Reader{
    /**string of start page*/
    private String source;
    /**main URL of web-site*/
    private static String mainURL;
    /**list of urls, found on this web-page*/
    private ArrayList<String> refs;
    /**
     * Get list of references from this web-page
     */
    public ArrayList<String> getRefs() {
        return refs;
    }
    /**
     * Get source string
     */
    public String getSource() {
        return source;
    }
    /**
     * Constructor - create object.
     * Set source, mainURL(if not seted earlier), initialise list of references
     */

    public Reader(String source) throws NotBuildedURLException {
        this.source = source;
        refs = new ArrayList<String>();
        if(mainURL==null){mainURL = TextAnalyzer.trimSource(source);}

    }
    /**
     * Search russian words in html-document and count their frequency.
     * @return return boolean map: (string-word) - (int-frequency)
     */
    public Map<String, Integer> findFregFromURL() throws IOException, NotBuildedURLException {
        String [] words = readEverythingFromURL();
        Map<String, Integer> m = new HashMap<String, Integer>();
        for (String a : words) {
            if(TextAnalyzer.isWord(a)){
                a = TextAnalyzer.trim(a);
                Integer freq = m.get(a);
                m.put(a, (freq == null) ? 1 : freq + 1);}
            if(TextAnalyzer.isRef(a)){
                String b = TextAnalyzer.createURL(a,mainURL);
                refs.add(b);
            }
        }
        return m;
    }
    /**
     * Read html-document, devide text on tokens
     * Is used in {@link Reader#findFregFromURL()}
     * @return array of strings
     */
    public String [] readEverythingFromURL() throws IOException {
        URL website = new URL(source);
        URLConnection connection = website.openConnection();

        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(),"windows-1251"));
        String str;
        StringBuilder sb = new StringBuilder();
        while((str=bf.readLine())!=null)
            sb.append(str);
        return sb.toString().split("\\s+|<|>|,|!|\"");
    }

}
