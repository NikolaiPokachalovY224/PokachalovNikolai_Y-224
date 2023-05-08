import java.util.Scanner;
public class Z2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите массив значений в формате [1, 0, 1, 1, 1]:");
        String input = scanner.nextLine();
        input = input.replace("[", "").replace("]", "").replace(" ", "");
        String[] inputValues = input.split(",");
        boolean[] values = new boolean[inputValues.length];
        for (int i = 0; i < inputValues.length; i++) {
            values[i] = inputValues[i].equals("1");
        }
        int employees = countEmployees(values);
        System.out.println("Количество сотрудников: " + employees);
    }
    public static int countEmployees(boolean[] values) {
        int count = 0;
        for (boolean value : values) {
            if (value) {
                count++;
            }
        }
        return count;
    }
}
