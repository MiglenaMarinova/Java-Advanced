package Exam18Feb2023;

import java.util.*;

public class ApocalypsePreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] textiles = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] medicaments = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        Deque<Integer> textilesQueue = new ArrayDeque<>();
        Deque<Integer> medicamentsStack = new ArrayDeque<>();

        for (int i = 0; i < textiles.length; i++) {
            textilesQueue.offer(textiles[i]);
        }
        for (int i = 0; i < medicaments.length; i++) {
            medicamentsStack.push(medicaments[i]);
        }
        int sum = 0;
        boolean textilesIsEmty = false;
        boolean medicamentsIsEmty = false;
        int newValue = 0;
        TreeMap<String, Integer> createdItems = new TreeMap<>();
        while (!textilesQueue.isEmpty() && !medicamentsStack.isEmpty()) {
            sum = textilesQueue.peek() + medicamentsStack.peek();
            if (sum == 30) {
                createdItems.putIfAbsent("Patch", 0);
                createdItems.put("Patch", createdItems.get("Patch") + 1);
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 40) {
                createdItems.putIfAbsent("Bandage", 0);
                createdItems.put("Bandage", createdItems.get("Bandage") + 1);
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum == 100) {
                createdItems.putIfAbsent("MedKit", 0);
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                textilesQueue.poll();
                medicamentsStack.pop();
            } else if (sum > 100) {
                int remainingResources = sum - 100;
                createdItems.putIfAbsent("MedKit", 0);
                createdItems.put("MedKit", createdItems.get("MedKit") + 1);
                textilesQueue.poll();
                medicamentsStack.pop();
                newValue = remainingResources + medicamentsStack.pop();
                medicamentsStack.push(newValue);
            } else {
                textilesQueue.poll();
                newValue = medicamentsStack.pop() + 10;
                medicamentsStack.push(newValue);
            }
            if (textilesQueue.isEmpty()) {
                textilesIsEmty = true;
            }
            if (medicamentsStack.isEmpty()) {
                medicamentsIsEmty = true;
            }
        }
        if (textilesIsEmty && !medicamentsIsEmty) {
            System.out.println("Textiles are empty.");
        } else if (!textilesIsEmty && medicamentsIsEmty) {
            System.out.println("Medicaments are empty.");
        } else {
            System.out.println("Textiles and medicaments are both empty.");
        }
        if (!createdItems.isEmpty()){

            createdItems.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed()
                            .thenComparing(Map.Entry.comparingByKey()))
                    .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
        }


        if (medicamentsStack.size() > 0) {
            System.out.print("Medicaments left: ");
            for (int i = 0; i < medicamentsStack.size() - 1; i++) {
                System.out.print(medicamentsStack.pop() + ", ");
            }
            System.out.print(medicamentsStack.pop());
        }
        if (textilesQueue.size() > 0){
            System.out.print("Textiles left: ");
            for (int i = 0; i < textilesQueue.size() - 1; i++) {
                System.out.print(textilesQueue.poll() + ", ");
            }
            System.out.print(textilesQueue.poll());
        }

    }
}

