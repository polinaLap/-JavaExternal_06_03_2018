package javacourses;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }
    public Text read() throws IOException {
        Text res = new Text(new ArrayList<Sentence>());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        SentenceMember curToken = new Word(new ArrayList<Symbol>());
        Sentence curSentense = new Sentence(new ArrayList<SentenceMember>());
        int symbol = bufferedReader.read();
        while (symbol != -1) {
            if(Delimeter.isDelimeter((char)symbol)){
                if(!curToken.isEmpty()){
                    curSentense.addToken(curToken);
                }
                curToken = new Word(new ArrayList<Symbol>());
            }
            else if (Mark.isMark((char)symbol)){
                if(!curToken.isEmpty()){
                    curSentense.addToken(curToken);

                }
                if(Mark.isEndOfSentenceSymbol((char)symbol)){
                    curSentense.addToken(new Mark((char)symbol));
                    curToken= new Word(new ArrayList<Symbol>());
                    res.addSentence(curSentense);
                    curSentense = new Sentence(new ArrayList<SentenceMember>());
                }
                else curToken = new Mark((char)symbol);

            }
            else if(Symbol.isSymbol((char)symbol)){
                if(curToken instanceof Mark) {
                    curSentense.addToken(curToken);
                    curToken = new Word(new ArrayList<Symbol>());
                }
                ((Word)curToken).addLetter(new Symbol((char)symbol));
            }
            symbol = bufferedReader.read();
        }
        return res;
    }
}
