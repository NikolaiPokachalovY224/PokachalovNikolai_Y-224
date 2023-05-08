import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Z14 memory = new Z14();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите число (для выхода введите 'q'): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            int number = Integer.parseInt(input);
                memory.storeNumber(number);
        }
    }
}
