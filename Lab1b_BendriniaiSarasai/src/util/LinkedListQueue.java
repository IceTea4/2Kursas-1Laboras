package util;

import sun.awt.image.ImageWatched;
import util.LinkedList;

public class LinkedListQueue<E extends Comparable<E>> implements Queue<E> {

    LinkedList<E> list = new LinkedList<>();

    @Override
    public void enqueue(E item) {
        list.add(item);
    }

    @Override
    public E dequeue() {
        return list.remove(0);
    }

    @Override
    public E peak() {
        return list.get(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
