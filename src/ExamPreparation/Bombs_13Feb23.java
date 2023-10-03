package ExamPreparation;

import java.util.*;

public class Bombs_13Feb23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] effect = scanner.nextLine().split(", ");
        String[] casing = scanner.nextLine().split(", ");

        Deque<Integer> bombEffectQueue = new ArrayDeque<>();
        Deque<Integer> bombCasingStack = new ArrayDeque<>();

        for (int i = 0; i < effect.length; i++) {
            bombEffectQueue.offer(Integer.parseInt(effect[i]));
        }
        for (int i = 0; i < casing.length; i++) {
            bombCasingStack.push(Integer.parseInt(casing[i]));
        }
        TreeMap<String, Integer> bombMap = new TreeMap<>();
        bombMap.put("Datura Bombs", 0);
        bombMap.put("Cherry Bombs", 0);
        bombMap.put("Smoke Decoy Bombs", 0);

        int sum = 0;
        boolean isFull = false;
        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            sum = bombEffectQueue.peek() + bombCasingStack.peek();
            if (sum == 40){
                bombMap.put("Datura Bombs", bombMap.get("Datura Bombs") + 1);
                bombEffectQueue.poll();
                bombCasingStack.pop();
            }else if (sum == 60){
                bombMap.put("Cherry Bombs", bombMap.get("Cherry Bombs") + 1);
                bombEffectQueue.poll();
                bombCasingStack.pop();
            }else if (sum == 120){
                bombMap.put("Smoke Decoy Bombs", bombMap.get("Smoke Decoy Bombs") + 1);
                bombEffectQueue.poll();
                bombCasingStack.pop();
            }else{
                int toDecrease = bombCasingStack.pop() - 5;
                bombCasingStack.push(toDecrease);
            }
            if (bombMap.get("Datura Bombs") >= 3 && bombMap.get("Cherry Bombs") >= 3 && bombMap.get("Smoke Decoy Bombs") >= 3){
                isFull = true;
                break;
            }
        }
        if (isFull){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else{
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if (bombEffectQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else{
            System.out.print("Bomb Effects: ");
            for (int i = 0; i < bombEffectQueue.size() - 1; i++) {
                System.out.print(bombEffectQueue.poll() + ", ");
            }
            System.out.println(bombEffectQueue.poll());
        }
        if (bombCasingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else{
            System.out.print("Bomb Casings: ");
            for (int i = 0; i < bombCasingStack.size() - 1; i++) {
                System.out.print(bombCasingStack.poll() + ", ");
            }
            System.out.println(bombCasingStack.poll());
        }
        for (Map.Entry<String, Integer> entry : bombMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


    }
}
