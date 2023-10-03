package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Voina_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstPlayerDeck = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayerDeck = new LinkedHashSet<>();

        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");


        for (int i = 0; i < firstInput.length; i++) {
            int current = Integer.parseInt(firstInput[i]);
            firstPlayerDeck.add(current);
        }
        for (int i = 0; i < secondInput.length; i++) {
            int current = Integer.parseInt(secondInput[i]);
            secondPlayerDeck.add(current);
        }

        for (int steps = 1; steps < 50 ; steps++) {
            if (firstPlayerDeck.isEmpty()){
                System.out.println("Second player win!");
                break;
            }else if (secondPlayerDeck.isEmpty()){
                System.out.println("First player win!");
                break;
            }
            int firstPlayerCard = firstPlayerDeck.iterator().next();
            int secondPlayerCard = secondPlayerDeck.iterator().next();

            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            if (firstPlayerCard > secondPlayerCard){
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            }else if (secondPlayerCard > firstPlayerCard){
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }else{
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }
        if (firstPlayerDeck.size() > secondPlayerDeck.size()){
            System.out.println("First player win!");
        }else if (secondPlayerDeck.size() > firstPlayerDeck.size()){
            System.out.println("Second player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
