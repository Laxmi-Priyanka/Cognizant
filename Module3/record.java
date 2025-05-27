import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Define a record named Person
record Person(String name, int age) {}

public class RecordExample {
    public static void main(String[] args) {
        // Create instances of Person
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person("Bob", 17);
        Person p3 = new Person("Charlie", 30);

        // Print individual records
        System.out.println("People:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Use records in a List
        List<Person> people = Arrays.asList(p1, p2, p3);

        // Filter persons aged 18 and above using Stream API
        List<Person> adults = people.stream()
                                    .filter(person -> person.age() >= 18)
                                    .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(System.out::println);
    }
}
