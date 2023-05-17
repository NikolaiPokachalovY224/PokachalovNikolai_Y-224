import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.print("Введите число сдвига: ");
        int shift = scanner.nextInt();
        System.out.print("Введите направление (1 - вперед, -1 - назад): ");
        int direction = scanner.nextInt();
        String encryptedText = Z27.encryptCaesarCipher(input, shift, direction);
        System.out.println("Зашифрованный текст: " + encryptedText);
        scanner.close();
    }
}
