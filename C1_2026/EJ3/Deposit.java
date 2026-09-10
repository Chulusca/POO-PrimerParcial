package Parciales1.C1_2026.EJ3;

import java.time.LocalTime;

public class Deposit {
    private LocalTime opening;
    private LocalTime closing;
    private int maxWeight;
    private int crates;

    Deposit(LocalTime opening, LocalTime closing, int maxWeight){
        this.opening = opening;
        this.closing = closing;
        this.maxWeight = maxWeight;
    }

    public void store(DepositOperation op){
        if(op.getWeight() <= 0 || op.getWeight() > maxWeight || op.getLocalTime().isAfter(closing) || op.getLocalTime().isBefore(opening) ){
            throw new CannotStoreException("Cannot store crate in depot");
        }
        crates++;
    }
    public int getCrates(){
        return this.crates;
    }
}
