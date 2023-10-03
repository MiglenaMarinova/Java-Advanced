package SetsAndMaps.Excersises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int elementsFirstSet = Integer.parseInt(input.split("\\s+")[0]);
        int elementsSecondSet = Integer.parseInt(input.split("\\s+")[1]);
        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 1; i <=elementsFirstSet ; i++) {
            int numFirstSet = scanner.nextInt();
            firstSet.add(numFirstSet);
        }
        for (int i = 1; i <=elementsSecondSet ; i++) {
            int numSecondSet = scanner.nextInt();
            secondSet.add(numSecondSet);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(n -> System.out.print(n + " "));
    }
}
