package MultidimensionalArrays.Excersises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        String input = scanner.nextLine();
        int maxLength = 0;
        int countInputs = 0;
        List<String> text = new ArrayList<>();
        while (!input.equals("END")) {
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            countInputs++;
            text.add(input);
            input = scanner.nextLine();
        }
        char[][] matrix = new char[countInputs][maxLength];

        for (int r = 0; r < countInputs; r++) {
            StringBuilder textRow = new StringBuilder(text.get(r));
            if (textRow.length() < maxLength){
                int diff = maxLength - textRow.length();
                for (int i = 1; i <= diff ; i++) {
                    textRow = textRow.append(' ');
                }
            }
            for (int c = 0; c < maxLength; c++) {
                matrix[r][c] = textRow.charAt(c);
            }
        }
        int degree = Integer.parseInt(command.substring(7, command.length()-1)) % 360;
        if (degree == 0){
            printMatrix(matrix);
        }else if (degree==90){
            for (int c = 0; c < maxLength; c++) {
                for (int r = countInputs - 1; r >= 0; r--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (degree==180){
            for (int r = countInputs - 1; r >= 0; r--) {
                for (int c = maxLength - 1; c >= 0; c--) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }else if (degree == 270){
            for (int c = maxLength - 1; c >= 0; c--) {
                for (int r = 0; r < countInputs ; r++) {
                    System.out.print(matrix[r][c]);
                }
                System.out.println();
            }
        }
    }

    private static void printMatrix (char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
