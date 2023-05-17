import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        int maxLength = Z26.LongestPalindrome(input);
        System.out.println("Длинейший палиндром: " + maxLength);
        scanner.close();
    }
}
