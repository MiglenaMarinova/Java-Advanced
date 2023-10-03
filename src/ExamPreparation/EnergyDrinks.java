package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] caffeine = scanner.nextLine().split(",\\s+");
        String[] drinks = scanner.nextLine().split(",\\s+");

        Deque<Integer> caffeineStack = new ArrayDeque<>();
        Deque<Integer> drinkQueue = new ArrayDeque<>();

        for (int i = 0; i < caffeine.length; i++) {
            caffeineStack.push(Integer.parseInt(caffeine[i]));
        }
        for (int i = 0; i < drinks.length; i++) {
            drinkQueue.offer(Integer.parseInt(drinks[i]));
        }
        int sum = 0;

        int limitCaffeine = 300;

        int currentCaffeine = 0;


        while (!caffeineStack.isEmpty() && !drinkQueue.isEmpty()) {
            sum = caffeineStack.peek() * drinkQueue.peek();
            caffeineStack.pop();

            if (sum + currentCaffeine <= limitCaffeine) {

                drinkQueue.poll();
                currentCaffeine += sum;
            } else {
                drinkQueue.offer(drinkQueue.poll());
                if (currentCaffeine - 30 > 30) {
                    currentCaffeine -= 30;
                }
            }
        }

        if (drinkQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            System.out.print("Drinks left: ");
            for (int i = 0; i < drinkQueue.size() - 1; i++) {
                System.out.print(drinkQueue.poll() + ", ");
                System.out.println(drinkQueue.poll());
            }
        }
        System.out.printf("Stamat is going to sleep with %d mg caffeine.", currentCaffeine );


    }
}
