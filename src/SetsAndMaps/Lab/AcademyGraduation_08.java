package SetsAndMaps.Lab;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = Integer.parseInt(scanner.nextLine());

        TreeMap<String, ArrayList<Double>> students = new TreeMap<>();

        for (int i = 1; i <= studentCount ; i++) {
            String name = scanner.nextLine();
            String[] gradeInput = scanner.nextLine().split("\\s+");

            if (!students.containsKey(name)){
                students.put(name, new ArrayList<>());
            }
            ArrayList<Double> studentGrades = students.get(name);
            for (int j = 0; j < gradeInput.length; j++) {
              studentGrades.add(Double.parseDouble(gradeInput[j]));
            }
            students.put(name, studentGrades);
        }
        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            System.out.print(entry.getKey() + " is graduated with ");
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sum += entry.getValue().get(i);
            }
            System.out.println(sum / entry.getValue().size());
        }

    }
}
