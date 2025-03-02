package util;

import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E>{

    ArrayList<E> list = new ArrayList<>();

    @Override
    public E pop() {
        if (!isEmpty()){
            return list.remove(list.size() - 1);
        }
        return null;
    }

    @Override
    public void push(E item) {
        list.add(item);
    }

    @Override
    public E peak() {
        if (!isEmpty()) {
            return list.get(list.size() - 1);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
