package MultidimensionalArrays.Excersises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numOfRows = Integer.parseInt(input[0]);
        int numOfCols = Integer.parseInt(input[1]);

        String[][] matrix = new String[numOfRows][numOfCols];

        char letter = 'a';
        for (int r = 0; r < numOfRows; r++) {
            String currentLetter = String.valueOf((char)(letter + r));
            for (int c = 0; c < numOfCols; c++) {
                String middleLetter = String.valueOf((char) (letter + r + c));
                String cell = currentLetter + middleLetter + currentLetter;
                matrix[r][c] = cell;
            }
        }
        printMatrix(matrix);

    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
