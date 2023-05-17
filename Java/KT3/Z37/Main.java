import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество игроков: ");
        int totalPlayers = scanner.nextInt();
        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int startingPlayer = scanner.nextInt();
        Z37 game = new Z37(totalPlayers, startingPlayer);
        List<Integer> eliminatedPlayers = game.playGame();
        System.out.println("Список выбывших игроков: " + eliminatedPlayers);
        System.out.println("Победитель: " + game.getWinner());
        scanner.close();
    }
}
