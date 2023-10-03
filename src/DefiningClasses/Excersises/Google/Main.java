package DefiningClasses.Excersises.Google;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Person> personMap = new HashMap<>();

        while (!input.equals("End")) {
            String name = input.split("\\s+")[0];
            if (!personMap.containsKey(name)){
                personMap.put(name, new Person());
            }
            String command = input.split("\\s+")[1];

            switch (command) {
                case "company":
                    String companyName = input.split("\\s+")[2];
                    String department = input.split("\\s+")[3];
                    double salary = Double.parseDouble(input.split("\\s+")[4]);
                    Company company = new Company(companyName, department, salary);
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = input.split("\\s+")[2];
                    String pokemonType = input.split("\\s+")[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = input.split("\\s+")[2];
                    String parentBday = input.split("\\s+")[3];
                    Parent parent = new Parent(parentName, parentBday);
                    personMap.get(name).getParentList().add(parent);
                    break;
                case "children":
                    String childName = input.split("\\s+")[2];
                    String childBday = input.split("\\s+")[3];
                    Child child = new Child(childName, childBday);
                    personMap.get(name).getChildList().add(child);
                    break;
                case "car":
                    String carModel = input.split("\\s+")[2];
                    int speed = Integer.parseInt(input.split("\\s+")[3]);
                    Car car = new Car(carModel, speed);
                    personMap.get(name).setCar(car);
                    break;
            }


            input = scanner.nextLine();
        }
        String inputName = scanner.nextLine();
        System.out.println(inputName);

        Person personData = personMap.get(inputName);
        System.out.println(personData);

    }
}
