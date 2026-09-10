package Parciales1.C1_2026.EJ2;

public class FlightLuggageTester {

    public static void main(String[] args) {
        // Se instancia un sistema para despachar equipaje
        // donde la franquicia es de 23kg.
        FlightLuggage fL = new FlightLuggage(23);

        // Se despacha una valija con el tag "ABC123" de 20 kg
        fL.checkIn("ABC123", 20);
        fL.checkIn("XYZ987", 23);
        fL.checkIn("ABC123", 25);
        fL.checkIn("AAA000", 19);
        fL.checkIn("ZZZ999", 23);

        // Se indica, para cada equipaje despachado, el tag, el peso en kg,
        // si está dentro de la franquicia y el valor en kg de la franquicia
        // en el orden en que se despacharon
        for (Luggage luggage : fL.luggages()) {
            System.out.println(luggage);
        }
        // Luggage ABC123 -> 20 kg -> OK (Allowance: 23 kg)
        // Luggage XYZ987 -> 23 kg -> OK (Allowance: 23 kg)
        // Luggage ABC123 -> 25 kg -> EXCESS (Allowance: 23 kg)
        // Luggage AAA000 -> 19 kg -> OK (Allowance: 23 kg)
        // Luggage ZZZ999 -> 23 kg -> OK (Allowance: 23 kg)

        fL.setAllowance(20);

        // Se indica, para cada equipaje despachado, el tag, el peso en kg,
        // si está dentro de la franquicia y el valor en kg de la franquicia
        // en orden descendente por peso y desempata alfabético por tag
        for (Luggage luggage : fL.luggagesByWeightDesc()) {
            System.out.println(luggage);
        }
        // Luggage ABC123 -> 25 kg -> EXCESS (Allowance: 20 kg)
        // Luggage XYZ987 -> 23 kg -> EXCESS (Allowance: 20 kg)
        // Luggage ZZZ999 -> 23 kg -> EXCESS (Allowance: 20 kg)
        // Luggage ABC123 -> 20 kg -> OK (Allowance: 20 kg)
        // Luggage AAA000 -> 19 kg -> OK (Allowance: 20 kg)

        // Se indica, para cada equipaje despachado, el tag, el peso en kg,
        // si está dentro de la franquicia y el valor en kg de la franquicia
        // en orden alfabético por tag y desempata descendente por peso
        int allowance = 24;
        for (Luggage luggage : fL.luggagesByTagAsc()) {
            fL.setAllowance(allowance--);
            System.out.println(luggage);
        }
        // Luggage AAA000 -> 19 kg -> OK (Allowance: 24 kg)
        // Luggage ABC123 -> 25 kg -> EXCESS (Allowance: 23 kg)
        // Luggage ABC123 -> 20 kg -> OK (Allowance: 22 kg)
        // Luggage XYZ987 -> 23 kg -> EXCESS (Allowance: 21 kg)
        // Luggage ZZZ999 -> 23 kg -> EXCESS (Allowance: 20 kg)
    }
}