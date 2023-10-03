package Generic.Excersises.GenericBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        for (int i = 1; i <=n ; i++) {
            String inputText = scanner.nextLine();
            box.add(inputText);
        }
        System.out.println(box);
    }
}
