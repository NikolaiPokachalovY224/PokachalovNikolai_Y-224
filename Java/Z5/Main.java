import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите числа, разделенные пробелами: ");
        String input = scanner.nextLine();

        int sumOfSquares = Z5.calculateSumOfSquares(input);

        System.out.println("Сумма квадратов чисел: " + sumOfSquares);
    }
}
