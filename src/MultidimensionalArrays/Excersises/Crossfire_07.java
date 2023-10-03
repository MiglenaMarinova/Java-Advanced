package MultidimensionalArrays.Excersises;

import java.util.*;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int numOfRows = Integer.parseInt(input[0]);
        int numOfCols = Integer.parseInt(input[1]);

        int[][] matrix = new int[numOfRows][numOfCols];

        int current = 0;
        for (int r = 0; r < numOfRows; r++) {
            for (int c = 0; c < numOfCols; c++) {
                matrix[r][c] = current + 1;
                current = matrix[r][c];
                System.out.println();
            }
        }
        String command = scanner.nextLine();

        while (!command.equals("Nuke it from orbit")) {
            replaceElementsByExplosion(matrix, command);
            matrix = getMatrixAfterExplosion(matrix);
            command = scanner.nextLine();
        }
        print(matrix);
    }

    private static int[][] getMatrixAfterExplosion(int[][] matrix) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int r = 0; r < matrix.length; r++) {
            List<Integer> list = new ArrayList<>();
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] != 0) {
                    list.add(matrix[r][c]);
                }
            }
            if (!list.isEmpty()) {
                map.put(r, list);
            }
        }
        matrix = new int[map.size()][];
        int startIndex = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            matrix[startIndex] = entry.getValue().stream().mapToInt(Integer::intValue).toArray();
            startIndex++;
        }
        return matrix;
    }

    private static void print(int[][] matrix) {

        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }


    private static boolean AreIndexesValid(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length);
    }

    private static void replaceElementsByExplosion(int[][] matrix, String input) {
        int rowIndex = Integer.parseInt(input.split("\\s+")[0]);
        int colIndex = Integer.parseInt(input.split("\\s+")[1]);
        int radius = Integer.parseInt(input.split("\\s+")[2]);

        for (int row = rowIndex - radius; row <= rowIndex + radius; row++) {
            if (AreIndexesValid(row, colIndex, matrix)) {
                matrix[row][colIndex] = 0;
            }
        }

        for (int col = colIndex - radius; col <= colIndex + radius; col++) {
            if (AreIndexesValid(rowIndex, col, matrix)) {
                matrix[rowIndex][col] = 0;
            }
        }


    }

}

