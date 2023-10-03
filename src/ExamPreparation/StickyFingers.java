package ExamPreparation;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");

        char[][] field = new char[n][n];

        for (int r = 0; r < n; r++) {
            String[] input = scanner.nextLine().split(" ");
            for (int c = 0; c < n; c++) {
                field[r][c] = input[c].charAt(0);
            }
        }
        int currentRow = -1;
        int currentCol = -1;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field.length; c++) {
                if (field[r][c] == 'D') {
                    currentRow = r;
                    currentCol = c;
                }
            }
        }
        boolean gotCaught = false;
        int stolenMoney = 0;
        int totalMoney = 0;
        for (int i = 0; i < command.length; i++) {
            String currentCommand = command[i];
            int rowToMove = currentRow;
            int colToMove = currentCol;
            switch (currentCommand) {
                case "up":
                    rowToMove = currentRow - 1;
                    break;
                case "right":
                    colToMove = currentCol + 1;
                    break;
                case "down":
                    rowToMove = currentRow + 1;
                    break;
                case "left":
                    colToMove = currentCol -1;
                    break;
            }
            if (isInField(rowToMove, colToMove, field)){
                field[currentRow][currentCol] = '+';
                if (field[rowToMove][colToMove] == '$'){
                    stolenMoney = rowToMove * colToMove;
                    totalMoney += stolenMoney;
                    System.out.printf("You successfully stole %d$.%n", stolenMoney);
                }else if (field[rowToMove][colToMove] == 'P'){
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
                    field[rowToMove][colToMove] = '#';
                    gotCaught = true;
                    break;
                }
                currentRow = rowToMove;
                currentCol = colToMove;

                field[currentRow][currentCol] = 'D';


            }else{
                System.out.println("You cannot leave the town, there is police outside!");
            }
        }
        if (gotCaught){

        }else{
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        }

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }

    }
    public static boolean isInField (int row, int col, char[][] matrix){
        return (row >= 0 && row < matrix.length
        && col >= 0 && col < matrix.length);
    }

}
