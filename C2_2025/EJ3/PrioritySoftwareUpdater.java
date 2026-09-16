package Parciales1.C2_2025.EJ3;

import java.util.Comparator;

public class PrioritySoftwareUpdater extends SoftwareUpdater{

    PrioritySoftwareUpdater(Update[] updates){
        super(updates, Comparator.comparing((Update u) -> u.getPriority())
                .thenComparing(Comparator.comparing((Update u) -> u.getGb()).reversed()));
    }

}
