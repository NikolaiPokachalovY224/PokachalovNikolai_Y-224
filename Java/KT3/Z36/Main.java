import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Z36 game = new Z36();
        System.out.println("Добро пожаловать в игру! Введите 4 числа:");
        int attempt = 1;
        while (attempt <= 20) {
            System.out.println("Попытка " + attempt);
            int[] guess = new int[4];
            for (int i = 0; i < 4; i++) {
                guess[i] = scanner.nextInt();
            }
            int matches = game.checkGuess(guess);
            System.out.println("Совпадения: " + matches);
            if (matches == 4) {
                System.out.println("Поздравляем, вы угадали код!");
                break;
            }
            attempt++;
        }
        if (attempt > 20) {
            System.out.println("Вы исчерпали все попытки. Код не разгадан.");
        }
        scanner.close();
    }
}
