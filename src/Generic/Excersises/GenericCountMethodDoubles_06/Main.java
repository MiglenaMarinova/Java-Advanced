package Generic.Excersises.GenericCountMethodDoubles_06;



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        BoxCountDouble<Double> box = new BoxCountDouble<>();

        for (int i = 0; i < n; i++) {
            double number = Double.parseDouble(scanner.nextLine());
            box.add(number);
        }
        Double num = Double.parseDouble(scanner.nextLine());
        System.out.println(box.countGreaterThan(num));


    }
}
