package ExamPreparation;

import java.util.*;

public class ClimbThePeaks_14Dec22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dailyPortion = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        int[] dailyStamina = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        LinkedHashMap<String, Integer> peaksToClimb = new LinkedHashMap<>();
        peaksToClimb.put("Vihren", 80);
        peaksToClimb.put("Kutelo", 90);
        peaksToClimb.put("Banski Suhodol", 100);
        peaksToClimb.put("Polezhan", 60);
        peaksToClimb.put("Kamenitza", 70);

        List<String> conqueredPeaks = new ArrayList<>();

        ArrayDeque<Integer> portionStack = new ArrayDeque<>();
        for (int i = 0; i < dailyPortion.length; i++) {
            portionStack.push(dailyPortion[i]);
        }
        ArrayDeque<Integer> staminaQueue = new ArrayDeque<>();
        for (int i = 0; i < dailyStamina.length; i++) {
            staminaQueue.offer(dailyStamina[i]);
        }

        int sumFood = 0;
        while (!portionStack.isEmpty()){
           sumFood = portionStack.peek() + staminaQueue.peek();
           if (!peaksToClimb.isEmpty() ){
               for (String peak : peaksToClimb.keySet()) {
                   int neededFood = peaksToClimb.get(peak);
                   if (sumFood >= neededFood){
                       conqueredPeaks.add(peak);
                       peaksToClimb.remove(peak);
                       break;
                   }else{
                       break;
                   }
               }
           }
           portionStack.pop();
           staminaQueue.poll();
        }
        if (peaksToClimb.isEmpty()){
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        }else{
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (conqueredPeaks.size() > 0){
            System.out.println("Conquered peaks:");
            for (String name : conqueredPeaks){
                System.out.println(name);
            }
        }
    }
}
