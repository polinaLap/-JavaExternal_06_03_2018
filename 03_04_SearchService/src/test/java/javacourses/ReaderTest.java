package javacourses;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import static org.junit.Assert.*;

public class ReaderTest {



    @Test
    public void testReadEverythingFromURL_Ok() throws IOException, NotBuildedURLException {
        Reader r = new Reader("http://www.stihi-rus.ru/World/Shekspir/1.htm");
        assertNotNull(r.readEverythingFromURL());
    }
    @Test(expected = IOException.class)
    public void testReadEverythingFromURL_IOException() throws IOException, NotBuildedURLException {
        Reader r = new Reader("http://www.stihi-rus.r.htm");
        r.readEverythingFromURL();
    }
    @Test
    public void testFindFregFromURL_Ok() throws IOException, NotBuildedURLException {
        Reader r = new Reader("http://www.stihi-rus.ru/World/Shekspir/1.htm");
        String word="";
        try{
            word =  new String("Шекспир".getBytes("ISO-8859-1"),"UTF8");}
        catch (UnsupportedEncodingException e){
            System.out.println(e.getMessage());
        }
        int real = r.findFregFromURL().get(word);
        assertEquals(2,real);
    }
    @Test(expected = NotBuildedURLException.class)
    public void testConstuctor_NotBuildedURLException() throws IOException, NotBuildedURLException {
        Reader r = new Reader("jk");
        r.findFregFromURL();
    }
}