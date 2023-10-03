package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int firstRows = Integer.parseInt(input[0]);
        int firstCols = Integer.parseInt(input[1]);

        int [][] firstTable = new int[firstRows][firstCols];

        for (int i = 0; i < firstRows; i++) {
            String[] rowsNum = scanner.nextLine().split("\\s+");
            for (int j = 0; j < firstCols; j++) {
                firstTable[i][j] = Integer.parseInt(rowsNum[j]);
            }
        }
        input = scanner.nextLine().split("\\s+");
        int secondRows = Integer.parseInt(input[0]);
        int secondCols = Integer.parseInt(input[1]);

        int [][] secondTable = new int[secondRows][secondCols];

        for (int i = 0; i < secondRows; i++) {
            String[] rowsNum = scanner.nextLine().split("\\s+");
            for (int j = 0; j < secondCols; j++) {
                secondTable[i][j] = Integer.parseInt(rowsNum[j]);
            }
        }
        if (firstRows != secondRows || firstCols != secondCols){
            System.out.println("not equal");
            return;
        }
        for (int i = 0; i < firstRows; i++) {
            for (int j = 0; j < firstCols; j++) {
                if (firstTable[i][j] != secondTable[i][j]){
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
