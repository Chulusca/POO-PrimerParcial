package Parciales1.C2_2025.EJ3;

import java.util.Comparator;

public class SizeSoftwareUpdater extends SoftwareUpdater{

    SizeSoftwareUpdater(Update[] updates){
        super(updates, Comparator.comparing( (Update u) -> u.getGb() )
                .thenComparing(Comparator.comparing((Update u) -> u.getPriority())));
    }
}
