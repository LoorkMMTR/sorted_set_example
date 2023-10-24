import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.Objects;
import java.util.Random;

@Data
@AllArgsConstructor
public class User implements Comparable<User> {

    int id;
    String name;
    int age;

    public User(String name) {
        this.id = new Random().nextInt(100000);
        this.name = name;
        this.age = new Random().nextInt(100);
    }

    @Override
    public int compareTo(User o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + name + " " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (!(obj instanceof User setUser)) return false;

        return this.id == setUser.id && Objects.equals(this.name, setUser.name);
    }

    //Comparators
    static class SortByName implements Comparator<User> {
        public int compare(User a, User b) {
            return a.name.compareTo(b.name);
        }
    }

    static class SortByAge implements Comparator<User> {
        public int compare(User a, User b) {
            return a.age - b.age;
        }
    }

}
