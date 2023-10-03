package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length() ; i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '('){
                stack.push(i);
            }else if (currentChar == ')'){
                int sratrIndex = stack.pop();
                int endIndex = i;

                String substring = input.substring(sratrIndex, endIndex + 1);
                System.out.println(substring);
            }

        }
    }
}
