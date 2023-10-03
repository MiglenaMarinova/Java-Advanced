package SetsAndMaps.Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <=n ; i++) {
            String input = scanner.nextLine();

            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            countries.get(country).add(city);
            continents.put(continent, countries);

            System.out.println();

        }
        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> mapEntry : continents.entrySet()) {
            System.out.println(mapEntry.getKey() + ":");
            for (Map.Entry<String, ArrayList<String>> entry : mapEntry.getValue().entrySet()) {
                System.out.print("  " + entry.getKey() + " -> ");
                System.out.println(String.join(", ", entry.getValue()));
            }

        }

    }
}
