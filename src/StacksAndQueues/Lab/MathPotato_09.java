package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] childrenList = scanner.nextLine().split("\\s+");
        PriorityQueue<String> childrenQueue = new PriorityQueue<>();
        Collections.addAll(childrenQueue, childrenList);

        int passes = Integer.parseInt(scanner.nextLine());

        int cycle = 1;
        while (childrenQueue.size() > 1){
            for (int i = 1; i < passes ; i++) {
               String currentChild = childrenQueue.poll();
               childrenQueue.offer(currentChild);
            }
            if (isPrime(cycle)){
                System.out.println("Prime " + childrenQueue.peek());

            }else{
                String removedChild = childrenQueue.poll();
                System.out.println("Removed " + removedChild);
            }
            cycle++;
        }
        String lastChild = childrenQueue.peek();
        System.out.println("Last is " + lastChild);
//        while (childrenQueue.size() > 1){
//            for (int i = 1; i < passes; i++) {
//                String currentChild = childrenQueue.poll();
//                childrenQueue.offer(currentChild);
//            }
//            if (isPrime(cycle)){
//                System.out.println("Prime " + childrenQueue.peek());
//            }else{
//                String removedChild = childrenQueue.poll();
//                System.out.println("Removed " + removedChild);
//            }
//            cycle++;
//        }
//        String lastOne = childrenQueue.peek();
//        System.out.println("Last is " + lastOne);
    }

    private static boolean isPrime (int num){
        if (num == 1){
            return false;
        }
        for (int i = 2; i < num ; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
