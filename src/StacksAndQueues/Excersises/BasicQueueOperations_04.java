package StacksAndQueues.Excersises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int currentNum = Integer.parseInt(numbers[i]);
            numQueue.offer(currentNum);
        }
        if (!numQueue.isEmpty()) {
            for (int i = 1; i <= s; i++) {
                numQueue.poll();
            }
        }
        if (numQueue.contains(x)) {
            System.out.println("true");
        }else{
            if (numQueue.isEmpty()){
                System.out.println(0);
            }else{
                System.out.println(Collections.min(numQueue));
            }
        }
    }
}
