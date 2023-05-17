import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextInt();
        Z28 z28 = new Z28();
        int[] squares = z28.findConsecutiveSquares(n);
        if (squares != null) {
            System.out.println(squares[1] + "-" + squares[0]);
        } else {
            System.out.println("Ошибка");
        }
        scanner.close();
    }
}
