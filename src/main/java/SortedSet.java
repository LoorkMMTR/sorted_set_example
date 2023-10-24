import java.util.*;
import java.util.stream.Collectors;

public class SortedSet<E extends Comparable<E>> extends AbstractSet<E> implements java.util.Set<E> {

    private final transient NavigableMap<E,Object> map;

    //Dummy value for map
    private static final Object PRESENT = new Object();

    SortedSet(NavigableMap<E,Object> map) {
        this.map = map;
    }

    //Empty comparable
    public SortedSet(Comparator<? super E> comparator) {
        this(new TreeMap<>(comparator));
    }

    public SortedSet() {
        this(new TreeMap<>());
    }

    public SortedSet(java.util.SortedSet<E> s) {
        this(s.comparator());
        addAll(s);
    }


    //custom
    @Override
    public String toString() {
        return map.keySet().toString();
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    //implemented from Set
    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public int size() { return map.size(); }

    @Override
    public Iterator<E> iterator() { return map.keySet().iterator(); }

}
