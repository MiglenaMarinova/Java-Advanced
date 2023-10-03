package Exam18Feb2023;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int numOfRows = Integer.parseInt(input[0]);
        int numOfCols = Integer.parseInt(input[1]);

        char[][] playground = new char[numOfRows][numOfCols];

        for (int r = 0; r < playground.length; r++) {
            String[] colsData = scanner.nextLine().split(" ");
            for (int c = 0; c < playground[r].length; c++) {
                playground[r][c] = colsData[c].charAt(0);
            }
        }
        int myRowPosition = -1;
        int myColPosition = -1;
        for (int r = 0; r < playground.length; r++) {
            for (int c = 0; c < playground[r].length; c++) {
                if (playground[r][c] == 'B') {
                    myRowPosition = r;
                    myColPosition = c;
                }
            }
        }
        String command = scanner.nextLine();
        int moves = 0;
        int opponents = 0;
        int currentRow = -1;
        int currentCol = -1;
        while (!command.equals("Finish")) {
            playground[myRowPosition][myColPosition] = '-';
            switch (command) {
                case "up":
                    myRowPosition--;
                    if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == '-') {
                        moves++;
                    }else if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == 'P'){
                        moves++;
                        opponents++;
                    }else{
                        myRowPosition++;
                    }

                    break;
                case "down":
                    myRowPosition++;
                    if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == '-') {
                        moves++;
                    }else if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == 'P'){
                        moves++;
                        opponents++;
                    }else{
                        myRowPosition--;
                    }
                    break;
                case "right":
                    myColPosition++;
                    if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == '-') {
                        moves++;
                    }else if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == 'P'){
                        moves++;
                        opponents++;
                    }else{
                        myColPosition--;
                    }
                    break;
                case "left":
                    myColPosition--;
                    if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == '-') {
                        moves++;
                    }else if (isInPlayground(myRowPosition, myColPosition, playground) && playground[myRowPosition][myColPosition] == 'P'){
                        moves++;
                        opponents++;
                    }else{
                        myColPosition++;
                    }
                    break;
            }

            if (opponents == 3) {
                break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", opponents, moves);


    }

    public static boolean isInPlayground(int row, int col, char[][] matrix) {
        return (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length);
    }
}
