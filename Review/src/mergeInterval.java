import java.util.ArrayList;
import java.util.Comparator;

public class mergeInterval {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            list.add(intervals[i]);
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] < o2[0]? -1:1;
            }
        });


    }
}
