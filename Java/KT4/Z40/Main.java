import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("[\\{\\}\\s]", "");
        String[] inputArr = input.split(",");
        int[] arr = new int[inputArr.length];
        for (int i = 0; i < inputArr.length; i++) {
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.println(Z40.rangeExtraction(arr));
    }
}
