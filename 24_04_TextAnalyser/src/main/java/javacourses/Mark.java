package javacourses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Mark implements SentenceMember {
    private static Character[] possibleMarks = {',',';','!','.','?','/','{','}','(',')','[',']'};
    private char mark;

    public Mark(char mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }

    public static boolean isMark(char mark){
        List<Character> marks = Arrays.asList(possibleMarks);
        return marks.contains(mark);
    }
    public static boolean isEndOfSentenceSymbol(char c){
        return c=='.'||c=='!'||c=='?';
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}
