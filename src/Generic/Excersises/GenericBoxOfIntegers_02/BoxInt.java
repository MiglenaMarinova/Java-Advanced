package Generic.Excersises.GenericBoxOfIntegers_02;

import java.util.ArrayList;
import java.util.List;

public class BoxInt <T>{
    private List<T> elements;

    public BoxInt() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T element : elements) {
            builder.append(element.getClass().getName()).append(": ").append(element).append("\n");
        }
        return builder.toString();
    }
}
