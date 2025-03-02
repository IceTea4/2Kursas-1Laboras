import com.ktu.Car;
import org.junit.Test;
import util.LinkedListQueue;

import static org.junit.Assert.*;

public class LinkedListQueueTest {

    @Test
    public void testEnqueue_NoAdds() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueue_TwoElements() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");

        assertEquals("first", queue.peak());
    }

    @Test
    public void testEnqueue_FourElements() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("fourth");
        queue.enqueue("third");
        queue.enqueue("second");
        queue.enqueue("first");

        assertEquals("fourth", queue.peak());
    }

    @Test
    public void testDequeue_EmptyList() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertNull(queue.dequeue());
    }

    @Test
    public void testDequeue_OneElement() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("element");

        assertEquals("element", queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeue_OneOfThreeElements() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals("first", queue.dequeue());
        assertEquals("second", queue.peak());
    }

    @Test
    public void testDequeue_MultipleRemoves() {
        LinkedListQueue<Car> queue = new LinkedListQueue<>();
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
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertNull(queue.peak());
    }

    @Test
    public void testPeak_OneElement() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("element");
        assertEquals("element", queue.peak());
    }

    @Test
    public void testPeak_ThreeElements() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");

        assertEquals("first", queue.peak());
    }

    @Test
    public void testIsEmpty_EmptyList() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsEmpty_OneElement() {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.enqueue("element");
        assertFalse(queue.isEmpty());
    }
}
