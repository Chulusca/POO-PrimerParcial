package Parciales1.C1_2026.EJ3;

import java.time.LocalTime;

public class DepositOperation {
    private final String description;
    private final int weight;
    private final LocalTime localTime;

    public DepositOperation(String description, int weight, LocalTime
            localTime) {
        this.description = description;
        this.weight = weight;
        this.localTime = localTime;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
}
