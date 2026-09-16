package Parciales1.C2_2025.EJ3;

//Modificable

public class Update {
    private final String description;
    private final double gb;
    private final Priority priority;

    public Update(String description, double gb, Priority priority) {
        this.description = description;
        this.gb = gb;
        this.priority = priority;
    }

    public double getGb(){
        return this.gb;
    }
    public Priority getPriority(){
        return this.priority;
    }

    @Override
    public String toString() {
        return "Update %s (%s GB) is %s".formatted(description, gb, priority);
    }

}
