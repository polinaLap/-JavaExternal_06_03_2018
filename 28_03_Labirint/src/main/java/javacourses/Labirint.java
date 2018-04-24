package javacourses;

import java.util.ArrayList;

public class Labirint {
    private int[][] firstMatrix;
    private int[][] matrix; //0 is open, 1 is closed
    private Position start;
    private Position finish;

    public Labirint(int[][] matrix, Position start,Position finish)throws NullPointerException,IndexOutOfBoundsException {
        if(matrix==null) throw new NullPointerException("Matrix is not created!");
        if(start==null||finish==null) throw new NullPointerException("Start/finish is null");
        this.firstMatrix= matrix;
        this.matrix =matrix.clone();
        checkPosition(start);
        checkPosition(finish);
        this.start=start;
        this.finish=finish;
    }
    public int size(){
        return matrix.length*matrix.length;
    }
    public boolean isOpenPosition(int i, int j){
        if(i<0||j<0||i>matrix.length-1||j>matrix.length-1)return false;
        if(matrix[i][j]==0) return true;
        return false;
    }

    public void setVisited(Position pos)throws IndexOutOfBoundsException{
        checkPosition(pos);
        matrix[pos.getI()][pos.getJ()]=-1;
    }
    private void checkPosition(Position pos) throws IndexOutOfBoundsException {
        if(pos.getI()>=matrix.length||pos.getJ()>=matrix.length)
            throw  new IndexOutOfBoundsException("Matrix doesn't have this position: ("+pos.getI()+","+pos.getJ()+").");
    }

    public ArrayList<Position> neighbours(Position pos)throws IndexOutOfBoundsException{
        checkPosition(pos);
        ArrayList<Position> res = new ArrayList<Position>();
        if(isOpenPosition(pos.getI()-1,pos.getJ())) res.add(new Position(pos.getI()-1,pos.getJ()));
        if(isOpenPosition(pos.getI(),pos.getJ()-1)) res.add(new Position(pos.getI(),pos.getJ()-1));
        if(isOpenPosition(pos.getI()+1,pos.getJ())) res.add(new Position(pos.getI()+1,pos.getJ()));
        if(isOpenPosition(pos.getI(),pos.getJ()+1)) res.add(new Position(pos.getI(),pos.getJ()+1));
        return res;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Labirint:\n");
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix.length; j++) {
                res.append(firstMatrix[i][j]+" ");
            }
            res.append("\n");
        }
        return res.toString();
    }

    public Position getStart() {
        return start;
    }

    public Position getFinish() {
        return finish;
    }
}
