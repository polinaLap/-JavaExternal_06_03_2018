package javacourses;

public class App 
{
    public static void main( String[] args )
    {
       int [][] arr = {{0,0,1,1},{1,0,0,1},{1,0,0,1},{1,1,0,0}};
       Labirint lab = new Labirint(arr,new Position(0,0), new Position(3,3));
        System.out.println(lab);
       Walker w = new Walker(lab);
       System.out.println(w.findWay());
    }


}
