package the.best;

import java.util.ArrayDeque;
import java.util.Deque;

public class Caretaker {
    Deque<Board.Memento> stack;
    Board originator;

    public Caretaker(Board originator){
        this.originator = originator;
        stack = new ArrayDeque<>();
    }

    public void push(Board.Memento memento){
        stack.push(memento);
    }

    public Board.Memento pop(){
        if(stack.isEmpty()){
            return null;
        }
        return stack.pop();
    }

    public int size(){
        return stack.size();
    }
}
