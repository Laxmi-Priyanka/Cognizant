import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add student entries (ID and Name). Type '0' as ID to stop.");

        while (true) {
            System.out.print("Enter student ID (integer): ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (id == 0) {
                break; // Exit input loop
            }

            System.out.print("Enter student name: ");
            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                studentMap.put(id, name);
            } else {
                System.out.println("Name cannot be empty. Try again.");
            }
        }

        // Retrieval part
        System.out.println("\nRetrieve student name by ID.");
        while (true) {
            System.out.print("Enter student ID to search (or 0 to exit): ");
            int searchId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (searchId == 0) {
                break;
            }

            String studentName = studentMap.get(searchId);
            if (studentName != null) {
                System.out.println("Student ID " + searchId + " : " + studentName);
            } else {
                System.out.println("No student found with ID " + searchId);
            }
        }

        scanner.close();
    }
}
