public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        if(root.left != null && root.right != null){
            return Math.max(maxDepth(root.left,1), maxDepth(root.right,1));
        }

        if(root.left == null && root.right == null){
            return 1;
        }else if(root.left == null){
            return maxDepth(root.right,1);
        }else{
            return maxDepth(root.left,1);
        }
    }

    public int maxDepth(TreeNode node, int current){
        if(node != null){
            current++;
            return Math.max(maxDepth(node.left, current), maxDepth(node.right, current));
        }else{
            return current;
        }
    }
}
