package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenList = scanner.nextLine().split("\\s+");
        ArrayDeque<String> childrenQueue = new ArrayDeque<>();
        Collections.addAll(childrenQueue, childrenList);

        int passes = Integer.parseInt(scanner.nextLine());

        while (childrenQueue.size() > 1){
            for (int i = 1; i < passes; i++) {
                String currentChild = childrenQueue.poll();
                childrenQueue.offer(currentChild);
            }
            String toRemove = childrenQueue.poll();
            System.out.println("Removed " + toRemove);
        }
        String lastOne = childrenQueue.peek();
        System.out.println("Last is " + lastOne);
    }
}
