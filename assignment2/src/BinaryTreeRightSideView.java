import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        return rightSideViewHelper(queue, res);
    }

    public List<Integer> rightSideViewHelper(Queue<TreeNode> queue, List<Integer> res){
        if(queue.peek() == null){
            return res;
        }else{
            TreeNode currentRightView = null;
            while(queue.peek() != null){
                TreeNode currentNode = queue.remove();
                if(currentNode.left != null){
                    queue.add(currentNode.left);

                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                currentRightView = currentNode;

            }
            res.add(currentRightView.val);
            queue.remove();
            queue.add(null);
            return rightSideViewHelper(queue,res);

        }
    }
}
