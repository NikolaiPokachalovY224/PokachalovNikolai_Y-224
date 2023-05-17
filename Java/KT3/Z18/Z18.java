public class Z18 {
    public static void findMaxAndSplit(int[] array) {
        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }
        int[] leftArray = new int[maxIndex];
        int[] rightArray = new int[array.length - maxIndex - 1];
        for (int i = 0; i < maxIndex; i++) {
            leftArray[i] = array[i];
        }
        for (int i = maxIndex + 1; i < array.length; i++) {
            rightArray[i - maxIndex - 1] = array[i];
        }
        System.out.println("Максимальное значение: " + array[maxIndex]);
        System.out.println("Числа слева от максимума:");
        for (int num : leftArray) {
            System.out.print(num + " ");
        }
        System.out.println("\nЧисла справа от максимума:");
        for (int num : rightArray) {
            System.out.print(num + " ");
        }
    }
}
