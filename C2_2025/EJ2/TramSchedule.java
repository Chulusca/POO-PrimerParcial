package Parciales1.C2_2025.EJ2;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TramSchedule implements Iterable<TramScheduleRow>{
    //Metodo addTramStop, anadir respetando el orden de insercion (siempre a la ultima parada)

    private final List<TramStop> tramStops = new ArrayList<>();
    private LocalTime startTime;

    TramSchedule(LocalTime startTime){
        this.startTime = startTime;
    }

    public void addTramStop(TramStop tramStop){
        tramStops.add(tramStop);
    }

    public void setStartTime(LocalTime startTime){
        this.startTime = startTime;
    }

    @Override
    public Iterator<TramScheduleRow> iterator() {
        List<TramScheduleRow> rows = new ArrayList<>();
        LocalTime time = startTime;
        for (TramStop tramStop : tramStops){
            time = time.plusMinutes(tramStop.getPlusMinutes());
            TramScheduleRow row = new TramScheduleRow(tramStop, time);
            rows.add(row);
        }
        return rows.iterator();
    }

}
