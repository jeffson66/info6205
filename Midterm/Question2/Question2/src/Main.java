import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Node root = getRoot();
        populateParent(root);
        levelOrder(root);
    }

    private static Node getRoot(){


        Node root = new Node<>(1);

        root.left = new Node<>(2);
        root.right = new Node<>(3);

        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        root.right.left = new Node<>(6);
        root.right.right = new Node<>(7);


        root.left.left.left = new Node<>(8);
        root.left.right.left = new Node<>(9);
        root.right.left.right = new Node<>(10);
        root.right.right.right = new Node<>(11);


        return root;
    }
    public static void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        printHelper(queue);
    }

    public static void printHelper(Queue<Node> queue) {
        if (queue.peek() == null) {
            return;
        } else {
            while (queue.peek() != null) {
                Node curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }

                if(curr.parent == null){
                    System.out.print(curr.parent + ", ");
                }else{
                    System.out.print(curr.parent.data + ", ");
                }
            }
            queue.add(null);
            queue.poll();
            printHelper(queue);
        }
    }
    public static void populateParent(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            root.left.parent = root;
        }
        if(root.right != null){
            root.right.parent = root;
        }
        populateParent(root.left);
        populateParent(root.right);
    }

}