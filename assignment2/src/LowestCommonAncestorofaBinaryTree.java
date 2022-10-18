import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LowestCommonAncestorofaBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root.equals(p) || root.equals(q)){
            return root;
        }
        TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor(root.right, p, q);
        if(findLeft != null && findRight != null){
            return root;
        }
        if(findLeft == null){
            return findRight;
        }
        if(findRight == null){
            return findLeft;
        }
        return null;
    }


}
