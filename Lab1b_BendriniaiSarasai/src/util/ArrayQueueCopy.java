package util;

public class ArrayQueueCopy<E> implements Queue<E> {

    Object[] array;
    int front = -1;
    int rear = -1;

    public ArrayQueueCopy() {
        this(10);
    }

    public ArrayQueueCopy(int size) {
        this.array = new Object[size];
    }

    public int size() {
        return array.length;
    }

    public int front() {
        return front;
    }

    public int rear() {
        return rear;
    }

    @Override
    public void enqueue(E item) {
        if ((front == 0 && rear == array.length - 1) || (rear == (front - 1) % (array.length - 1))) {
            resize();
        }

        if (rear == array.length - 1 && front != 0) {
            rear = -1;
        }

        rear++;

        array[rear] = item;

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

        item = (E) array[front];

        if (front == rear) {
            rear = -1;
            front = -1;
        } else if (front == array.length - 1) {
            front = 0;
        } else {
            front++;
        }

        return item;
    }

    @Override
    public E peak() {
        return isEmpty() ? null : (E) array[front];
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    private void resize() {
        int newSize = array.length * 2;
        Object[] newArray = new Object[newSize];

        int index = front;

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[index];
            index = (index + 1) % array.length;
        }

        front = 0;
        rear = array.length - 1;
        array = newArray;
    }
}
