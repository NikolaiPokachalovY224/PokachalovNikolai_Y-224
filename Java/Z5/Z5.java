public class Z5 {
    public static int calculateSumOfSquares(String input) {
        String[] numbers = input.split(" ");

        int sumOfSquares = 0;
        for (String number : numbers) {
            int parsedNumber = Integer.parseInt(number);
            sumOfSquares += parsedNumber * parsedNumber;
        }

        return sumOfSquares;
    }
}
