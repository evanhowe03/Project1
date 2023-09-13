/**
 * 
 */


/**
 * @author Pallavi Chavan pallucha21
 * @version 11/16/22
 */
public class SinglyLinkedListTest extends student.TestCase {

    private String nullObject;
    private SinglyLinkedList<String> list1;

    /**
     * setUp() method
     */
    public void setUp() {
        nullObject = null;
        list1 = new SinglyLinkedList<String>();
        list1.add("a");
    }


    /**
     * testSize() method
     */
    public void testSize() {
        assertEquals(1, list1.size());
        list1.add("b");
        list1.add("c");
        assertEquals(3, list1.size());
        list1.remove("c");
        assertEquals(2, list1.size());
        list1.remove("b");
        assertEquals(1, list1.size());
    }


    /**
     * tests add() method
     */
    public void testAdd() {
        
        Exception thrown = null;
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        try {
            list.add(nullObject);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        

        try {
            list.add(0, nullObject);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        

        Exception thrown2 = null;
        try {
            list1.add(-1, "b");
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);
        
        

        try {
            list1.add(6, "a");
        }
        catch (Exception exception) {
            thrown2 = exception;
        }
        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);

        list.add(0, "c");
        assertEquals(list.get(0), "c");
        list.add(0, "d");
        assertEquals(list.get(0), "d");
        list.add(1, "c");
        assertEquals("c", list.get(1));

    }


    /**
     * testRemoveObject() method
     */
    public void testRemoveObject() {
        assertTrue(list1.remove("a"));
        assertFalse(list1.contains("a"));
        assertEquals(0, list1.size());
        assertFalse(list1.remove(""));
        list1.add("a");
        list1.add("b");
        list1.add("c");
        assertTrue(list1.remove("a"));
        assertTrue(list1.remove("b"));
        assertTrue(list1.remove("c"));

    }


    /**
     * testRemoveIndex() method
     */
    public void testRemoveIndex() {
        Exception thrown = null;
        try {
            list1.remove(-1);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertTrue(list1.remove(0));

        list1.add(0, "b");
        list1.add(1, "c");
        list1.add(2, "d");
        assertTrue(list1.remove(2));
        assertTrue(list1.remove(1));

        list1.clear();
        try {
            list1.remove(0);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
        list1.add(0, "item");
        try {
            list1.remove(20);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * testGet() method
     */
    public void testGet() {
        Exception thrown = null;
        SinglyLinkedList<String> list = new SinglyLinkedList<String>();
        try {
            list.get(0);
        }
        catch (Exception exception) {
            thrown = exception;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);
    }


    /**
     * testContains() method
     */
    public void testContains() {
        assertTrue(list1.contains("a"));
        list1.add("b");
        list1.add("c");
        assertTrue(list1.contains("b"));
    }


    /**
     * testClear() method
     */
    public void testClear() {
        list1.add("b");
        list1.add("c");
        list1.add("c");
        assertEquals(list1.size(), 4);
        list1.clear();
        assertEquals(list1.size(), 0);
        list1.clear();
    }


    /**
     * testIndexOf() method
     */
    public void testIndexOf() {
        list1.add("b");
        list1.add("c");
        list1.add("d");
        assertEquals(list1.lastIndexOf("b"), 1);
    }


    /**
     * testToString() method
     */
    public void testToString() {
        list1.add("b");
        list1.add("c");
        assertEquals(list1.toString(), "{a, b, c}");
        list1.remove(2);
        list1.add("d");
        list1.add("e");
        list1.add("f");
        assertEquals(list1.toString(), "{a, b, d, e, f}");
    }

}
