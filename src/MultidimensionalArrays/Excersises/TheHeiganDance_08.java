package MultidimensionalArrays.Excersises;

import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());

        int[][] matrix = new int[15][15];

        double heiganPoints = 3000000;
        int playerPoints = 18500;
        int rowCurrentPosition = 7;
        int colCurrentPosition = 7;

        boolean activeCloud = false;
        String currentCommand = "";

        while (heiganPoints > 0 && playerPoints > 0) {
            heiganPoints -= damageToHeigan;

            if (activeCloud) {
                playerPoints -= 3500;
                activeCloud = false;

                if (playerPoints < 0) {
                    break;
                }
            }
            if (heiganPoints < 0) {
                break;
            }
            String commandParts = scanner.nextLine();
            String command = commandParts.split("\\s+")[0];
            int rowToDamage = Integer.parseInt(commandParts.split("\\s+")[1]);
            int colToDamage = Integer.parseInt(commandParts.split("\\s+")[2]);
            if (isInDamageArea(rowToDamage, colToDamage, rowCurrentPosition, colCurrentPosition)) {
                if (!isInDamageArea(rowToDamage, colToDamage, rowCurrentPosition - 1, colCurrentPosition) && !isWall(rowCurrentPosition - 1)) {
                    rowCurrentPosition--;
                } else if (!isInDamageArea(rowToDamage, colToDamage, rowCurrentPosition, colCurrentPosition + 1) && !isWall(colCurrentPosition + 1)) {
                    colCurrentPosition++;
                } else if (!isInDamageArea(rowToDamage, colToDamage, rowCurrentPosition + 1, colCurrentPosition) && !isWall(rowCurrentPosition + 1)) {
                    rowCurrentPosition++;
                } else if (!isInDamageArea(rowToDamage, colToDamage, rowCurrentPosition, colCurrentPosition - 1) && !isWall(colCurrentPosition - 1)) {
                    colCurrentPosition--;
                } else {
                    if (command.equals("Cloud")) {
                        playerPoints -= 3500;
                        currentCommand = "Plague Cloud";
                        activeCloud = true;
                    } else if (command.equals("Eruption")) {
                        playerPoints -= 6000;
                        currentCommand = "Eruption";
                    }
                }
            }
        }
        if (heiganPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + currentCommand);
        }

        System.out.println("Final position: " + rowCurrentPosition + ", " + colCurrentPosition);


    }
    private static  boolean isWall(int currentPosition){
        return currentPosition < 0 || currentPosition >= 15;
    }
    private static boolean isInDamageArea (int rowToDamage, int colToDamage, int row, int col){
        return ((rowToDamage - 1 <= row && row <= rowToDamage + 1)
                && (colToDamage - 1 <= col && col <= colToDamage + 1));
    }


}



