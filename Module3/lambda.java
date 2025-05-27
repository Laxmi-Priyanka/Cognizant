import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        // Sort the list using a lambda expression
        Collections.sort(fruits, (s1, s2) -> s1.compareToIgnoreCase(s2));

        // Display the sorted list
        System.out.println("Sorted list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
