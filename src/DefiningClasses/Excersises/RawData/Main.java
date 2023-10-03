package DefiningClasses.Excersises.RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Car>> carsByCargoType = new HashMap<>();

        for (int i = 0; i <= rows - 1 ; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            int speed = Integer.parseInt(carData[1]);
            int power = Integer.parseInt(carData[2]);
            int weight = Integer.parseInt(carData[3]);
            String type = carData[4];
            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            List<Tire> tireList = new ArrayList<>();
            for (int tireItem = 5; tireItem < 12; tireItem+=2) {
                Tire currentTire = new Tire(Double.parseDouble(carData[tireItem]), Integer.parseInt(carData[tireItem + 1]));
                tireList.add(currentTire);
            }
            Car currentCar = new Car(model, engine, cargo, tireList);
            carsByCargoType.putIfAbsent(type, new ArrayList<>());
            carsByCargoType.get(type).add(currentCar);

        }
        String command = scanner.nextLine();
        carsByCargoType.get(command).forEach(car -> car.findCar(command));
    }
}
