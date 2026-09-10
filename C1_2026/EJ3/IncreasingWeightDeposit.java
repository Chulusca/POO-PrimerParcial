package Parciales1.C1_2026.EJ3;

import java.time.LocalTime;

public class IncreasingWeightDeposit extends Deposit{

    protected DepositOperation lastStored;

    public IncreasingWeightDeposit(LocalTime opening, LocalTime closing, int maxWeight) {
        super(opening, closing, maxWeight);
    }

    @Override
    public void store(DepositOperation op){
        if (lastStored != null && op.getWeight() < lastStored.getWeight()) {
            throw new CannotStoreException("Cannot store crate in depot");
        }
        super.store(op);
        lastStored = op;
    }

}
