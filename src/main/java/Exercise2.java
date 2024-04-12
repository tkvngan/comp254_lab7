import java.util.Comparator;

public class Exercise2 {

    public static <K> void mergeSort(final Queue<K> S, final Comparator<K> comparator) {
        if (S.isEmpty()) {
            return;
        }
        final Queue<Queue<K>> queueOfQueues = new LinkedQueue<>();
        while (!S.isEmpty()) {
            final Queue<K> queue = new LinkedQueue<>();
            queue.enqueue(S.dequeue());
            queueOfQueues.enqueue(queue);
        }
        while (queueOfQueues.size() > 1) {
            final Queue<K> queue1 = queueOfQueues.dequeue();
            final Queue<K> queue2 = queueOfQueues.dequeue();
            queueOfQueues.enqueue(merge(queue1, queue2, comparator));
        }
        final Queue<K> queue = queueOfQueues.first();
        while (!queue.isEmpty()) {
            S.enqueue(queue.dequeue());
        }
    }

    protected static <K> Queue<K> merge(final Queue<K> queue1, final Queue<K> queue2, final Comparator<K> comparator) {
        final Queue<K> queue = new LinkedQueue<>();
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            final K element1 = queue1.first();
            final K element2 = queue2.first();
            final int result = comparator.compare(element1, element2);
            if (result < 0) {
                queue.enqueue(queue1.dequeue());
            } else {
                queue.enqueue(queue2.dequeue());
            }
        }
        while (!queue1.isEmpty()) {
            queue.enqueue(queue1.dequeue());
        }
        while (!queue2.isEmpty()) {
            queue.enqueue(queue2.dequeue());
        }
        return queue;
    }
}
