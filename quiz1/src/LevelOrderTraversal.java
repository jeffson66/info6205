import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public void levelOrderTraversal(BinaryTree tree){
        Node root = tree.root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        queue.add(null);
        traversalHelper(queue, 1);
    }

    public void traversalHelper(Queue<Node> queue, int level){
        if(queue.peek() == null){
            return;
        }
        while(queue.peek() != null){
            Node curr = queue.poll();
            System.out.println("level: " + level);
            System.out.print(curr.val + ", ");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
        }
        queue.add(null);
        queue.poll();
        traversalHelper(queue, level+1);
    }

}
