import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target,  new ArrayList<>(), 0);
        return res;
    }

    public void combinationSumHelper(int[] candidates, int target, ArrayList<Integer> list, int index){
        if(target == 0){
            res.add((ArrayList<Integer>)list.clone());
            return;
        }else if(target > 0) {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }else{
            return;
        }

    }

}
