package javacourses;

import java.util.ArrayList;

public class Walker {
    private Labirint labirint;
    private PositionStack stack;

    public Walker(Labirint labirint) throws NullPointerException {
        if(labirint==null) throw new NullPointerException("Labirint is not exist!");
        else this.labirint = labirint;
        stack= new PositionStack(labirint.size());
    }
    public PositionStack findWay(){
        labirint.setVisited(labirint.getStart());
        stack.push(labirint.getStart());
        while (!stack.isEmpty()&&!stack.peek().equals(labirint.getFinish())){
            Position cur = searchVariant(stack.peek());
            if(cur==null) stack.pop();
            else{
                labirint.setVisited(cur);
                stack.push(cur);

            }
        }
        return stack;
    }
    private Position searchVariant(Position cur){
        Position res=null;
        ArrayList<Position> variants = labirint.neighbours(cur);
        if(!variants.isEmpty()) res = variants.get(0);
        return res;
    }

    public PositionStack getStack() {
        return stack;
    }
}
