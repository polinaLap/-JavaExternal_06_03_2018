package javacourses;

import java.util.Scanner;
/**
 * Application class with main-method
 * Demonstrate work of class Controler
 * @autor Polly Lapteva
 */
public class App
{

    public static void main(String[] args) throws  NotBuildedURLException {
        Controler c = new Controler(new Reader("http://www.stihi-rus.ru/World/Shekspir/1.htm"));
        c.formMap_Word_Sites();
        Scanner in = new Scanner(System.in);
        String word = in.next();

        System.out.println(c.search(word));

    }
}
