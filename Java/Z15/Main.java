import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        scanner.close();
        String result = Z15.removeDuplicateWords(input);
        System.out.println("Результат: " + result);
    }
}
