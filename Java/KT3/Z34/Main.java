import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите список чисел через пробел: ");
        String numbersString = scanner.nextLine();
        List<Integer> numbers = parseNumbers(numbersString);
        Z34.sortNumbersByDigitSum(numbers);
        System.out.println("Отсортированный список чисел: " + numbers);
        scanner.close();
    }
    private static List<Integer> parseNumbers(String numbersString) {
        List<Integer> numbers = new ArrayList<>();
        String[] numbersArray = numbersString.split(" ");
        for (String number : numbersArray) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
