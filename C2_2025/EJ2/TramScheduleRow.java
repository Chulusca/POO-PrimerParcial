package Parciales1.C2_2025.EJ2;

import java.time.LocalTime;

public class TramScheduleRow {

    private final TramStop tramStop;
    private final LocalTime time;

    TramScheduleRow(TramStop tramStop, LocalTime time){
        this.tramStop = tramStop;
        this.time = time;
    }
    @Override
    public String toString(){
        return tramStop.toString() + " -> " + time.toString();
    }
}