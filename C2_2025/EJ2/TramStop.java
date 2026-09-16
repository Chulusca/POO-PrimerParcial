package Parciales1.C2_2025.EJ2;

public class TramStop {
    private final String name;
    private int plusMinutes;

    public TramStop(String name, int plusMinutes) {
        this.name = name;
        this.plusMinutes = plusMinutes;
    }

    public int getPlusMinutes() {
        return plusMinutes;
    }

    public void setPlusMinutes(int plusMinutes) {
        this.plusMinutes = plusMinutes;
    }

    @Override
    public String toString() {
        return "Tram Stop %s +%smin".formatted(name, plusMinutes);
    }

}
