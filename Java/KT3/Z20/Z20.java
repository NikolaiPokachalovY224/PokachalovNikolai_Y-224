import java.io.FileWriter;
class Z20 {
    public int[][] fillArray(int m, int n) {
        int[][] array = new int[m][n];
        int start = 1;
        int end = Math.min(m, n) / 2 + 1;
        for (int i = 0; i < end; i++) {
            for (int j = i; j < n - i; j++)
                array[i][j] = start;
            for (int j = i + 1; j < m - i; j++)
                array[j][n - i - 1] = start;
            for (int j = n - i - 2; j >= i; j--)
                array[m - i - 1][j] = start;
            for (int j = m - i - 2; j > i; j--)
                array[j][i] = start;
            start++;
        }
        return array;
    }
    public void printArray(int[][] array) {
        for (int[] row : array) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }
    public void saveArrayToFile(int[][] array, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int[] row : array) {
                for (int num : row)
                    writer.write(num + " ");
                writer.write("\n");
            }
            System.out.println("Массив успешно сохранен в файл " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
