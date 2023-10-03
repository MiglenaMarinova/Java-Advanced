package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (printerQueue.size() == 0){
                    System.out.println("Printer is on standby");
                }else{
                    String toPrint = printerQueue.poll();
                    System.out.println("Canceled " + toPrint);
                }
            }else{
                printerQueue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String output : printerQueue) {
            System.out.println(output);

        }

    }
}
