package util;

public class LinkedListStack<E extends Comparable<E>> implements Stack<E> {

    LinkedList<E> linkedList = new LinkedList<>();

    @Override
    public E pop() {
        return linkedList.remove(0);
    }

    @Override
    public void push(E item) {
        linkedList.add(0, item);
    }

    @Override
    public E peak() {
        return linkedList.get(0);
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public boolean removeAll() {
        linkedList.clear();
        return true;
    }
}
