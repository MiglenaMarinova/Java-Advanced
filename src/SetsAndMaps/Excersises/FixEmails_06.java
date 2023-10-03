package SetsAndMaps.Excersises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emailsMap = new LinkedHashMap<>();
        String name = scanner.nextLine();

        while (!name.equals("stop")){
            String email = scanner.nextLine();
            emailsMap.putIfAbsent(name, "");
            emailsMap.put(name, email);
            name = scanner.nextLine();
        }

        emailsMap.entrySet().removeIf(entry -> entry.getValue().endsWith("uk")
                || entry.getValue().endsWith("us")
                || entry.getValue().endsWith("com"));

        emailsMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
