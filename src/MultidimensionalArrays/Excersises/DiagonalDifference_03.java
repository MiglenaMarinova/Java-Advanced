package MultidimensionalArrays.Excersises;

import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        fillMatrix(matrix, scanner);

        int sumPrimaryDiagonal = getSumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = getSumSecondaryDiagonal(matrix);
        System.out.println(Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal));

    }
    private static int getSumSecondaryDiagonal(int[][] matrix){
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                int currentElement = matrix[r][c];
                if (c == matrix.length - r - 1){
                    sum += currentElement;
                }
            }
        }
        return sum;
    }
    private static int getSumPrimaryDiagonal(int[][] matrix){
        int sum = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r == c){
                   sum += matrix[r][c];
                }
            }
        }
        return sum;
    }
    private  static void fillMatrix(int[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
