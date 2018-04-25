package javacourses;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Text text =null;
        Reader r = new Reader("text1.txt");
        try{
            text = r.read();}
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(text);
        text.deleteWords(4,true);
        System.out.println(text);
    }
}
