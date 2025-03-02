import org.junit.Test;
import util.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void testAdd_Empty() {
        LinkedList<String> list = new LinkedList<>();

        // checks the situations where nothing should be added
        assertFalse(list.add(0, null));
        assertFalse(list.add(-1, "test"));
        assertFalse(list.add(4, "test"));
    }

    @Test
    public void testAdd_TwoElements() {
        LinkedList<String> list = new LinkedList<>();

        // adds two elements to the front of the list: { second; first }
        assertTrue(list.add(0, "first"));
        list.add(0, "second");
        assertEquals("second", list.get(0));
        assertEquals("first", list.get(1));
    }

    @Test
    public void testAdd_FourElements() {
        LinkedList<String> list = new LinkedList<>();

        // adds two elements to the front of the list: { second; first }
        assertTrue(list.add(0, "first"));
        list.add(0, "second");
        assertEquals("second", list.get(0));
        assertEquals("first", list.get(1));

        // adds another two elements to the middle of the list: { second; third; fourth; first }
        list.add(1, "third");
        list.add(2, "fourth");
        assertEquals("third", list.get(1));
        assertEquals("fourth", list.get(2));

        // list size should be 4
        assertEquals(4, list.size());

        // once again checks if nothing is added in this situation
        assertFalse(list.add(4, "fifth"));
    }

    @Test
    public void testSet_EmptyList() {
        LinkedList<String> list = new LinkedList<>();

        // tries to change elements when the list is empty
        assertNull(list.set(0, "changed"));
    }

    @Test
    public void testSet_NoChangePossibleInList() {
        LinkedList<String> list = new LinkedList<>();

        // makes a list: { first; second; third }
        list.add("first");
        list.add("second");
        list.add("third");

        // checks the situations where nothing should be changed
        assertNull(list.set(0, null));
        assertNull(list.set(-1, "changed"));
        assertNull(list.set(3, "changed"));
    }

    @Test
    public void testSet_ChangesTwoElements() {
        LinkedList<String> list = new LinkedList<>();

        // makes a list: { first; second; third }
        list.add("first");
        list.add("second");
        list.add("third");

        // makes changes
        // element with index 0 will be returned and changed into "changeOne"
        // element with index 2 will be returned and changed into "changeTwo"
        assertEquals("first", list.set(0, "changeOne"));
        assertEquals("third", list.set(2, "changeTwo"));
        assertEquals("changeOne", list.get(0));
        assertEquals("second", list.get(1));
        assertEquals("changeTwo", list.get(2));
    }

    @Test
    public void testRemove_EmptyList() {
        LinkedList<String> list = new LinkedList<>();

        assertNull(list.remove(0));
        assertNull(list.remove(-1));
        assertNull(list.remove(3));
    }

    @Test
    public void testRemove_WrongIndex() {
        LinkedList<String> list = new LinkedList<>();

        list.add("first");

        assertNull(list.remove(-1));
        assertNull(list.remove(2));
    }

    @Test
    public void testRemove_OneElement() {
        LinkedList<String> list = new LinkedList<>();

        list.add("first");

        assertEquals("first", list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    public void testRemove_OneOfThreeElements() {
        LinkedList<String> list = new LinkedList<>();

        list.add("first");
        list.add("second");
        list.add("third");

        assertEquals("second", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_MultipleRemoves() {
        LinkedList<String> list = new LinkedList<>();

        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        assertEquals("fourth", list.remove(3));
        assertEquals("second", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove1_EmptyList() {
        LinkedList<String> list = new LinkedList<>();
        Iterator<String> iterator = list.iterator();

        // throws exception when removing element from the empty list
        assertThrows(NoSuchElementException.class, iterator::remove);
    }

    @Test
    public void testRemove1_OneElement() {
        LinkedList<String> list = new LinkedList<>();

        // adds element to the list and moves iterator to it
        // removes the element
        list.add("first");
        Iterator<String> iterator = list.iterator();

        iterator.next();
        iterator.remove();

        // checks if the only element in the list was removed
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemove1_OneOfThreeElements() {
        LinkedList<String> list = new LinkedList<>();

        // forms a list with three elements
        // moves iterator to the first one and removes it
        list.add("first");
        list.add("second");
        list.add("third");
        Iterator<String> iterator = list.iterator();

        iterator.next();
        iterator.remove();

        // checks if removal was done correctly
        assertEquals(2, list.size());
        assertEquals("second", list.get(0));
        assertEquals("third", list.get(1));
    }

    @Test
    public void testRemove1_MultipleRemoves() {
        LinkedList<String> list = new LinkedList<>();

        // forms a list with three elements
        // moves iterator to the first one and removes it
        list.add("first");
        list.add("second");
        list.add("third");
        Iterator<String> iterator = list.iterator();

        iterator.next();
        iterator.remove();

        // checks if removal was done correctly
        assertEquals(2, list.size());
        assertEquals("second", list.get(0));
        assertEquals("third", list.get(1));

        // moves iterator to other element and removes it
        iterator.next();
        iterator.remove();

        // checks the results again
        assertEquals(1, list.size());
        assertEquals("third", list.get(0));
    }
}
