import com.ktu.Car;
import org.junit.Test;
import util.LinkedListStack;

import static org.junit.Assert.*;

public class LinkedListStackTest {

    @Test
    public void testPop_EmptyList() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void testPop_OneElement() {
        LinkedListStack<Car> stack = new LinkedListStack<>();
        Car one = new Car("Renault Laguna 2001 115900 7500");
        stack.push(one);
        assertEquals(one, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPop_OneOfThreeElements() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.pop());
    }

    @Test
    public void testPop_MultipleRemoves() {
        LinkedListStack<Car> stack = new LinkedListStack<>();
        Car third = new Car("Renault Laguna 2001 115900 7500");
        Car second = new Car("Pezas Laguna 2001 115900 7500");
        Car first = new Car("Bembelis Laguna 2001 115900 7500");

        stack.push(third);
        stack.push(second);
        stack.push(first);

        assertEquals(first, stack.pop());
        assertEquals(second, stack.pop());
        assertFalse(stack.isEmpty());
        assertEquals(third, stack.pop());
        assertNull(stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush_NoAdds() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush_TwoElement() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());
    }

    @Test
    public void testPush_FourElements() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());

        stack.push("fourth");

        assertEquals("fourth", stack.peak());
    }

    @Test
    public void testPeak_EmptyList() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertNull(stack.peak());
    }

    @Test
    public void testPeak_OneElement() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("element");
        assertEquals("element", stack.peak());
    }

    @Test
    public void testPeak_ThreeElements() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());
    }

    @Test
    public void testIsEmpty_EmptyList() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_OneElement() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("element");
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testRemoveAll() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");

        stack.removeAll();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testRemoveAll_EmptyList() {
        LinkedListStack<String> stack = new LinkedListStack<>();
        stack.removeAll();
        assertTrue(stack.isEmpty());
    }
}
