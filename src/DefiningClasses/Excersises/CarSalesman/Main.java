package DefiningClasses.Excersises.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEngine = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 1; i <= countEngine; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);
            int displacement = 0;
            String efficientcy = null;
            if (engineData.length == 4) {
                displacement = Integer.parseInt(engineData[2]);
                efficientcy = engineData[3];
            } else if (engineData.length == 3) {
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                } else if (Character.isLetter(engineData[2].charAt(0))) {
                    efficientcy = engineData[2];
                }

            }
            Engine engine = new Engine(model, power, displacement, efficientcy);
            engines.add(engine);
        }
        int countCar = Integer.parseInt(scanner.nextLine());
        for (int carCount = 1; carCount <= countCar; carCount++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String carModel = carData[0];
            String enginModel = carData[1];
            int weigth = 0;
            String color = null;
            if (carData.length == 4) {
                carModel = carData[0];
                enginModel = carData[1];
                weigth = Integer.parseInt(carData[2]);
                color = carData[3];
            } else if (carData.length == 3) {
                if (Character.isDigit(carData[2].charAt(0))) {
                    weigth = Integer.parseInt(carData[2]);
                }else if (Character.isLetter(carData[2].charAt(0))){
                    color = carData[2];
                }
            }
            Engine carEngine = null;
            for (Engine engine : engines){
                if (enginModel.equals(engine.getModel())){
                    carEngine = engine;
                    break;
                }
            }
            Car car = new Car(carModel, carEngine, weigth, color);
            System.out.println(car);
        }
    }
}
