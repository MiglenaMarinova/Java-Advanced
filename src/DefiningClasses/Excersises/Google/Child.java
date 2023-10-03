package DefiningClasses.Excersises.Google;

public class Child {
    private String childName;
    private String childBday;

    public Child(String childName, String childBday) {
        this.childName = childName;
        this.childBday = childBday;
    }

    public String getChildName() {
        return childName;
    }

    public String getChildBday() {
        return childBday;
    }

    @Override
    public String toString() {
        return childName + " " + childBday;
    }
}
