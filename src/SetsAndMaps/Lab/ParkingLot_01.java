package SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> carsSet = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            if (direction.equals("IN")){
                carsSet.add(carNumber);
            }else if(direction.equals("OUT")){
                carsSet.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (carsSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            for (String car : carsSet){
                System.out.println(car);
            }
        }

    }
}
