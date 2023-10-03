package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> backUrl = new ArrayDeque<>();
        ArrayDeque<String> forwardUrl = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("Home")) {
            if (input.equals("forward")) {
                if (!forwardUrl.isEmpty()){
                    System.out.println(forwardUrl.peek());
                    backUrl.push(forwardUrl.poll());
                }else{
                    System.out.println("no next URLs");
                }
            } else if (input.equals("back")) {
                if (backUrl.size() > 1){
                    forwardUrl.addFirst(backUrl.poll());
                    System.out.println(backUrl.peek());
                }else{
                    System.out.println("no previous URLs");
                }

            } else {
                backUrl.push(input);
                forwardUrl.clear();
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
