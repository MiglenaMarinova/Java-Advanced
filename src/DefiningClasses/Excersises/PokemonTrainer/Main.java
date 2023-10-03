package DefiningClasses.Excersises.PokemonTrainer;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, ArrayList<Pokemon>> pokemonByTrainer = new LinkedHashMap<>();

//        "{TrainerName} {PokemonName} {PokemonElement} {PokemonHealth}"
        while (!input.equals("Tournament")){
            String trainerName = input.split("\\s+")[0];
            String pokemonName = input.split("\\s+")[1];
            String element = input.split("\\s+")[2];
            int health = Integer.parseInt(input.split("\\s+")[3]);

            Pokemon pokemon = new Pokemon(pokemonName, element, health);

            pokemonByTrainer.putIfAbsent(trainerName, new ArrayList<>());
            pokemonByTrainer.get(trainerName).add(pokemon);


            input = scanner.nextLine();
        }
        List<Trainer> trainerList = pokemonByTrainer.entrySet()
                .stream()
                .map(t -> new Trainer(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")){

            for (Trainer trainer : trainerList){
                trainer.commandExecuting(command);
            }
            command= scanner.nextLine();
        }
        trainerList.stream()
                .sorted(Comparator.comparingInt(Trainer::getBadget).reversed())
                .forEach(System.out ::println);

    }
}
