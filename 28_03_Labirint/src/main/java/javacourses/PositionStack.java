package javacourses;

import java.util.Arrays;

public class PositionStack {
    private int maxSize;
    private Position[] stackArray;
    private int top;


    public PositionStack(int maxSize) {
        this.maxSize = maxSize;
        stackArray=new Position[maxSize];
        top=-1;
    }
    public void push (Position pos){
        stackArray[++top]=pos;
    }
    public Position pop(){
        return stackArray[top--];
    }
    public Position peek() {
        return stackArray[top];
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public int size(){
        return top+1;
    }

    @Override
    public String toString() {
        StringBuilder res= new StringBuilder("PositionStack:\n");
        if(isEmpty()) res.append("Stack is empty\n");
        else for (int i = 0; i <= top; i++) {
            res.append(stackArray[i]+" ");
        }
        return res.toString();
    }
}
