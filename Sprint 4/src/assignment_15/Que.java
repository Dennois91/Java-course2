package assignment_15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Que<T extends Number> implements QueInter<T> {

    private List<T> innerList = new LinkedList<>();

    public Que() {

    }

    @Override
    public void put(T t) {
        innerList.add(t);

    }

    @Override
    public T take() {
        T temp = innerList.get(0);
        innerList.remove(0);
        return temp;
    }

    @Override
    public int size() {
        return innerList.size();
    }
    public int summarize(){
        var temp = 0;
        for (T t: innerList){
            temp = temp + (int) t;
        }
        return temp;
    }
}
