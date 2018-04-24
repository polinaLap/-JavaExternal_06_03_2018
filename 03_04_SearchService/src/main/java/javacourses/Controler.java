package javacourses;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.Map.Entry;
/**
 * Class is imitation of search-service
 * Able to form map: (string-word) - (list of strings-urls), using url of start page
 * Able to search a word in this map
 * @autor Polly Lapteva
 */
public class Controler {
    /**maximum count of sites to read*/
    static int maxSiteCount =20;
    /**maximum count of most popular words per site*/
    static int wordsPerSite = 10;
    /**list of urls, that found on all pages*/
    private ArrayList<String> refs;
    /**map: (string-word) - (list_of_string-urls)*/
    private Map<String,Set<String>> words;
    /**exemplar of Reader class*/
    private Reader r;
    /**
     * Get words {@link Controler#words}
     */
    public Map<String, Set<String>> getWords() {
        return words;
    }
    /**
     * Constructor - initialise refs, words
     * @param r - exemplar of Reader class for reading first web-page
     */
    public Controler(Reader r) {
        refs = new ArrayList<String>();
        words = new HashMap<String, Set<String>>();
        this.r = r;
    }
    /**
     * Read one web-page using {@link Reader#findFregFromURL()}
     * @param r - examplar of Reader
     * @return map: (word - frequency)
     */
    private Map<String,Integer> readMap(Reader r){
        Map<String,Integer> wds= null;
        try{
            wds = r.findFregFromURL();
            if(refs.size() <=maxSiteCount)refs.addAll(r.getRefs());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch (NotBuildedURLException e){
            System.out.println(e.getMessage());
        }
        return wds;
    }
    /**
     * Form map (string-word) - (list of strings-urls) and write it in the fild - {@link Controler#words}
     * Also write referencies of current web-page to {@link Controler#refs}
     * Read web-pages while general count of referencies<{@link Controler#maxSiteCount}
     */
    public void formMap_Word_Sites() throws NotBuildedURLException {
        Map<String,Integer> wds= readMap(r);
        List<String> tops  = findTopWords(wds);
        form_listURLs(r.getSource(),tops);
        int i=0;
        while(i<maxSiteCount ){
            if(refs.isEmpty()) break;
            r = new Reader(refs.get(i));
            wds = readMap(r);
            tops=findTopWords(wds);
            form_listURLs(refs.get(i),tops);
            i++;
        }

    }
    /**
     * Add new items to words
     * @param url - url of web-page
     * @param topWords - most popular words on this url
     */
    private void form_listURLs(String url, List<String> topWords){
        for (String word: topWords) {
            if(words.containsKey(word)) words.get(word).add(url);
            else {
                Set<String> urls = new HashSet<String>();
                urls.add(url);
                words.put(word, urls);
            }
        }
    }
    /**
     * Search urls which has this keyWord in list of top-words
     * @param keyWord - url of web-page
     * @return set of urls
     */
    public Set<String> search(String keyWord){
        if(words==null) System.out.println("Form a map of words firstly!");
        return getWords().get(keyWord);
    }
    /**
     * Select top words from map
     * @param map - map: (word)-(frequency)
     * @return list of top words
     */
    public static  List<String> findTopWords(Map<String, Integer> map){
        Set<Entry<String, Integer>> set = map.entrySet();
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );
        List<String> result = new ArrayList<String>();
        for (int i=0;i<list.size()&&i<wordsPerSite;++i) {
            result.add(list.get(i).getKey());
        }

        return result;
    }


}
