package Parciales1.C1_2026.EJ2;

public class Luggage {
    private final String tag;
    private final int weight;
    private final FlightLuggage system;

    Luggage(String tag, int weight, FlightLuggage system) {
        this.tag = tag;
        this.weight = weight;
        this.system = system;
    }
    public String getTag() {
        return tag;
    }
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        int allowance = system.getAllowance();
        return "Luggage %s <> %d kg <> %s (Allowance: %d kg)".formatted(
                tag,
                weight,
                weight <= allowance ? "OK" : "EXCESS",
                allowance);
    }

}
