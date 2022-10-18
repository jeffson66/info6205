import java.util.ArrayList;
import java.util.List;

public class FindLeavesofBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        int treeSize = getSize(root);
        while(treeSize != 0){
            ArrayList<Integer> curr = new ArrayList<>();
            root = findLeavesHelper(root, curr);
            res.add(curr);
            treeSize = getSize(root);
        }
        return res;
    }

    public TreeNode findLeavesHelper(TreeNode root, ArrayList<Integer> curr){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            curr.add(root.val);
            return null;
        }else{
            root.left = findLeavesHelper(root.left, curr);
            root.right = findLeavesHelper(root.right, curr);
            return root;
        }
    }

    public int getSize(TreeNode root){
        if(root == null) {
            return 0;
        }else{
            return 1 + getSize(root.left) + getSize(root.right);
        }
    }
}
