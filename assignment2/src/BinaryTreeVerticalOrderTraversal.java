import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> rank = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        HashMap<Integer, List<Integer>> record = new HashMap<>();
        rank.add(root);
        rank.add(null);
        levels.add(0);
        int min = 0;
        int max = 0;
        verticalOrderHelper(rank,  record, levels);
        min = Collections.min(record.keySet());
        max = Collections.max(record.keySet());

        for(int i = min; i <= max; i++){
            res.add(record.get(i));
        }
        return res;
    }

    public void verticalOrderHelper(Queue<TreeNode> rank, HashMap<Integer, List<Integer>> record, Queue<Integer> levels){
        if(rank.peek() == null){
            return;
        }else{
            while(rank.peek() != null){
                TreeNode current = rank.remove();
                int currentlevel = levels.remove();
                if(record.containsKey(currentlevel)){
                    record.get(currentlevel).add(current.val);
                    if(current.left != null){
                        rank.add(current.left);
                        levels.add(currentlevel-1);
                    }

                    if(current.right != null){
                        rank.add(current.right);
                        levels.add(currentlevel+1);
                    }
                }else{
                    List<Integer> curr = new ArrayList<>();
                    curr.add(current.val);
                    record.put(currentlevel, curr);
                    if(current.left != null){
                        rank.add(current.left);
                        levels.add(currentlevel-1);
                    }

                    if(current.right != null){
                        rank.add(current.right);
                        levels.add(currentlevel+1);
                    }
                }
            }
            rank.remove();
            rank.add(null);
            verticalOrderHelper(rank, record, levels);
        }
    }
}
