package DefiningClasses.Excersises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemonList;
    private List<Parent> parentList;
    private List<Child> childList;
    private Car car;

    public Person() {
        this.pokemonList = new ArrayList<>();
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
    }

    public Person(String name, Company company, List<Pokemon> pokemonList, List<Parent> parentList, List<Child> childList, Car car) {
        this.name = name;
        this.company = company;
        this.pokemonList = pokemonList;
        this.parentList = parentList;
        this.childList = childList;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parent> getParentList() {
        return parentList;
    }

    public List<Child> getChildList() {
        return childList;
    }

    public Car getCar() {
        return car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public void setParentList(List<Parent> parentList) {
        this.parentList = parentList;
    }

    public void setChildList(List<Child> childList) {
        this.childList = childList;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        data.append("Company:").append(System.lineSeparator());
        if (company != null){
            data.append(company).append(System.lineSeparator());
        }
        data.append("Car:").append(System.lineSeparator());
        if (car != null){
            data.append(car).append(System.lineSeparator());
        }
        data.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemonList){
            data.append(pokemon).append(System.lineSeparator());
        }
        data.append("Parents:").append(System.lineSeparator());
        for (Parent parent : parentList){
            data.append(parent).append(System.lineSeparator());
        }
        data.append("Children:").append(System.lineSeparator());
        for (Child child : childList){
            data.append(child).append(System.lineSeparator());
        }

        return data.toString();
    }
}
