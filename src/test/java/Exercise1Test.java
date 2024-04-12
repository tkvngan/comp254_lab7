import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Exercise1Test {

    @Test
    void testTreeSearch() {
        Exercise1<Integer, String> treeMap = new Exercise1<>();
        treeMap.put(6, "A");
        treeMap.put(2, "B");
        treeMap.put(4, "C");
        treeMap.put(1, "D");
        treeMap.put(9, "E");
        treeMap.put(8, "F");
        assertEquals("A", treeMap.get(6));
        assertEquals("B", treeMap.get(2));
        assertEquals("C", treeMap.get(4));
        assertEquals("D", treeMap.get(1));
        assertEquals("E", treeMap.get(9));
        assertEquals("F", treeMap.get(8));
        assertNull(treeMap.get(10)); // test with a key that does not exist in the tree
    }

    @Test
    void testTreeSearchWithEmptyTree() {
        Exercise1<Integer, String> emptyTreeMap = new Exercise1<>();
        assertNull(emptyTreeMap.get(1)); // test with an empty tree
    }

    @Test
    void testTreeSearchWithKeyLessThanSmallest() {
        Exercise1<Integer, String> treeMap = new Exercise1<>();
        treeMap.put(6, "A");
        treeMap.put(2, "B");
        treeMap.put(4, "C");
        treeMap.put(1, "D");
        treeMap.put(9, "E");
        treeMap.put(8, "F");
        assertNull(treeMap.get(0)); // test with a key that is less than the smallest key in the tree
    }

    @Test
    void testTreeSearchWithKeyGreaterThanLargest() {
        Exercise1<Integer, String> treeMap = new Exercise1<>();
        treeMap.put(6, "A");
        treeMap.put(2, "B");
        treeMap.put(4, "C");
        treeMap.put(1, "D");
        treeMap.put(9, "E");
        treeMap.put(8, "F");
        assertNull(treeMap.get(12)); // test with a key that is greater than the largest key in the tree
    }

    @Test
    void testTreeSearchWithSingleNode() {
        Exercise1<Integer, String> singleNodeTreeMap = new Exercise1<>();
        singleNodeTreeMap.put(1, "A");
        assertEquals("A", singleNodeTreeMap.get(1)); // test with a tree that has only one node
        assertNull(singleNodeTreeMap.get(2)); // test with a key that does not exist in the tree
    }

    @Test
    void testTreeSearchWithAllKeysSame() {
        Exercise1<Integer, String> allKeysSameTreeMap = new Exercise1<>();
        allKeysSameTreeMap.put(1, "A");
        allKeysSameTreeMap.put(1, "B");
        allKeysSameTreeMap.put(1, "C");
        assertEquals("C", allKeysSameTreeMap.get(1)); // test with a tree where all keys are the same
        assertNull(allKeysSameTreeMap.get(2)); // test with a key that does not exist in the tree
    }
}
