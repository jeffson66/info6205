import java.util.LinkedList;
import java.util.Queue;

public class BinTree <T> {
    public Node<T> root;

    public BinTree() {

    }

    public void populateNextRight(){
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       queue.add(null);
       populateNextRightHelper(queue);
    }

    public void populateNextRightHelper(Queue<Node> queue){
        if(queue.peek() == null){
            return;
        }else{
            Node temp = queue.poll();
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
            while(queue.peek() != null){
                Node curr = queue.poll();
                if(curr.right != null){
                    queue.add(curr.right);
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                temp.nextLeft = curr;
                temp = curr;
            }
            temp.nextLeft = null;
            queue.add(null);
            queue.poll();
            populateNextRightHelper(queue);
        }

    }


}