package SetsAndMaps.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")){
            char first = input.charAt(0);
            if (Character.isDigit(first)){
                vip.add(input);
            }else{
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            char first = input.charAt(0);
            if (Character.isDigit(first)){
                vip.remove(input);
            }else{
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        int countGuests = vip.size() + regular.size();
        System.out.printf("%d%n", countGuests);
        if (!vip.isEmpty()){
            for (String name : vip){
                System.out.println(name);
            }
        }
        if (!regular.isEmpty()){
            for (String name : regular){
                System.out.println(name);
            }
        }
    }
}
