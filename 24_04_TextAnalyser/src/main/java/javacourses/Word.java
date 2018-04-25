package javacourses;

import java.util.List;

public class Word implements SentenceMember {
    private List<Symbol> word;

    public Word(List<Symbol> word) {
        this.word = word;
    }
    public static boolean isWord(List<Character> word){
        boolean res = true;
        for (int i = 0; i <word.size(); i++) {
            if(!Character.isLetter(word.get(i))){res =false; break;}
        }
        return res;
    }
    public void addLetter(Symbol c){
        word.add(c);
    }

    @Override
    public boolean isEmpty() {
        return word.isEmpty();
    }

    @Override
    public String toString() {
        String res="";
        for (int i = 0; i < word.size(); i++) {
            res+=word.get(i);
        }
        return res;
    }

    public boolean startWithConsonant(){
        return !isEmpty()&&!word.get(0).isVowel();
    }
    public int length(){
        return word.size();
    }
}
