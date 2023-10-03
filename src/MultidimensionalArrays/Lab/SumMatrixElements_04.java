package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int numOfRows = Integer.parseInt(input[0]);
        int numOfCols = Integer.parseInt(input[1]);

        int[][] matrix = new int[numOfRows][numOfCols];
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        for (int r = 0; r < numOfRows; r++) {
            String[] rowElements = scanner.nextLine().split(", ");
            for (int c = 0; c < numOfCols; c++) {
                matrix[r][c] = Integer.parseInt(rowElements[c]);
            }
        }
        int sum = 0;
        for (int r = 0; r < numOfRows; r++) {
            for (int c = 0; c < numOfCols; c++) {
                sum += matrix[r][c];
            }
        }
        System.out.println(sum);
    }
}
