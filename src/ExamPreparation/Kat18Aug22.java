package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Kat18Aug22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] plateData = scanner.nextLine().split(",\\s+");
        String[] carData = scanner.nextLine().split(",\\s+");

        Deque<Integer> carsStack = new ArrayDeque<>();
        Deque<Integer> plateQueue = new ArrayDeque<>();

        for (int i = 0; i < carData.length; i++) {
            carsStack.push(Integer.parseInt(carData[i]));
        }
        for (int i = 0; i < plateData.length; i++) {
            plateQueue.offer(Integer.parseInt(plateData[i]));
        }
        int registeredCars = 0;
        int countPlates = 0;
        int days = 0;
        boolean allPlatesUsed = false;
        boolean allCarsRegistered = false;

        while (!plateQueue.isEmpty() && !carsStack.isEmpty()) {
            int currentPlatesCount = plateQueue.peek();
            int currentCarsCount = carsStack.peek();
            int platesNeeded = currentCarsCount * 2;
            if (platesNeeded == currentPlatesCount) {
                registeredCars += carsStack.pop();
                plateQueue.poll();
            } else if (platesNeeded < currentPlatesCount) {
                int defPlates = currentPlatesCount - platesNeeded;
                registeredCars += carsStack.pop();
                plateQueue.poll();
                plateQueue.offer(defPlates);
            } else  {
                int carsWithoutPlates = currentCarsCount - currentPlatesCount / 2;
                plateQueue.poll();
                registeredCars += carsStack.pop() - carsWithoutPlates;
                carsStack.offer(carsWithoutPlates);
            }
            days++;
            if (carsStack.isEmpty()){
                allCarsRegistered = true;
            }
            if (plateQueue.isEmpty()){
                allPlatesUsed = true;
            }
        }
        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);
        if (allCarsRegistered && !allPlatesUsed){
            int sumPlates = 0;
            for (Integer plate : plateQueue){
                sumPlates += plateQueue.poll();
            }
            System.out.printf("%d license plates remain!", sumPlates);
        }else if (!allCarsRegistered && allPlatesUsed){
            int sumCars = 0;
            for (Integer car : carsStack){
                sumCars += carsStack.pop();
            }
            System.out.printf("%d cars remain without license plates!", sumCars);
        }else{
            System.out.println("Good job! There is no queue in front of the KAT!");
        }
    }
}
