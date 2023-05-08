import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String firstString = scanner.nextLine();
        System.out.println("Введите вторую строку:");
        String secondString = scanner.nextLine();
        Z8 z8 = new Z8();
        boolean result = z8.isEnding(firstString, secondString);
        System.out.println("Результат: " + result);
    }
}
