package StacksAndQueues.Excersises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nXs = scanner.nextLine().split("\\s+");
        int nElements = Integer.parseInt(nXs[0]);
        int popElements = Integer.parseInt(nXs[1]);
        int presentElement = Integer.parseInt(nXs[2]);

        String[] numbers = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numStack = new ArrayDeque<>();

        for (int i = 0; i < nElements; i++) {
            numStack.push(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < popElements; i++) {
            numStack.pop();
        }
        if (numStack.isEmpty()) {
            System.out.println(0);
        } else {
            int minvalue = Integer.MAX_VALUE;
            for (int current : numStack) {
                if (current == presentElement) {
                    System.out.println("true");
                    return;
                }else{
                    for (int minNum : numStack){
                        if (minNum < minvalue){
                            minvalue=minNum;
                        }
                    }
                }
            }
            System.out.println(minvalue);

        }
    }
}
