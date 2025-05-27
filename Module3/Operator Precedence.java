public class OperatorPrecedence {
    public static void main(String[] args) {
        // Expression 1
        int result1 = 10 + 5 * 2;
        // Multiplication (*) has higher precedence than addition (+)
        // So, 5 * 2 = 10, then 10 + 10 = 20
        System.out.println("Result of 10 + 5 * 2 = " + result1);

        // Expression 2
        int result2 = (10 + 5) * 2;
        // Parentheses have the highest precedence, so:
        // (10 + 5) = 15, then 15 * 2 = 30
        System.out.println("Result of (10 + 5) * 2 = " + result2);

        // Expression 3
        int result3 = 20 / 5 + 3 * 2;
        // Division and multiplication have the same precedence, evaluated left to right:
        // 20 / 5 = 4, 3 * 2 = 6, then 4 + 6 = 10
        System.out.println("Result of 20 / 5 + 3 * 2 = " + result3);

        // Expression 4
        int result4 = 20 / (5 + 3) * 2;
        // Parentheses first: 5 + 3 = 8
        // Then division and multiplication left to right:
        // 20 / 8 = 2 (integer division), 2 * 2 = 4
        System.out.println("Result of 20 / (5 + 3) * 2 = " + result4);

        // Expression 5
        int result5 = 5 + 10 % 3 * 4;
        // Modulus (%) and multiplication (*) have higher precedence than addition (+)
        // 10 % 3 = 1, 1 * 4 = 4, then 5 + 4 = 9
        System.out.println("Result of 5 + 10 % 3 * 4 = " + result5);
    }
}
