package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int numOfRows = Integer.parseInt(input[0]);
        int numOfCols = Integer.parseInt(input[1]);

        int[][] table = new int[numOfRows][numOfCols];

        for (int row = 0; row < numOfRows; row++) {
            String[] colData = scanner.nextLine().split(", ");
            for (int col = 0; col < numOfCols; col++) {
                table[row][col] = Integer.parseInt(colData[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;
        int rowOfMax = -1;
        int colOfMax = -1;
        for (int row = 0; row < numOfRows - 1; row++) {
            for (int col = 0; col < numOfCols - 1; col++) {
                int currentSum = table[row][col] + table[row][col + 1] + table[row + 1][col] + table[row +1][col +1];
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    rowOfMax = row;
                    colOfMax = col;
                }
            }

        }
        System.out.println(table[rowOfMax][colOfMax] + " " + table[rowOfMax][colOfMax + 1]);
        System.out.println(table[rowOfMax + 1][colOfMax] + " " + table[rowOfMax + 1][colOfMax + 1]);
        System.out.println(maxSum);
    }
}
