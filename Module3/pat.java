public class PatternMatchingSwitchExample {

    public static void checkType(Object obj) {
        // Requires Java 21 with --enable-preview (if running manually)
        switch (obj) {
            case Integer i -> System.out.println("It's an Integer: " + i);
            case String s -> System.out.println("It's a String: " + s);
            case Double d -> System.out.println("It's a Double: " + d);
            case null -> System.out.println("It's null.");
            default -> System.out.println("Unknown type: " + obj.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        checkType(42);
        checkType("Hello, Java 21!");
        checkType(3.14159);
        checkType(true);
        checkType(null);
    }
}
