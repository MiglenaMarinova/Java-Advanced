package SetsAndMaps.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayList<Integer> num = new ArrayList<>();

        for (String element : input){
            num.add(Integer.parseInt(element));
        }
        List<Integer> sorted = num.stream().sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());

        int limit = Math.min(sorted.size(), 3);
        for (int i = 0; i < limit; i++) {
            System.out.print(sorted.get(i) + " ");
        }

    }
}
