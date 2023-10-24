import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;


public class Tests {

    @Test
    public void stringSet() {
        SortedSet<String> stringSet = new SortedSet<>();

        while (stringSet.size() < 10) {
            var newValue = RandomStringUtils.randomAlphabetic(2, 2);
            stringSet.add(newValue);
        }

        stringSet.add("0");
        stringSet.add("zzzzzzzzzzzzzzzzzzzz");
        System.out.println("after string add: " + stringSet);
    }

    @Test
    public void integerSet() {
        SortedSet<Integer> integerSet = new SortedSet<>();

        while (integerSet.size() < 10) {
            var newValue = Integer.valueOf(RandomStringUtils.randomNumeric(3, 3));
            integerSet.add(newValue);
        }

        integerSet.add(1000);
        integerSet.add(0);
        System.out.println("after int add: " + integerSet);
    }

    @Test
    public void userSetDefaultSorting() {
        SortedSet<User> userSet = new SortedSet<>();

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new User(name);
            userSet.add(user);
        }

        userSet.add(new User(0, "zzaddedUser", 99));
        userSet.add(new User(999999999, "0user", 0));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userSetSortingByName() {
        SortedSet<User> userSet = new SortedSet<>(new User.SortByName());

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new User(name);
            userSet.add(user);
        }

        userSet.add(new User(999999999, "0user", 99));
        userSet.add(new User(0, "zzzzUser", 0));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userSetSortingByAge() {
        SortedSet<User> userSet = new SortedSet<>(new User.SortByAge());

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new User(name);
            userSet.add(user);
        }

        userSet.add(new User(999999999, "zzzzUser", 0));
        userSet.add(new User(0, "0user", 99));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userCollectionToSet() {
        var col = Arrays.asList(
                new User("Ivan"),
                new User("Petr"),
                new User("Nikolay"));
        SortedSet<User> userSet = new SortedSet<>(col);
        System.out.println("after collection add: " + userSet);
    }

    @Test
    public void bubbleCollectionToSet() {
        var col = Arrays.asList(
                new Bubble(10, "red"),
                new Bubble(5, "orange"),
                new Bubble(250, "black"));

        SortedSet<Bubble> userSet = new SortedSet<>(col);
        System.out.println("after collection add: " + userSet);
    }

}
