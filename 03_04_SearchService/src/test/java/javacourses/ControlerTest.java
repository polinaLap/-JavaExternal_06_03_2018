package javacourses;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControlerTest {

    Reader r;
    @Before
    public void initMockReader() throws IOException, NotBuildedURLException {
        r = mock(Reader.class);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("str1",1);
        map.put("str2",2);
        map.put("str3",2);
        map.put("str4",3);
        map.put("str5",5);
        when(r.findFregFromURL()).thenReturn(map);
        ArrayList<String> refs = new ArrayList<String>();
        when(r.getRefs()).thenReturn(refs);
        when(r.getSource()).thenReturn("ref");
    }
    @Test
    public void testFormMap_Word_Sites_withoutNewRefs() throws IOException, NotBuildedURLException {
        initMockReader();
      Controler c = new Controler(r);
      c.formMap_Word_Sites();
      assertTrue(c.getWords().get("str5").contains("ref"));
    }

    @Test
    public void testSearch_ok() throws NotBuildedURLException, IOException {
        initMockReader();
        Controler c = new Controler(r);
        c.formMap_Word_Sites();
        assertTrue(c.search("str1").contains("ref"));
    }
    @Test
    public void testSearch_mapIsEmpty() throws NotBuildedURLException, IOException {
        initMockReader();
        Controler c = new Controler(r);
        assertNull(c.search("str1"));
    }
    @Test
    public void testFindTopWords_ok() throws IOException, NotBuildedURLException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("str1",2);
        map.put("str2",4);
        map.put("str3",4);
        map.put("str4",5);
        assertEquals("str4",Controler.findTopWords(map).get(0));
    }

}