package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfRows = Integer.parseInt(scanner.nextLine());
        int numOfCols = Integer.parseInt(scanner.nextLine());

        char [][] matrixA = new char[numOfRows][numOfCols];
        for (int rows = 0; rows < numOfRows; rows++) {
            String[] rowsElements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < numOfCols; cols++) {
                matrixA [rows][cols] = rowsElements[cols].charAt(0);
            }
        }
        char [][] matrixB = new char[numOfRows][numOfCols];
        for (int rows = 0; rows < numOfRows; rows++) {
            String[] rowsElements = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < numOfCols; cols++) {
                matrixB [rows][cols] = rowsElements[cols].charAt(0);
            }
        }
        char [][] matrixC = new char[numOfRows][numOfCols];
        for (int rows = 0; rows < numOfRows; rows++) {
            for (int cols = 0; cols < numOfCols; cols++) {
                if (matrixA [rows][cols] == matrixB [rows][cols]){
                    matrixC [rows][cols] = matrixA [rows][cols];
                }else{
                    matrixC [rows][cols] = '*';
                }
            }
        }
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[0].length; j++) {
                System.out.print(matrixC [i][j] + " ");
            }
            System.out.println();
        }
    }
}
