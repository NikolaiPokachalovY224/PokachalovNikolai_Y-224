import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        Z16 z16 = new Z16();
        String result = z16.transformString(input);
        System.out.println("Результат: " + result);
        scanner.close();
    }
}
