import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        subsetsHelper(0, nums, new ArrayList<Integer>(),res);
        return res;
    }

    public void subsetsHelper(int index, int[] nums, ArrayList<Integer> curr, List<List<Integer>> res){
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            res.add(new ArrayList<Integer>(curr));
            subsetsHelper(i+1, nums, curr,res);
            curr.remove(curr.size()-1);
        }

    }

}
