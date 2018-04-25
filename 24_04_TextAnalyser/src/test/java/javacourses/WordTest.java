package javacourses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void testIsWord_ok() {
        List<Character> word = new ArrayList<>();
        word.add('t');
        word.add('e');
        word.add('s');
        word.add('t');
        assertTrue(Word.isWord(word));
    }
    @Test
    public void testIsWord_hasFigure_notOk() {
        List<Character> word = new ArrayList<>();
        word.add('t');
        word.add('e');
        word.add('s');
        word.add('2');
        assertFalse(Word.isWord(word));
    }
    @Test
    public void testIsWord_hasDelimiter_notOk() {
        List<Character> word = new ArrayList<>();
        word.add('t');
        word.add('e');
        word.add(' ');
        word.add('t');
        assertFalse(Word.isWord(word));
    }

    @Test
    public void startWithConsonant_true() {
        List<Symbol> list = new ArrayList<>();
        list.add(new Symbol('t'));
        list.add(new Symbol('e'));
        list.add(new Symbol('s'));
        list.add(new Symbol('t'));
        Word word = new Word(list);
        assertTrue(word.startWithConsonant());
    }
    @Test
    public void startWithConsonant_false() {
        List<Symbol> list = new ArrayList<>();
        list.add(new Symbol('a'));
        list.add(new Symbol('e'));
        list.add(new Symbol('s'));
        list.add(new Symbol('t'));
        Word word = new Word(list);
        assertFalse(word.startWithConsonant());
    }
}