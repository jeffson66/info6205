import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        BinTree<Integer> tree = getTree();
        tree.populateNextRight();
        levelOrder(tree.root);
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
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                curr.printNextLeft();
            }
            queue.add(null);
            queue.poll();
            printHelper(queue);
        }
    }

    private static BinTree<Integer> getTree(){
        BinTree<Integer> tree = new BinTree<>();

        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);


        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);


        return tree;
    }
}