package javacourses;

public class Delimeter {
    public static boolean isDelimeter(char c){
        return !Symbol.isSymbol(c)&&!Mark.isMark(c);
    }
}
