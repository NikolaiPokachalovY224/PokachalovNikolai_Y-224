import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int count = Z4.parseInputAndCountCharacters(input);
        System.out.println(+ count);
    }
}
