public class TypeCastingExample {
    public static void main(String[] args) {
        // Declare a double variable with a decimal value
        double myDouble = 9.78;

        // Cast double to int (explicit casting)
        int castedInt = (int) myDouble;
        System.out.println("Double value: " + myDouble);
        System.out.println("After casting double to int: " + castedInt);

        // Declare an int variable
        int myInt = 42;

        // Cast int to double (implicit casting)
        double castedDouble = myInt;
        System.out.println("Int value: " + myInt);
        System.out.println("After casting int to double: " + castedDouble);
    }
}
