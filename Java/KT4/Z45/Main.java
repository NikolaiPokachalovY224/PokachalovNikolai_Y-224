import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество лет: ");
        int years = scanner.nextInt();
        String romanYears = Z45.intToRoman(years);
        System.out.println("Римское число: " + romanYears);
    }
}
