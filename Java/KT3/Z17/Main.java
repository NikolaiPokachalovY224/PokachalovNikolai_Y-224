import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();
        boolean isBalanced = Z17.checkBrackets(expression);
        System.out.println(isBalanced);
    }
}
