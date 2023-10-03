package ExamPreparation;

import java.util.ArrayList;
import java.util.Scanner;

public class TreasureHunt_13Feb23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int numOfRows = Integer.parseInt(dimension[0]);
        int numOfCols = Integer.parseInt(dimension[1]);

        String[][] matrix = new String[numOfRows][numOfCols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        int myPositionRow = 0;
        int myPositionCol = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c].equals("Y")) {
                    myPositionRow = r;
                    myPositionCol = c;
                }
            }
        }

        String command = scanner.nextLine();
        int rowDirection = -1;
        int colDirection = -1;
        ArrayList<String> correctDirection = new ArrayList<>();
        while (!command.equals("Finish")) {
            switch (command) {
                case "up":
                    rowDirection = myPositionRow - 1;
                    if (isInField(rowDirection, myPositionCol, matrix)) {
                        if (!matrix[rowDirection][myPositionCol].equals("T")) {
                            myPositionRow = rowDirection;
                            correctDirection.add(command);
                        }
                    }
                    break;
                case "down":
                    rowDirection = myPositionRow + 1;
                    if (isInField(rowDirection, myPositionCol, matrix)) {
                        if (!matrix[rowDirection][myPositionCol].equals("T")) {
                            myPositionRow = rowDirection;
                            correctDirection.add(command);
                        }
                    }
                    break;
                case "right":
                    colDirection = myPositionCol + 1;
                    if (isInField(myPositionRow, colDirection, matrix)) {
                        if (!matrix[myPositionRow][colDirection].equals("T")) {
                            myPositionCol = colDirection;
                            correctDirection.add(command);
                        }
                    }
                    break;
                case "left":
                    colDirection = myPositionCol - 1;
                    if (isInField(myPositionRow, colDirection, matrix)) {
                        if (!matrix[myPositionRow][colDirection].equals("T")) {
                            myPositionCol = colDirection;
                            correctDirection.add(command);
                        }
                    }
                    break;


            }
            command = scanner.nextLine();
        }
        if (matrix[myPositionRow][myPositionCol].equals("X")) {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.println(String.join(", ", correctDirection));
        } else {
            System.out.println("The map is fake!");
        }
    }


    private static boolean isInField(int row, int col, String[][] matrix) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }

}
