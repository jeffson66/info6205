import java.util.ArrayList;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, root.val, null) && isValidBST(root.right, null, root.val);
    }

    public boolean isValidBST(TreeNode curr, Integer max, Integer min){
        if(curr == null){
            return true;
        }

        if(max!=null){
            if(curr.val >= max){
                return false;
            }
        }

        if(min != null){
            if(curr.val <= min){
                return false;
            }
        }

        if(curr.left == null){
            return isValidBST(curr.right, max, curr.val);
        }else if(curr.right == null){
            return isValidBST(curr.left, curr.val, min);
        }else{
            return isValidBST(curr.left, curr.val, min) && isValidBST(curr.right, max, curr.val);
        }
    }
}
