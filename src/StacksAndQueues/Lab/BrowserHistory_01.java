package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> urls = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentUrl = "";

        while (!input.equals("Home")){
            if (input.equals("back")){
                if (urls.size() > 1){
                    urls.pop();
                    currentUrl = urls.peek();
                    System.out.println(currentUrl);
                }else{
                    System.out.println("no previous URLs");
                }
            }else{
                urls.push(input);
                currentUrl = urls.peek();
                System.out.println(currentUrl);
            }
            input = scanner.nextLine();
        }
    }
}
