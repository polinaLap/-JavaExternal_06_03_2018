package javacourses;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ReaderTest {

    @Test(expected = IOException.class)
    public void testRead_IOexception() throws IOException {
        Reader r = new Reader("notExistedFile.txt");
        r.read();
    }
    @Test
    public void testRead_compareWords() throws IOException {
        Reader r = new Reader("text1.txt");
        Text text = r.read();
        assertEquals("Factory",text.get(0).get(0).toString());
    }
    @Test
    public void testRead_compareMark() throws IOException {
        Reader r = new Reader("text1.txt");
        Text text = r.read();
        assertEquals(".",text.get(0).get(12).toString());
    }
}