import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    public Node<T> root;
    public BinaryTree(){

    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node<T> node){
        if(node != null){
            System.out.print(node.val + ", ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node<T> node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.val + ", ");
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node<T> node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + ", ");
        }
    }


    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.size() != 0){
            Node<T> node = queue.remove();

            if(node != null){
                System.out.print(node.val + " , ");
                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }else{
                System.out.println();
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }
    }

    public int size(){
        return size(root);
    }

    public int size(Node<T> node){
        if(node == null){
            return 0;
        }else{
            return 1 + size(node.left) + size(node.right);
        }
    }

    public int height(){
        return height(root);
    }

    public int height(Node<T> node){
        if(node == null){
            return 0;
        }else{
            return Math.max(1+height(node.left), 1+height(node.right));
        }
    }

    public void printTopLevelView(){
        if(root == null){
            return;
        }
        HashMap<Integer, Node<T>> map = new HashMap<>();
        printTopLevelView(root,0, map);

        for(Node<T> currentNode: map.values()){
            System.out.println(currentNode.val);
        }
    }

    private void printTopLevelView(Node<T> node, Integer distance, HashMap<Integer, Node<T>> map){
        if(node != null){
            if(!map.containsKey(distance)){
                map.put(distance, node);
            }
            printTopLevelView(node.left, distance - 1, map );
            printTopLevelView(node.right, distance + 1, map);
        }
    }


    public void mirrorTree(){
        mirrorTree(root);
    }

    private void mirrorTree(Node<T> node){
        if(node != null){
            mirrorTree(node.left);
            mirrorTree(node.right);

            Node<T> temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

}
