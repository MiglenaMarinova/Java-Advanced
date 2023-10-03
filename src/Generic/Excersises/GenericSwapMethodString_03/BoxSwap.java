package Generic.Excersises.GenericSwapMethodString_03;

import java.util.ArrayList;
import java.util.List;

public class BoxSwap<T> {
    private List<T> elements;

    public BoxSwap() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }
    public void swap (int firstIndex, int secondIndex){
        T firstIndexElement = this.elements.get(firstIndex);
        T secondIndexElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex, secondIndexElement);
        this.elements.set(secondIndex, firstIndexElement);
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
