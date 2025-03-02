import com.ktu.Car;
import org.junit.Test;
import util.ArrayStack;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void testPop_EmptyList() {
        ArrayStack<String> stack = new ArrayStack<>();
        assertNull(stack.pop());
    }

    @Test
    public void testPop_OneElement() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("element");
        assertEquals("element", stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPop_OneOfThreeElements() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.pop());
    }

    @Test
    public void testPop_MultipleRemoves() {
        ArrayStack<Car> stack = new ArrayStack<>();
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
        ArrayStack<String> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPush_TwoElement() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());
    }

    @Test
    public void testPush_FourElements() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());

        stack.push("fourth");

        assertEquals("fourth", stack.peak());
    }

    @Test
    public void testPeak_EmptyList() {
        ArrayStack<String> stack = new ArrayStack<>();
        assertNull(stack.peak());
    }

    @Test
    public void testPeak_OneElement() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("element");
        assertEquals("element", stack.peak());
    }

    @Test
    public void testPeak_ThreeElements() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("third");
        stack.push("second");
        stack.push("first");

        assertEquals("first", stack.peak());
    }

    @Test
    public void testIsEmpty_EmptyList() {
        ArrayStack<String> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsEmpty_OneElement() {
        ArrayStack<String> stack = new ArrayStack<>();
        stack.push("element");
        assertFalse(stack.isEmpty());
    }
}
