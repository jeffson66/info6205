import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Stack<TreeNode> reverse = new Stack<>();
        Stack<TreeNode> inOrder = new Stack<>();
        boolean isLeft = true;
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        inOrder.add(root);
        return zigzagLevelOrderHelper(reverse, inOrder, isLeft, res);
    }

    public List<List<Integer>> zigzagLevelOrderHelper(Stack<TreeNode> reverse, Stack<TreeNode> inOrder, boolean isLeft, List<List<Integer>> res){
        if(reverse.isEmpty() && inOrder.isEmpty()){
            return res;
        }
        if(isLeft){
            List<Integer> currentList = new ArrayList<>();
            while(!inOrder.isEmpty()){
                TreeNode curr = inOrder.pop();
                currentList.add(curr.val);
                if(curr.left != null){
                    reverse.push(curr.left);
                }

                if(curr.right != null){
                    reverse.push(curr.right);
                }
            }
            res.add(currentList);
            isLeft = !isLeft;
            return zigzagLevelOrderHelper(reverse, inOrder, isLeft, res);
        }else{
            List<Integer> currentList = new ArrayList<>();
            while(!reverse.isEmpty()){
                TreeNode curr = reverse.pop();
                currentList.add(curr.val);
                if(curr.right != null){
                    inOrder.push(curr.right);
                }
                if(curr.left != null){
                    inOrder.push(curr.left);
                }
            }

            res.add(currentList);
            isLeft = !isLeft;
            return zigzagLevelOrderHelper(reverse, inOrder, isLeft, res);
        }


    }
}
