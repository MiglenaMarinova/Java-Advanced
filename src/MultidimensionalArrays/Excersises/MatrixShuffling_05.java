package MultidimensionalArrays.Excersises;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numbOfRows = Integer.parseInt(input[0]);
        int numbOfCols = Integer.parseInt(input[1]);

        String[][] matrix = new String[numbOfRows][numbOfCols];

        for (int row = 0; row < numbOfRows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            if (validateCommand(command, numbOfRows, numbOfCols)) {
                String[] commandParts = command.split("\\s+");
                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);
                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];
                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;

                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validateCommand(String command, int numOfRows, int numbOfCol) {
        String[] commandParts = command.split("\\s+");
        if (commandParts.length != 5) {
            return false;
        }
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);
        if (row1 < 0 || row1 > numOfRows || row2 < 0 || row2 > numOfRows || col1 < 0 || col1 > numbOfCol || col2 < 0 || col2 > numbOfCol) {
            return false;
        }
        return true;
    }
}
