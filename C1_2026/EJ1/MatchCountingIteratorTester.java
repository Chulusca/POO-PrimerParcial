package Parciales1.C1_2026.EJ1;

import java.util.function.Function;
import java.util.function.Predicate;

public class MatchCountingIteratorTester {

    public static void main(String[] args) {
        // 1. Se instancia un iterador que recibe
        //    - Un vector de Integer
        //    - Una función que convierte de Integer a String usando dos dígitos
        //    - Un predicado de Integer que indica si el entero es par
        Integer[] intValues = {2, 3, 1, 8, 4};
        Function<Integer, String> intStrFn = n -> "%02d".formatted(n);
        Predicate<Integer> intPr = n -> n % 2 == 0;
        MatchCountingIterator<Integer, String> intStrIt =
                new MatchCountingIterator<>(intValues, intStrFn, intPr);

        System.out.println(intStrIt.getMatchCount()); // 0
        while (intStrIt.hasNext()) {
            String elem = intStrIt.next();
            int matchCount = intStrIt.getMatchCount();
            System.out.println("%s -> %d".formatted(elem, matchCount));
        }
        // 02 -> 1
        // 03 -> 1
        // 01 -> 1
        // 08 -> 2
        // 04 -> 3

        try {
            intStrIt.next();
        } catch (Exception ex) {
            System.out.println("Error"); // Error
        }

        // 2. Se instancia un iterador que recibe
        //    - Un vector de String
        //    - Una función que convierte de String a Integer usando la longitud
        //    - Un predicado de String que indica si empieza con 'a'
        String[] stringValues = {"hola", "a", "adios", "mundo"};
        Function<String, Integer> strIntFn = w -> w.length();
        Predicate<String> strPr = w -> w.startsWith("a");
        MatchCountingIterator<String, Integer> strIntIt =
                new MatchCountingIterator<>(stringValues, strIntFn, strPr);

        System.out.println(strIntIt.getMatchCount()); // 0
        while (strIntIt.hasNext()) {
            Integer elem = strIntIt.next();
            int matchCount = strIntIt.getMatchCount();
            System.out.println("%s -> %d".formatted(elem, matchCount));
        }
        // 4 -> 0
        // 1 -> 1
        // 5 -> 2
        // 5 -> 2
    }
}