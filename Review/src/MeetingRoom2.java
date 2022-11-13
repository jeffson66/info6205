import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> allocator = new PriorityQueue(intervals.length, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        allocator.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= allocator.peek()){
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }

        return allocator.size();
    }
}
