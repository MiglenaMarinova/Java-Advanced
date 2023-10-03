package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> num = new ArrayDeque<>();
        Collections.addAll(num, input);

        while (num.size() > 1){
            int firstNum = Integer.parseInt(num.pop());
            String operator = num.pop();
            int secondNum = Integer.parseInt(num.pop());
            int result = 0;
            if (operator.equals("+")){
                result = firstNum + secondNum;
            }else{
                result = firstNum - secondNum;
            }
            num.push(String.valueOf(result));
        }
        System.out.println(num.peek());
    }
}
