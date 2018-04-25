package javacourses;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private List<Sentence> text;

    public Text(List<Sentence> text) {
        this.text = text;
    }
    public void addSentence(Sentence sent){
        text.add(sent);
    }
    public Sentence get(int i){
        return text.get(i);
    }

    @Override
    public String toString() {
        String res ="";
        for (int i = 0; i < text.size(); i++) {
            res+=text.get(i)+"\n";
        }
        return res;
    }
    public void deleteWords(int length, boolean startConsonant){
        for (Sentence sentence: text){
            sentence.deleteWord(length,startConsonant);
        }
    }
}
