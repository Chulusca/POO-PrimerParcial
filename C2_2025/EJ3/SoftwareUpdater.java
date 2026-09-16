package Parciales1.C2_2025.EJ3;

import java.util.Comparator;
import java.util.Arrays;


public abstract class SoftwareUpdater {
    private Update[] updates;

    SoftwareUpdater(Update[] updates, Comparator<Update> comparator){
        this.updates = Arrays.copyOf(updates, updates.length);
        Arrays.sort(this.updates, comparator);
    }

    public Update[] getCatalog() {
        return getCatalog(updates.length);
    }

    public Update[] getCatalog(int n){
        if (n < 0 || n > updates.length) {
            throw new IllegalArgumentException("Invalid value");
        }
        return Arrays.copyOf(updates, n);
    }
}
