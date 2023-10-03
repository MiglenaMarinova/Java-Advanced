package StacksAndQueues.Excersises;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParenthesesNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<Character> openStack = new ArrayDeque<>();

        boolean isBalanced = false;
        for (char symbol : input.toCharArray()){
            if (symbol == '(' || symbol == '[' ||symbol == '{'){
                openStack.push(symbol);
            }else if (symbol == ')' || symbol == ']' ||symbol == '}'){
                if (openStack.isEmpty()){
                    isBalanced = false;
                    break;
                }
                char lastOpen = openStack.pop();
                if (lastOpen == '(' && symbol == ')'){
                    isBalanced = true;
                }else if (lastOpen == '[' && symbol == ']'){
                    isBalanced = true;
                }else if(lastOpen == '{' && symbol == '}'){
                    isBalanced = true;
                }else{
                    isBalanced = false;
                    break;
                }
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
