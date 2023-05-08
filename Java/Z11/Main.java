import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        Z11 z11 = new Z11();
        String result = z11.removeVowels(input);
        System.out.println("Результат: " + result);
    }
}
