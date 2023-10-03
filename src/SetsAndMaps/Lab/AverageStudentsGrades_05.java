package SetsAndMaps.Lab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        int countStudents = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countStudents; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            Double grade = Double.parseDouble(input[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);
        }
        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double sum = 0;
            for (int grade = 0; grade <= entry.getValue().size() - 1; grade++) {
                Double current = entry.getValue().get(grade);
                sum += current;
                System.out.printf("%.2f ", current);
            }
            System.out.printf("(avg: %.2f)%n", sum / entry.getValue().size());

        }



    }
}
