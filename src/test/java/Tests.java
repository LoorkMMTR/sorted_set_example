import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class Tests {

    @Test
    public void stringSet() {
        var stringSet = new SortedSet<>();

        while (stringSet.size() < 10) {
            var newValue = RandomStringUtils.randomAlphabetic(2, 2);
            stringSet.add(newValue);
        }

        stringSet.random();
        stringSet.sort();
        System.out.println("RANDOM -> SORT:" + stringSet);

        stringSet.random();
        stringSet.add("0");
        System.out.println("RANDOM -> ADD:" + stringSet);

        stringSet.clear();
        stringSet = new SortedSet<>(Arrays.asList("Z", "X", "Y", "A", "p", "q", "a", "b", "a", "S", "S"));
        System.out.println("CONSTRUCTOR:" + stringSet);

        stringSet.random();
        System.out.println("RANDOM:" + stringSet);
    }

   @Test
   public void integerSet() {
       var integerSet = new SortedSet<>();

       while (integerSet.size() < 10) {
           var newValue = Integer.valueOf(RandomStringUtils.randomNumeric(3, 3));
           integerSet.add(newValue);
       }

       integerSet.random();
       integerSet.sort();
       System.out.println("RANDOM -> SORT:" + integerSet);

       integerSet.random();
       integerSet.add(500);
       System.out.println("RANDOM -> ADD:" + integerSet);

       integerSet.clear();
       integerSet = new SortedSet<>(Arrays.asList(5, 2, 1, 4, 7, 8, 9, 0, 3, 6, 0, null));
       System.out.println("CONSTRUCTOR:" + integerSet);

       integerSet.random();
       System.out.println("RANDOM:" + integerSet);

   }


}
