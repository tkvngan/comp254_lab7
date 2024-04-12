import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Exercise2Test {

    @Test
    void testMergeSort() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(53);
        queue.enqueue(8);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(46);

        Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        assertFalse(queue.isEmpty());
        assertEquals(5, queue.size());

        assertEquals(8, queue.dequeue());
        assertEquals(12, queue.dequeue());
        assertEquals(34, queue.dequeue());
        assertEquals(46, queue.dequeue());
        assertEquals(53, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testMergeSortWithEvenNumberOfElements() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(5);
        queue.enqueue(1);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);

        assertEquals(6, queue.size());

        Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        assertFalse(queue.isEmpty());
        assertEquals(6, queue.size());

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testMergeSortWithDuplicateElements() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(53);
        queue.enqueue(8);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(46);
        queue.enqueue(53);
        queue.enqueue(8);
        queue.enqueue(34);
        queue.enqueue(12);
        queue.enqueue(46);

        Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        assertFalse(queue.isEmpty());
        assertEquals(10, queue.size());

        assertEquals(8, queue.dequeue());
        assertEquals(8, queue.dequeue());
        assertEquals(12, queue.dequeue());
        assertEquals(12, queue.dequeue());
        assertEquals(34, queue.dequeue());
        assertEquals(34, queue.dequeue());
        assertEquals(46, queue.dequeue());
        assertEquals(46, queue.dequeue());
        assertEquals(53, queue.dequeue());
        assertEquals(53, queue.dequeue());

        assertTrue(queue.isEmpty());
    }

    @Test
    void testMergeSortWithEmptyQueue() {
        Queue<Integer> queue = new LinkedQueue<>();

        Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testMergeSortWithOneElement() {
        Queue<Integer> queue = new LinkedQueue<>();
        queue.enqueue(13);

        Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        assertEquals(13, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testMergeWithLargeNumberOfRandomNumbers() {
        int n = 10000;
        Random random = new Random();
        Queue<Integer> queue = new LinkedQueue<>();

        // Generate n number of random integers; since
        // the max value is set to n / 2, so there
        // always be duplicated numbers in the queue
        for (int i = 0; i < n; i++) {
            int number = random.nextInt(n / 2);
            queue.enqueue(number);
        }

        // Perform the merge sort
        final Comparator<Integer> comparator = Integer::compareTo;
        Exercise2.mergeSort(queue, comparator);

        // Assert the queue size is unchanged
        assertEquals(n, queue.size());

        // Check if the numbers in the queue is in the
        // sorted order by testing if the current number
        // is equal of greater than the previous number;
        int previous = queue.dequeue();
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            assertTrue(comparator.compare(current, previous) >= 0);
        }
    }
}
