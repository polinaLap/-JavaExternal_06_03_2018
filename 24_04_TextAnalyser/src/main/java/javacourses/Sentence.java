package javacourses;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private List<SentenceMember> tokens;

    public Sentence(List<SentenceMember> tokens) {
        this.tokens = tokens;
    }
    public void addToken(SentenceMember token){
        tokens.add(token);
    }

    public SentenceMember get(int i){
        if(i>=tokens.size()) return null;
        return tokens.get(i);
    }
    @Override
    public String toString() {
        String res ="";
        for (int i = 0; i < tokens.size(); i++) {
            res+=tokens.get(i)+" ";
        }
        return res;
    }
    public int size(){
        return tokens.size();
    }
    public void deleteWord(int length, boolean startConsonant){
        List<Word> res = new ArrayList<>();
        for (int i = 0; i < tokens.size() ; i++) {
            SentenceMember token =tokens.get(i);
            if(!token.isEmpty()&&token instanceof Word&&
                    ((Word)token).length()==length&&(((Word)token).startWithConsonant()==startConsonant)){
                tokens.remove(i);
                i--;
            }
        }
    }
}
