package Parciales1.C1_2026.EJ2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FlightLuggage{
    private int allowance;
    private List<Luggage> luggages = new ArrayList<>();

    FlightLuggage(int allowance){
        this.allowance = allowance;
    }

    //Metodos del tester

    public void setAllowance(int allowance){
        this.allowance = allowance;
    }
    public int getAllowance() {
        return this.allowance;
    }
    public void checkIn(String tag, int weight){
        Luggage newLugagge = new Luggage(tag, weight, this);
        luggages.add(newLugagge);
    }

    //Metodos de la consigna.

    public List<Luggage> luggages(){
        return new ArrayList<>(luggages);
    }

    public List<Luggage> luggagesByWeightDesc(){ //en orden descendente por peso y desempata alfabétic por tag
        List<Luggage> copia = new ArrayList<>(luggages);
        copia.sort(
                Comparator.comparingInt(Luggage::getWeight).reversed()
                        .thenComparing(Luggage::getTag)
        );
        return copia;
    }

    public List<Luggage> luggagesByTagAsc(){ //en orden ascendente por tag y desempata descendentemente por peso
        List<Luggage> copia = new ArrayList<>(luggages);
        copia.sort(
                Comparator.comparing(Luggage::getTag)
                        .thenComparing(Luggage::getWeight, Comparator.reverseOrder())
        );
        return copia;
    }

}
