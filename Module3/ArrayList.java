import java.util.ArrayList;
import java.util.Scanner;

public class StudentNames {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter student names. Type 'done' to finish:");

        while (true) {
            System.out.print("Enter name: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("done")) {
                break;
            }

            if (!input.trim().isEmpty()) {
                studentNames.add(input.trim());
            } else {
                System.out.println("Empty input, please enter a valid name.");
            }
        }

        System.out.println("\nList of student names:");
        for (String name : studentNames) {
            System.out.println(name);
        }

        scanner.close();
    }
}
