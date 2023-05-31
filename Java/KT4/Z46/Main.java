import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите Римское число: ");
        String roman = scanner.nextLine();
        int arabic = Z46.romanToInt(roman);
        System.out.println("Арабское число: " + arabic);
    }
}
