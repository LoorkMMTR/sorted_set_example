import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.TreeSet;


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
        SortedSet<SetUser> userSet = new SortedSet<>();

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new SetUser(name);
            userSet.add(user);
        }

        userSet.add(new SetUser(0, "zzaddedUser", 99));
        userSet.add(new SetUser(999999999, "0user", 0));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userSetSortingByName() {
        SortedSet<SetUser> userSet = new SortedSet<>(new SetUser.SortByName());

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new SetUser(name);
            userSet.add(user);
        }

        userSet.add(new SetUser(999999999, "0user", 99));
        userSet.add(new SetUser(0, "zzzzUser", 0));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userSetSortingByAge() {
        SortedSet<SetUser> userSet = new SortedSet<>(new SetUser.SortByAge());

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new SetUser(name);
            userSet.add(user);
        }

        userSet.add(new SetUser(999999999, "zzzzUser", 0));
        userSet.add(new SetUser(0, "0user", 99));
        System.out.println("after object add: " + userSet);
    }

    @Test
    public void userSetCollection() {
        var col = Arrays.asList(
                new SetUser("Ivan"),
                new SetUser("Petr"),
                new SetUser("Nikolay"));
        SortedSet<SetUser> userSet = new SortedSet<>(col);
        System.out.println("after collection add: " + userSet);
    }

}
