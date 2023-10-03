package SetsAndMaps.Excersises;

import java.util.*;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String name = input.split("-")[0];
            String number = input.split("-")[1];

            phonebook.putIfAbsent(name, "");
            phonebook.put(name, number);

            input = scanner.nextLine();
        }
        String searchedName = scanner.nextLine();
        while (!searchedName.equals("stop")) {
            if (!phonebook.containsKey(searchedName)) {
                System.out.printf("Contact %s does not exist.\n", searchedName);

            } else {
                System.out.printf("%s -> %s\n", searchedName, phonebook.get(searchedName));
            }
            searchedName = scanner.nextLine();
        }

    }
}
