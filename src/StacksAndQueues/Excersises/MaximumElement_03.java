package StacksAndQueues.Excersises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbersStack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commandParts = scanner.nextLine().split("\\s+");
            String command = commandParts[0];
            if (command.contains("1")){
                numbersStack.push(Integer.parseInt(commandParts[1]));
            }else if (command.equals("2")){
                numbersStack.pop();
            }else if (command.equals("3")){
                System.out.println(Collections.max(numbersStack));
            }
        }
    }
}
