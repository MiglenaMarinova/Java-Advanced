package DefiningClasses.Excersises.Google;

public class Parent {
    private String parentName;
    private String parentBday;

    public Parent(String parentName, String parentBday) {
        this.parentName = parentName;
        this.parentBday = parentBday;
    }

    @Override
    public String toString() {
        return parentName + " " + parentBday;
    }
}
