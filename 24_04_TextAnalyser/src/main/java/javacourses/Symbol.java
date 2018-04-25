package javacourses;

public class Symbol {
    private char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;
    }
    public static boolean isSymbol(char symbol){
        if(Character.isLetterOrDigit(symbol)) return true;
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
    public boolean isVowel(){
        String vowels ="aeiouAEIOU";
        return vowels.contains(String.valueOf(symbol));
    }
}
