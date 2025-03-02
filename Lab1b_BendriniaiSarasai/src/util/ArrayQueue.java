package util;

import java.util.ArrayList;
import java.util.List;

public class ArrayQueue<E> implements Queue<E> {

    int size = 10;
    List<E> list = new ArrayList<>(size);
    int front = -1;
    int rear = -1;

    public int size() {
        return size;
    }

    public int front() {
        return front;
    }

    public int rear() {
        return rear;
    }

    @Override
    public void enqueue(E item) {
        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            resize();
        }

        if (rear == size - 1 && front != 0) {
            rear = -1;
        }

        rear++;

        if (rear < list.size()) {
            list.set(rear, item);
        }
        else {
            list.add(item);
        }

        if (front == -1){
            front = 0;
        }
    }

    @Override
    public E dequeue() {
        E item = null;

        if (isEmpty()) {
            return item;
        }

        if (front == rear || front == size - 1) {
            if (front == rear) {
                item = list.get(front);
                rear = -1;
                front = -1;
            }

            if (front == size - 1) {
                item = list.get(size - 1);
                front = 0;
            }
        }
        else {
            item = list.get(front);
            front++;
        }

        return item;
    }

    @Override
    public E peak() {
        if (!isEmpty()) {
            return list.get(front);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty() || front == -1 || list.get(front) == null;
    }

    private void resize() {
        int newSize = size * 2;
        List<E> newList = new ArrayList<>(newSize);
        int index = front;

        for (int i = 0; i < size; i++) {
            newList.add(list.get(index));
            index = (index + 1) % size;
        }

        front = 0;
        rear = size - 1;
        list = newList;
        size = newSize;
    }
}
