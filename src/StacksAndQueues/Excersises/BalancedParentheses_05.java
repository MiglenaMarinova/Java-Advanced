package StacksAndQueues.Excersises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] parentheses = scanner.nextLine().toCharArray();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        if (parentheses.length > 0){
            for (int i = 0; i < parentheses.length; i++) {
                char currentChar = parentheses[i];
                if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                    queue.offer(currentChar);
                }else  if (currentChar == ')' || currentChar == ']' || currentChar == '}'){
                    stack.push(currentChar);
                }
            }
        }
        boolean notBalanced = false;

        if (!queue.isEmpty()){
            for (int i = 0; i < queue.size(); i++) {
                char open = queue.poll();
                char close = stack.pop();
                if (open == '(' && close != ')' || open == '[' && close != ']' || open == '{' && close != '}'){
                    notBalanced = true;
                }
            }
        }
        if (notBalanced){
            System.out.println("NO");
        }else{
            System.out.println("YES");

        }
    }
}
