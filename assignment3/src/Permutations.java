import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> curr = new ArrayList<>();
        permuteHelper(nums, 0, curr, res);
        return res;
    }

    public static void permuteHelper(int[] nums, int index, ArrayList<Integer> curr, List<List<Integer>> res){
        if(curr.size() == nums.length){
            res.add((ArrayList<Integer>)curr.clone());
        }else{
            for(int i = 0; i < nums.length; i++){
                if(!curr.contains(nums[i])){
                    curr.add(nums[i]);
                    permuteHelper(nums, index++, curr, res);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
}
