package StacksAndQueues.Excersises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            int currentNum = Integer.parseInt(numbers[i]);
            numStack.push(currentNum);
        }
        for (int number : numStack){
            System.out.print(number + " ");
        }


    }
}
