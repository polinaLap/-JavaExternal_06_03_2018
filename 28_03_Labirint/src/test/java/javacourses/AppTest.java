package javacourses;


import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest extends org.junit.Assert
{
    @Test
    public void testPositionEqualsTrue(){
        Position p1 = new Position(1,1);
        Position p2 = new Position(1,1);
        boolean res = p1.equals(p2);
        assertTrue(res);
    }
    @Test
    public void testPositionEqualsFalse(){
        Position p1 = new Position(1,1);
        Position p2 = new Position(1,2);
        boolean res = p1.equals(p2);
        assertFalse(res);
    }
    @Test
    public void testPositionStackPushPop(){
        PositionStack stack = new PositionStack(2);
        stack.push(new Position(0,0));
        stack.push(new Position(1,1));
        Position res = stack.pop();
        Position exp = new Position(1,1);
        assertEquals(exp,res);
    }
    @Test
    public void testPositionStackPushPeek(){
        PositionStack stack = new PositionStack(2);
        stack.push(new Position(0,0));
        stack.push(new Position(1,1));
        int resSize=stack.size();
        assertEquals(2,resSize);
    }
    @Test
    public void testPositionStackIsEmpty(){
        PositionStack stack = new PositionStack(1);
        stack.push(new Position(0,0));
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testLabirintCheckPosition() throws IndexOutOfBoundsException{
        int [][] arr = {{0,0},{1,0}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(3,3));
    }
    @Test
    public void testLabirintIsOpenPosition(){
        int [][] arr = {{0,0},{1,0}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(1,1));
        lab.setVisited(new Position(0,0));
        boolean notVisited = lab.isOpenPosition(0,0);
        assertFalse(notVisited);
    }
    @Test
    public void testLabirintNeighbours(){
        int [][] arr = {{0,1},{0,0}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(1,1));
        ArrayList<Position>  neib = lab.neighbours(new Position(0,0));
        int expCount =1;
        int count = neib.size();
        assertEquals(expCount,count);
        Position expPos = new Position(1,0);
        Position pos = neib.get(0);
        assertEquals(expPos,pos);

    }
    @Test(expected = NullPointerException.class)
    public void testLabirint_nullMatrix(){
        Labirint lab = new Labirint(null,new Position(0,0), new Position(1,1));
    }
    @Test(expected = NullPointerException.class)
    public void testLabirint_nullStart(){
        int [][] arr = {{0,1},{0,0}};
        Labirint lab = new Labirint(arr,null, new Position(1,1));
    }
    @Test
    public void testWalker_hasExit(){
        int [][] arr = {{0,0,1,1},{1,0,0,1},{1,0,0,1},{1,1,0,0}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(3,3));
        Walker w = new Walker(lab);
        w.findWay();
        int count = w.getStack().size();
        int expCount = 7;
        assertEquals(expCount,count);
    }
    @Test
    public void testWalker_hasNoExit(){
        int [][] arr = {{0,0,1,1},{1,0,0,1},{1,1,1,1},{1,1,0,0}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(3,3));
        Walker w = new Walker(lab);
        w.findWay();
        int count = w.getStack().size();
        int expCount = 0;
        assertEquals(expCount,count);
    }
    @Test
    public void testWalker_hasCicleInLabirint(){
        int [][] arr = {{0,0,0,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}};
        Labirint lab = new Labirint(arr,new Position(0,0), new Position(3,3));
        Walker w = new Walker(lab);
        w.findWay();
        int count = w.getStack().size();
        int expCount = 0;
        assertEquals(expCount,count);
    }
    @Test(expected = NullPointerException.class)
    public void testWalker_nullLabirint(){
        int [][] arr = {{0,0,0,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}};
        Walker w = new Walker(null);
        w.findWay();
    }
}
