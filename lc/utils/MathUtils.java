package lc.utils;
import java.util.List;
import java.lang.Comparable;
import java.time.chrono.AbstractChronology;

class DefaultComparison implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class MathUtils {
    public static <T extends Comparable<T>> T min(List<T> list) {
        T minValue = list.get(0);
        for(int i=1;i<list.size();i++) {
            if(list.get(i).compareTo(minValue) < 0) {
                minValue = list.get(i);
            }
        }
        return minValue;
    }

    public static Integer minInt(List<Integer> list) {
        return MathUtils.min(list);
    }
}
