package ExamPreparation;

import java.util.*;

public class ItsChocolateTime25Jun22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQueue = new ArrayDeque<>();
        Deque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(milkQueue::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoStack::push);
//Milk Chocolate	30
//Dark Chocolate	50
//Baking Chocolate	100

        boolean isDone = false;
        double sum = 0;
        double percentage = 0;
        TreeMap<String, Integer> products = new TreeMap<>();

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {
            sum = milkQueue.peek() + cacaoStack.peek();
            percentage = cacaoStack.peek() / sum * 100;
            if (percentage == 30) {
                products.putIfAbsent("Milk Chocolate", 0);
                products.put("Milk Chocolate", products.get("Milk Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (percentage == 50) {
                products.putIfAbsent("Dark Chocolate", 0);
                products.put("Dark Chocolate", products.get("Dark Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else if (percentage == 100) {
                products.putIfAbsent("Baking Chocolate", 0);
                products.put("Baking Chocolate", products.get("Baking Chocolate") + 1);
                milkQueue.poll();
                cacaoStack.pop();
            } else {
                cacaoStack.pop();
                milkQueue.offer(milkQueue.poll() + 10);
            }
            if (products.containsKey("Milk Chocolate") && products.containsKey("Dark Chocolate") && products.containsKey("Baking Chocolate")){
                isDone = true;
            }
        }
        if (isDone){
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        }else{
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (!products.isEmpty()){
            for (Map.Entry<String, Integer> entry : products.entrySet()) {
                System.out.println("# " + entry.getKey() + " --> " + entry.getValue());

            }

        }

    }
}
