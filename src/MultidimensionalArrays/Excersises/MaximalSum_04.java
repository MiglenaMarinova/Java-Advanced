package MultidimensionalArrays.Excersises;

import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numbOfRows = Integer.parseInt(input[0]);
        int numbOfCols = Integer.parseInt(input[1]);

        int[][] matrix = new int[numbOfRows][numbOfCols];

        for (int row = 0; row < numbOfRows; row++) {
            String[] colData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < numbOfCols; col++) {
                matrix[row][col] = Integer.parseInt(colData[col]);
            }
        }

        int maxSum = Integer.MIN_VALUE;
        int rowOfMax = -1;
        int colOfMax = -1;
        for (int row = 0; row < numbOfRows - 2; row++) {
            for (int col = 0; col < numbOfCols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] + matrix[row +1][col +1]
                 + matrix[row + 1][col +2] + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2] ;
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    rowOfMax = row;
                    colOfMax = col;
                }
            }

        }
        System.out.printf("Sum = %d%n", maxSum);
        System.out.println(matrix[rowOfMax][colOfMax] + " " + matrix[rowOfMax][colOfMax + 1] + " " + matrix[rowOfMax][colOfMax + 2]);
        System.out.println(matrix[rowOfMax + 1][colOfMax] + " " + matrix[rowOfMax + 1][colOfMax + 1] + " " + matrix[rowOfMax + 1][colOfMax + 2]);
        System.out.println(matrix[rowOfMax + 2][colOfMax] + " " + matrix[rowOfMax + 2][colOfMax + 1] + " " + matrix[rowOfMax + 2][colOfMax + 2]);


    }

}
