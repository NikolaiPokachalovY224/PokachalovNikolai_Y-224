import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String inputText = scanner.nextLine();
        Z38 z38 = new Z38();
        String modifiedText = z38.modifyText(inputText);
        System.out.println(modifiedText);
        scanner.close();
    }
}
