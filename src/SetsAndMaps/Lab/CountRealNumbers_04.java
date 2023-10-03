package SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<Double, Integer> numbers = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\s+");

        for (String number : input) {
            double doubleNum = Double.parseDouble(number);

            if (numbers.containsKey(doubleNum)) {
                numbers.put(doubleNum, numbers.get(doubleNum) + 1);
            } else {
                numbers.put(doubleNum, 1);
            }
        }
        for (Double currentNum : numbers.keySet()) {
            System.out.printf("%.1f -> %d%n", currentNum, numbers.get(currentNum));
        }
    }
}
