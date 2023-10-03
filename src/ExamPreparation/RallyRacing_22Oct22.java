package ExamPreparation;

import java.util.Scanner;

public class RallyRacing_22Oct22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String racingNum = scanner.nextLine();

        int km = 0;

        String[][] matrix = new String[n][n];

        fillTheMatrix(matrix, scanner);
        System.out.println();

        String command = scanner.nextLine();
        int carLastRow = 0;
        int carLastCol = 0;
        boolean isFinish = false;

        while (!command.equals("End")) {
            switch (command) {
                case "left":
                    carLastCol = carLastCol - 1;
                    break;
                case "right":
                    carLastCol = carLastCol + 1;

                    break;
                case "up":
                    carLastRow = carLastRow - 1;
                    break;
                case "down":
                    carLastRow = carLastRow + 1;
                    break;
            }
            if (matrix[carLastRow][carLastCol].equals("F")){
                km+=10;
                System.out.printf("Racing car %s finished the stage!%n", racingNum);
                isFinish = true;
                break;
            }else if (matrix[carLastRow][carLastCol].equals("T")){
                matrix[carLastRow][carLastCol] = ".";
                for (int rowT = 0; rowT < matrix.length; rowT++) {
                    for (int colT = 0; colT < matrix.length; colT++) {
                       if (matrix[rowT][colT].equals("T")){
                           matrix[rowT][colT] = ".";
                           carLastRow = rowT;
                           carLastCol = colT;
                       }
                    }
                }
                km +=30;
            }else if (matrix[carLastRow][carLastCol].equals(".")){
                km +=10;
                matrix[carLastRow][carLastCol] = ".";
            }
            command = scanner.nextLine();
        }
        matrix[carLastRow][carLastCol] = "C";
        if (!isFinish){
            System.out.printf("Racing car %s DNF.%n", racingNum);
        }
        System.out.printf("Distance covered %d km.%n", km);
        printTheMatrix(matrix);


    }




    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

    }
    public static void printTheMatrix(String[][] matrix){
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}
