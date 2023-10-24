import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


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
    public void userSet() {
        SortedSet<SetUser> userSet = new SortedSet<>(SetUser::compareTo);

        while (userSet.size() < 10) {
            var name = RandomStringUtils.randomAlphabetic(6, 10);
            var user = new SetUser(name);
            userSet.add(user);
        }

        userSet.add(new SetUser(0, "addedUser"));
        userSet.add(new SetUser(999999999, "addedUser1"));
        System.out.println("after object add: " + userSet);
    }

}
