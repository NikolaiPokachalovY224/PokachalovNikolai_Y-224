import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите числа с нумпада: ");
        String input = scanner.nextLine();
        Z21 z21 = new Z21();
        String convertedInput = z21.convertToPhoneKeypad(input);
        System.out.println("Результат: " + convertedInput);
    }
}
