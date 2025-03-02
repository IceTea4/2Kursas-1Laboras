import com.ktu.Car;
import org.junit.Test;
import util.ArrayQueue;

import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void testEnqueue_NoAdds() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue_TwoElements() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");

        assertEquals("first", queue.peak());
        assertEquals(10, queue.size());
        assertEquals(0, queue.front());
        assertEquals(1, queue.rear());
    }

    @Test
    public void testEnqueue_FourElements() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("eleventh");
        queue.enqueue("tenth");
        queue.enqueue("ninth");
        queue.enqueue("eighth");
        queue.enqueue("seventh");
        queue.enqueue("sixth");
        queue.enqueue("fifth");
        queue.enqueue("fourth");
        queue.enqueue("third");
        queue.enqueue("second");
        queue.enqueue("first");

        assertEquals("eleventh", queue.peak());
        assertEquals(20, queue.size());
        assertEquals(0, queue.front());
        assertEquals(10, queue.rear());
    }

    @Test
    public void testDequeue_EmptyList() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertNull(queue.dequeue());
    }

    @Test
    public void testDequeue_OneElement() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("element");

        assertEquals("element", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeue_OneOfThreeElements() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.peak());
        assertEquals(1, queue.front());
        assertEquals(2, queue.rear());
    }

    @Test
    public void testDequeue_MultipleRemoves() {
        ArrayQueue<Car> queue = new ArrayQueue<>();
        Car fourth = new Car("Audine Laguna 2001 115900 7500");
        Car third = new Car("Renault Laguna 2001 115900 7500");
        Car second = new Car("Pezas Laguna 2001 115900 7500");
        Car first = new Car("Bembelis Laguna 2001 115900 7500");

        queue.enqueue(fourth);
        queue.enqueue(third);
        queue.enqueue(second);
        queue.enqueue(first);

        assertEquals(fourth, queue.dequeue());
        assertEquals(third, queue.dequeue());
        assertEquals(second, queue.dequeue());
        assertEquals(first, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPeak_EmptyList() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertNull(queue.peak());
    }

    @Test
    public void testPeak_OneElement() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("element");
        assertEquals("element", queue.peak());
    }

    @Test
    public void testPeak_ThreeElements() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals("first", queue.peak());
    }

    @Test
    public void testIsEmpty_EmptyList() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty_OneElement() {
        ArrayQueue<String> queue = new ArrayQueue<>();
        queue.enqueue("element");
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testEnqueue_Dequeue_FullList_Resize() {
        ArrayQueue<String> queue = new ArrayQueue<>();

        // full list front = 0, rear = 9
        queue.enqueue("eleventh");
        queue.enqueue("tenth");
        queue.enqueue("ninth");
        queue.enqueue("eighth");
        queue.enqueue("seventh");
        queue.enqueue("sixth");
        queue.enqueue("fifth");
        queue.enqueue("fourth");
        queue.enqueue("third");
        queue.enqueue("second");

        assertEquals(0, queue.front());
        assertEquals(9, queue.rear());

        // remove two first elements front = 2, rear = 9
        assertEquals("eleventh", queue.dequeue());
        assertEquals("tenth", queue.dequeue());

        // adds to the start front = 2, rear = 1, po minus enqueue bus resize
        queue.enqueue("first");
        queue.enqueue("zero");

        assertEquals(10, queue.size());
        assertEquals(2, queue.front());
        assertEquals(1, queue.rear());

        queue.enqueue("minus");

        assertEquals("ninth", queue.peak());
        assertEquals(20, queue.size());
        assertEquals(0, queue.front());
        assertEquals(10, queue.rear());
    }
}
