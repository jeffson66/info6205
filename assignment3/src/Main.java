import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        List<List<Integer>> res = Permutations.permute(nums);
//        System.out.println(res.size());
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j) + ", ");
            }
            System.out.println();
        }

    }
}
