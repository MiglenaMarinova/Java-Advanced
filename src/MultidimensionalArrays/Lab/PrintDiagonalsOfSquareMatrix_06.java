package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] table = new int[n][];

        for (int row = 0; row < n; row++) {
            String[] colData = scanner.nextLine().split("\\s+");
            int[] currentRow = new int[n];
            for (int col = 0; col < colData.length; col++) {
                currentRow[col] = Integer.parseInt(colData[col]);
            }
            table[row] = currentRow;
        }
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][i] + " ");
        }
        System.out.println();
        for (int row = n - 1, col = 0; col < n; row--, col ++) {
            System.out.print(table[row][col] + " ");
        }
    }
}
