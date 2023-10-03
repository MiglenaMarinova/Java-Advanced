package SetsAndMaps.Excersises;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> compounds = new TreeSet<>();

        for (int i = 1; i <= n ; i++) {
            String[] name = scanner.nextLine().split("\\s+");
            for (int j = 0; j < name.length; j++) {
                String current = name[j];
                compounds.add(current);
            }
        }
        for (String name : compounds){
            System.out.print(name + " ");
        }
    }
}
