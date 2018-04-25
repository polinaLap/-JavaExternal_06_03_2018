package javacourses;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SentenceTest {
    private  Sentence sent;
    @Before
    public void initSent1(){
        sent = new Sentence(new ArrayList<SentenceMember>());
        Word word1 = mock(Word.class);
        when(word1.startWithConsonant()).thenReturn(true);
        when(word1.length()).thenReturn(5);
        Word word2 = mock(Word.class);
        when(word2.startWithConsonant()).thenReturn(false);
        when(word2.length()).thenReturn(6);
        Mark mark = new Mark('.');
        sent.addToken(word1);
        sent.addToken(word2);
        sent.addToken(mark);
    }
    @Test
    public void testDeleteWord_startWithCons() {
        initSent1();
        sent.deleteWord(5,true);
        assertEquals(6,((Word)sent.get(0)).length());
    }
    @Test
    public void testDeleteWord_startWithVowel() {
        initSent1();
        sent.deleteWord(6,false);
        assertEquals(5,((Word)sent.get(0)).length());
        assertTrue(sent.get(1) instanceof Mark);
    }
    @Test
    public void testDeleteWord_noSuchWord() {
        initSent1();
        sent.deleteWord(7,true);
        assertEquals(3,sent.size());
    }
}