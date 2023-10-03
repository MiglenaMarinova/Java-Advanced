package DefiningClasses.Excersises.PokemonTrainer;

import java.util.List;

public class Trainer {
//name, a number of badges, and a collection of pokemon
    private String name;
    private int badget;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.badget = 0;
        this.pokemons = pokemons;
    }

    public int getBadget() {
        return badget;
    }
    public void commandExecuting(String command){
        if (isExist(command)){
            badget += 1;
        }else{
            for (int i = 0; i < pokemons.size(); i++) {
                pokemons.get(i).setHealth(pokemons.get(i).getHealth() - 10);
                if (pokemons.get(i).getHealth() <= 0){
                    pokemons.remove(i);
                    i--;
                }
            }
        }
    }
    private  boolean isExist(String command){
        for (Pokemon pokemon : pokemons){
            if (pokemon.getElement().equals(command)){
                return  true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + badget + " " +pokemons.size();
    }
}
