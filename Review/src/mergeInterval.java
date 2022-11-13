import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class mergeInterval {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            int index = i;
            for(int j = i + 1; j < intervals.length; j++){
                if(intervals[index][0] > intervals[j][0]){
                    index = j;
                }
            }
            int[] temp = intervals[i];
            intervals[i] = intervals[index];
            intervals[index] = temp;
        }

        Stack<int[]> record = new Stack<>();
        int idx = 0;
        record.push(intervals[idx]);
        while(idx < intervals.length){
            int[] curr = record.peek();
            int start = curr[0];
            int end = curr[1];
            int start2 = intervals[idx][0];
            int end2 = intervals[idx][1];
            if(start2 < end){
                int[] newarr = {start, Math.max(end2,end)};
                record.pop();
                record.push(newarr);
                idx++;
            }else{
                record.push(intervals[idx]);
                idx++;
            }
        }
        int[][] res = new int[record.size()][2];
        idx = res.length-1;
        while(!record.isEmpty()){
            res[idx]= record.pop();
            idx--;
        }

        return res;

    }
}
