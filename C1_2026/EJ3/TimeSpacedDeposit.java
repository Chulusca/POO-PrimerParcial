package Parciales1.C1_2026.EJ3;

import java.time.LocalTime;

public class TimeSpacedDeposit extends IncreasingWeightDeposit{

    private int minMinutes;

    TimeSpacedDeposit(LocalTime opening, LocalTime closing, int maxWeight, int minMinutes){
        super(opening, closing, maxWeight);   // los tres suben por la cadena (el padre tambinn hace super)
        this.minMinutes = minMinutes;          // este es mío, lo guardo yo
    }

    public void store(DepositOperation op){
        if(lastStored != null && lastStored.getLocalTime().plusMinutes(minMinutes).isAfter(op.getLocalTime())){
            throw new CannotStoreException("Cannot store crate in depot");
        }
        super.store(op); //el last store no hace falta ya me lo guarda la clase padre
    }
}
