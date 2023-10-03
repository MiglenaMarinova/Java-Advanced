package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binary = new ArrayDeque<>();


        if (decimal == 0){
            System.out.println(0);
        }else {
            while (decimal != 0){
                int left = decimal % 2;
                binary.push(left);
                decimal = decimal / 2;
            }
        }

        int binarySize = binary.size();
        for (int i = 0; i < binarySize; i++) {
            System.out.print(binary.pop());
        }
    }
}
