
import javacourses.NotBuildedURLException;
import javacourses.TextAnalyzer;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.*;

public class TextAnalyzerTest {
    @Test
    public void testIsWordMethod_RusWord_true()
    {
        String word="";
        try{
            word =  new String("хорошо".getBytes("ISO-8859-1"),"UTF8");}
        catch (UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        assertTrue(TextAnalyzer.isWord(word));
    }
    @Test
    public void testIsWordMethod_RefNotWord_false()
    {
        assertFalse(TextAnalyzer.isWord("http://www.stihi-rus.ru/World/Shekspir/"));
    }
    @Test
    public void testIsWordMethod_TagNotWord_false()
    {
        assertFalse(TextAnalyzer.isWord("s.type"));
    }
    @Test
    public void testIsRefMethod_httpRef_true()
    {
        assertTrue(TextAnalyzer.isRef("http://www.stihi-rus.ru/World/Shekspir/"));
    }
    @Test
    public void testIsRefMethod_notHttpRef_true()
    {
        assertTrue(TextAnalyzer.isRef("/World/Shekspir/2.htm"));
    }
    @Test
    public void testIsRefMethod_wrongRef_false()
    {
        assertFalse(TextAnalyzer.isRef("http//www.stihi-rus.ru/World/Shekspir/"));
    }

    @Test
    public void testTrimMethod_simpleWord()
    {
        String word1="";
        String word="";
        try{
            word1 =  new String(" любовь...".getBytes("ISO-8859-1"),"UTF8");
            word =   new String((TextAnalyzer.trim(word1)).getBytes("UTF8"),"ISO-8859-1");}
        catch (UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        assertEquals("любовь", word);
    }
    @Test
    public void testTrimMethod_EngWord()
    {
        assertEquals("return/", TextAnalyzer.trim("return/"));
    }
    @Test
    public void testTrimSourceMethod_ok() throws NotBuildedURLException {
        assertEquals("http://www.stihi-rus.ru", TextAnalyzer.trimSource("http://www.stihi-rus.ru/World/Shekspir/"));
    }
    @Test(expected = NotBuildedURLException.class)
    public void testTrimSourceMethod_notOk() throws NotBuildedURLException {
         TextAnalyzer.trimSource("/skill21.gif");
    }
    @Test
    public void createURLMethod_fromNotFullURL() throws NotBuildedURLException {
        assertEquals("http://www.stihi-rus.ru/World/Shekspir/1.htm",TextAnalyzer.createURL("/World/Shekspir/1.htm","http://www.stihi-rus.ru"));
    }
    @Test
    public void createURLMethod_fromFullURL() throws NotBuildedURLException {
        assertEquals("http://www.stihi-rus.ru",TextAnalyzer.createURL("http://www.stihi-rus.ru","http://www.stihi-rus.ru"));
    }
    @Test(expected = NotBuildedURLException.class)
    public void createURLMethod_noMainURL() throws NotBuildedURLException {
        TextAnalyzer.createURL("http://www.stihi-rus.ru",null);
    }
}