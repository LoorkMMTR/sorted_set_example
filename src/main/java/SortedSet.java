import java.util.*;
import java.util.stream.Collectors;

public class SortedSet<E> extends AbstractSet<E> implements java.util.Set<E> {

    private final transient LinkedHashMap<E,Object> map;

    //Dummy value for map
    private static final Object PRESENT = new Object();

    SortedSet(LinkedHashMap<E,Object> map) {
        this.map = map;
    }

    //Constructors of new set
    public SortedSet() { this(new LinkedHashMap<>()); }

    public SortedSet(Collection<? extends E> c) {
        map = new LinkedHashMap<>(Math.max((int) (c.size()/.75f) + 1, 16));
        addAll(c);
    }

    //Collection sorting
    public void random() {
        Map<E, Object> randomMap = new HashMap<>(map);
        map.clear();
        map.putAll(randomMap);
    }

    public void sort() {
        List<E> list = map.keySet().stream().sorted().collect(Collectors.toList());
        map.clear();
        list.forEach(e -> map.put(e, PRESENT));
    }

    //custom
    @Override
    public String toString() {
        return map.keySet().toString();
    }

    @Override
    public boolean add(E e) {
        if (map.put(e, PRESENT) == null) {
            this.sort();
            return true;
        } else return false;
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
