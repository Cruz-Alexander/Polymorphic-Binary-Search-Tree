Here's the code without line numbers:

```java
package tests;

import java.util.NoSuchElementException;
import org.junit.Test;
import tree.PlaceKeysValuesInArrayLists;
import tree.PolymorphicBST;
import junit.framework.TestCase;

public class StudentTests extends TestCase {

    @Test
    public void testInsertionAndRemoval() {
        PolymorphicBST<String, Integer> tree = new PolymorphicBST<String, Integer>();
        assertEquals(0, tree.size());
        tree.put("John", 25);
        tree.put("Alice", 30);
        tree.put("Bob", 40);
        tree.put("Mary", 35);
        assertEquals(4, tree.size());
        assertEquals(25, (int) tree.get("John"));
        assertEquals(30, (int) tree.get("Alice"));
        assertEquals(40, (int) tree.get("Bob"));
        assertEquals(35, (int) tree.get("Mary"));
        tree.remove("Alice");
        tree.remove("Mary");
        assertEquals(2, tree.size());
        assertEquals(25, (int) tree.get("John"));
        assertEquals(null, tree.get("Alice"));
        assertEquals(40, (int) tree.get("Bob"));
        assertEquals(null, tree.get("Mary"));
    }

    @Test
    public void testMinAndMax() {
        PolymorphicBST<Character, Integer> tree = new PolymorphicBST<Character, Integer>();
        assertEquals(0, tree.size());
        try {
            assertEquals(null, tree.getMin());
            fail("Should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
            assert true; // as intended
        }
        try {
            assertEquals(null, tree.getMax());
            fail("Should have thrown NoSuchElementException");
        } catch (NoSuchElementException e) {
            assert true; // as intended
        }
        tree.put('D', 4);
        tree.put('B', 2);
        tree.put('F', 6);
        tree.put('A', 1);
        tree.put('C', 3);
        tree.put('E', 5);
        tree.put('G', 7);
        assertEquals(7, tree.size());
        assertEquals('A', (char) tree.getMin());
        assertEquals('G', (char) tree.getMax());
        tree.remove('A');
        tree.remove('G');
        assertEquals(5, tree.size());
        assertEquals('B', (char) tree.getMin());
        assertEquals('F', (char) tree.getMax());
    }

    @Test
    public void testSubMap() {
        PolymorphicBST<String, Integer> tree = new PolymorphicBST<String, Integer>();
        tree.put("Apple", 10);
        tree.put("Banana", 20);
        tree.put("Cherry", 30);
        tree.put("Grape", 40);
        tree.put("Orange", 50);
        tree.put("Pineapple", 60);
        tree.put("Watermelon", 70);
        assertEquals(7, tree.size());
        PolymorphicBST<String, Integer> subMap = tree.subMap("Banana", "Pineapple");
        assertEquals(5, subMap.size());
        assertEquals(20, (int) subMap.get("Banana"));
        assertEquals(30, (int) subMap.get("Cherry"));
        assertEquals(40, (int) subMap.get("Grape"));
        assertEquals(50, (int) subMap.get("Orange"));
        assertEquals(null, subMap.get("Apple"));
        assertEquals(60, (int) subMap.get("Pineapple"));
        assertEquals(null, subMap.get("Watermelon"));
    }

    @Test
    public void testKeysValuesArrayLists() {
        PolymorphicBST<Integer, String> tree = new PolymorphicBST<Integer, String>();
        tree.put(5, "Five");
        tree.put(2, "Two");
        tree.put(8, "Eight");
        tree.put(1, "One");
        tree.put(4, "Four");
        tree.put(7, "Seven");
        tree.put(9, "Nine");
        assertEquals(7, tree.size());
        PlaceKeysValuesInArrayLists<Integer, String> task = new PlaceKeysValuesInArrayLists<Integer, String>();
        tree.inorderTraversal(task);
        assertEquals("[1, 2, 4, 5, 7, 8, 9]", task.getKeys().toString());
        assertEquals("[One, Two, Four, Five, Seven, Eight, Nine]", task.getValues().toString());
    }
}
