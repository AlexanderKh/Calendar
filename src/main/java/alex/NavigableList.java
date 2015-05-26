package alex;

import java.util.ArrayList;

public class NavigableList<T> extends ArrayList<T> {
    public T getPreviousFor(int i){
        return (i > 0) ? get(i - 1) : null;
    }
    public T getNextFor(int i){
        return (i + 1 < this.size()) ? get(i + 1) : null;
    }
}
