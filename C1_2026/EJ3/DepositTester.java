package Parciales1.C1_2026.EJ3;

import java.time.LocalTime;

public class DepositTester {

    public static void main(String[] args) {
        // Ejemplo de uso de la clase java.time.LocalTime
        System.out.println(LocalTime.of(18, 10).isAfter(LocalTime.of(17, 50)));   // true
        System.out.println(LocalTime.of(18, 10).isBefore(LocalTime.of(17, 50)));  // false
        System.out.println(LocalTime.of(18, 10).plusMinutes(60));                 // 19:10

        DepositOperation throne =
                new DepositOperation("Royal Throne", 40, LocalTime.of(9, 0));
        DepositOperation armor =
                new DepositOperation("Knight Armor", 55, LocalTime.of(10, 15));
        DepositOperation torch =
                new DepositOperation("Medieval Torch", 55, LocalTime.of(10, 20));
        DepositOperation banner =
                new DepositOperation("Castle Banner", 12, LocalTime.of(10, 30));

        // Depósito básico: 08:00–13:00, hasta 60 kg
        // ..........A.......... depot = new ..........B..........(...)
        Deposit depot = new Deposit(                       // ← nombres A y B a definir
                LocalTime.of(8, 0), LocalTime.of(13, 0), 60);

        depot.store(throne);
        System.out.println(depot.getCrates());   // 1
        depot.store(armor);
        System.out.println(depot.getCrates());   // 2

        try { // Falla porque el peso no es positivo
            depot.store(new DepositOperation("Fake", 0, LocalTime.of(10, 35)));
        } catch (CannotStoreException ex) {
            System.out.println(ex.getMessage());   // Cannot store crate in depot
        }

        try { // Falla porque la hora está fuera del rango permitido
            depot.store(new DepositOperation("Door", 50, LocalTime.of(14, 0)));
        } catch (CannotStoreException ex) {
            System.out.println(ex.getMessage());   // Cannot store crate in depot
        }

        // Depósito con peso creciente
        IncreasingWeightDeposit incrWeightDepot = new IncreasingWeightDeposit(   // ← nombre a definir
                LocalTime.of(8, 0), LocalTime.of(13, 0), 60);

        incrWeightDepot.store(throne);
        System.out.println(incrWeightDepot.getCrates());   // 1
        incrWeightDepot.store(armor);
        System.out.println(incrWeightDepot.getCrates());   // 2
        incrWeightDepot.store(torch);
        System.out.println(incrWeightDepot.getCrates());   // 3

        try { // Falla porque 12 es menor que el peso del último depositado
            incrWeightDepot.store(banner);
        } catch (CannotStoreException ex) {
            System.out.println(ex.getMessage());   // Cannot store crate in depot
        }

        // Depósito con peso creciente Y separación mínima de minutos
        TimeSpacedDeposit timeSpacedDepot = new TimeSpacedDeposit(   // ← nombre a definir
                LocalTime.of(8, 0), LocalTime.of(13, 0), 60, 15);

        timeSpacedDepot.store(throne);
        System.out.println(timeSpacedDepot.getCrates());   // 1
        timeSpacedDepot.store(armor);
        System.out.println(timeSpacedDepot.getCrates());   // 2

        try { // Falla porque no pasaron 15 minutos desde el último
            timeSpacedDepot.store(torch);
        } catch (CannotStoreException ex) {
            System.out.println(ex.getMessage());   // Cannot store crate in depot
        }
    }
}