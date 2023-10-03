package SetsAndMaps.Excersises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> usernames = new LinkedHashSet<>();

        for (int i = 1; i <= n ; i++) {
           String name = scanner.nextLine();
           usernames.add(name);
        }
        for (String name : usernames){
            System.out.println(name);
        }
    }
}
