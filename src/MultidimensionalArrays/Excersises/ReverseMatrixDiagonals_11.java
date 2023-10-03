package MultidimensionalArrays.Excersises;

import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int row = Integer.parseInt(input.split("\\s+")[0]);
        int col = Integer.parseInt(input.split("\\s+")[1]);
        int[][] matrix = new int[row][col];

        for (int r = 0; r < matrix.length; r++) {
            String[] colNum = scanner.nextLine().split("\\s+");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = Integer.parseInt(colNum[c]);
            }
        }
        int currentRow = -1;
        int currentColl = -1;
        int currentCell = matrix[0][0];
        for (int r = matrix.length - 1; r >= 0; r--) {
            if (r == matrix.length - 1){
                for (int c = matrix[0].length - 1; c >= 0; c--) {
                    currentCell = matrix[r][c];
                    if (isValidIndex(r, c, matrix)) {
                        currentCell = matrix[r][c];
                        System.out.print(currentCell + " ");

                        currentRow = r;
                        currentColl = c;
                        while (currentRow >= 0 && currentColl <= matrix[0].length) {
                            if (isValidIndex(currentRow -1, currentColl +1, matrix)) {
                                currentCell = matrix[currentRow - 1][currentColl + 1];
                                System.out.print(currentCell + " ");
                            } else {
                                System.out.println();
                                break;
                            }

                            currentRow -= 1;
                            currentColl += 1;
                        }
                    }
                }
            }else if(r < matrix.length - 1){
                currentRow = r;
                currentColl = 0;
                if (isValidIndex(currentRow, currentColl, matrix)) {
                    currentCell = matrix[r][currentColl];
                    System.out.print(currentCell + " ");
                }
                while (currentRow >= 0 && currentColl <= matrix[0].length) {
                    if (isValidIndex(currentRow -1, currentColl +1, matrix)) {
                        currentCell = matrix[currentRow - 1][currentColl + 1];
                        System.out.print(currentCell + " ");
                    } else {
                        System.out.println();
                        break;
                    }

                    currentRow -= 1;
                    currentColl += 1;
                }

            }

        }
    }

    private static boolean isValidIndex(int row, int coll, int[][] matrix) {
        return (row >= 0 && row < matrix.length && coll >= 0 && coll < matrix[0].length);
    }

}
