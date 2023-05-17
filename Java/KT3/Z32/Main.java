import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество палочек: ");
        long n = scanner.nextLong();
        boolean isSashaWinner = Z32.isSashaWinningGame(n);
        if (isSashaWinner) {
            System.out.println("Саша выигрывает игру");
        } else {
            System.out.println("Таня выигрывает игру");
        }
        scanner.close();
    }
}
