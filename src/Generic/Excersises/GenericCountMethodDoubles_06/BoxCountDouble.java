package Generic.Excersises.GenericCountMethodDoubles_06;

import java.util.ArrayList;
import java.util.List;

public class BoxCountDouble <T extends Comparable<T>>{

    public List<T> elements;

    public BoxCountDouble() {
        this.elements = new ArrayList<>();
    }
    public void add(T element) {
        this.elements.add(element);
    }
    public int countGreaterThan (T element){
        int count = 0;
        for (T elementInList : this.elements){
            if (elementInList.compareTo(element) == 1){
                count ++;
            }
        }
        return count;
    }
}
