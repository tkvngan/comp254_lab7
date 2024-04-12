public class Exercise1<K, V> extends TreeMap<K, V> {

    @Override
    protected Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        while (!isExternal(p)) {
            int comp = compare(key, p.getElement());
            if (comp == 0) {
                break;
            } else if (comp < 0) {
                p = left(p);
            } else {
                p = right(p);
            }
        }
        return p;
    }
}
