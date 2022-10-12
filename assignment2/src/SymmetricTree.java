public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left, root.right);
    }

    public boolean checkSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left != null && right == null) || (left == null && right != null)){
            return false;
        }

        if(left.val == right.val){
            return checkSymmetric(left.right, right.left) && checkSymmetric(left.left, right.right);
        }else{
            return false;
        }
    }

}
