package Parciales1.C1_2026.EJ1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.function.Predicate;

public class MatchCountingIterator<T, R> implements Iterator<R> {
    private T[] array;
    private Function<T, R> function;
    private Predicate<T> predicate;

    private int current;
    private int matchCount;

    public MatchCountingIterator(T[] array, Function<T, R> function, Predicate<T> predicate){
        this.array = array;
        this.function = function;
        this.predicate = predicate;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public boolean hasNext(){
        return current < array.length;
    }

    @Override
    public R next(){
        //Paso 1 chequear que quede algo (devolver exception si no)
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // Paso 2 Aplicar Predicate a T
        if ( predicate.test(array[current]) ) matchCount++;
        R returnValue = function.apply(array[current]);
        current++;
        return returnValue;
    }
}
