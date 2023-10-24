import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class SetUser implements Comparable<SetUser> {

    int id;
    String name;

    public SetUser(String name) {
        this.id = new Random().nextInt(100000);
        this.name = name;
    }

    @Override
    public int compareTo(SetUser o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

}
