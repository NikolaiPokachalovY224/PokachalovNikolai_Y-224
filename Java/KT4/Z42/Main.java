import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("[\\[\\]\\s]", "");
        String[] inputArr = input.split(",");
        int[][] intervals = new int[inputArr.length / 2][2];
        for (int i = 0; i < inputArr.length; i += 2) {
            intervals[i / 2][0] = Integer.parseInt(inputArr[i]);
            intervals[i / 2][1] = Integer.parseInt(inputArr[i + 1]);
        }
        System.out.println(Z42.countIntervals(intervals));
    }
}
