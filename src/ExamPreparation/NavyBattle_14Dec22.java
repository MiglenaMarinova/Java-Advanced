package ExamPreparation;

import java.util.Scanner;

public class NavyBattle_14Dec22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] battlefield = new char[n][n];

        for (int r = 0; r < battlefield.length; r++) {
            String rowData = scanner.nextLine();
            for (int c = 0; c < battlefield.length; c++) {
                battlefield[r][c] = rowData.charAt(c);
            }
        }
        int u9LastRowPosition = -1;
        int u9LastColPosition = -1;

        for (int r = 0; r < battlefield.length; r++) {
            for (int c = 0; c < battlefield.length; c++) {
                if (battlefield[r][c] == 'S') {
                    u9LastRowPosition = r;
                    u9LastColPosition = c;
                }
            }
        }
        int countMine = 0;
        int countCruiser = 0;
        int rowDirection = -1;
        int colDirection = -1;

        while (countMine < 3 && countCruiser < 3) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    rowDirection = u9LastRowPosition - 1;
                    if (isRowValid(rowDirection, battlefield)) {
                        battlefield[u9LastRowPosition][u9LastColPosition] = '-';
                        u9LastRowPosition = rowDirection;
                    }
                    break;
                case "down":
                    rowDirection = u9LastRowPosition + 1;
                    if (isRowValid(rowDirection, battlefield)) {
                        battlefield[u9LastRowPosition][u9LastColPosition] = '-';
                        u9LastRowPosition = rowDirection;
                    }
                    break;
                case "left":
                    colDirection = u9LastColPosition - 1;
                    if (isColValid(colDirection, battlefield)) {
                        battlefield[u9LastRowPosition][u9LastColPosition] = '-';
                        u9LastColPosition = colDirection;
                    }
                    break;
                case "right":
                    colDirection = u9LastColPosition + 1;
                    if (isColValid(colDirection, battlefield)) {
                        battlefield[u9LastRowPosition][u9LastColPosition] = '-';
                        u9LastColPosition = colDirection;
                    }
                    break;
            }
            if (battlefield[u9LastRowPosition][u9LastColPosition] == '*'){
                countMine++;
            }else if (battlefield[u9LastRowPosition][u9LastColPosition] == 'C'){
                countCruiser++;
            }
            battlefield[u9LastRowPosition][u9LastColPosition] = 'S';
        }
        if (countCruiser == 3){
            System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
        }else if (countMine == 3){
            System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", u9LastRowPosition, u9LastColPosition);
        }
        printMatrix(battlefield);

    }

    private static boolean isRowValid(int row, char[][] matrix) {
        return (row >= 0 && row < matrix.length);
    }

    private static boolean isColValid(int col, char[][] matrix) {
        return (col >= 0 && col < matrix.length);
    }
    private static void printMatrix(char[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();

        }
    }
}
