import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {

        this.stack = new Stack<TreeNode>();
        addNode(root);
    }

    public void addNode(TreeNode root){
        while(root != null){
            this.stack.push(root);
            root = root.left;
        }
    }
    public int next() {
        TreeNode curr = stack.pop();
        if(curr.right != null){
            addNode(curr.right);
        }
        return curr.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
