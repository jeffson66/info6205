import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ConvertBSTtoSortedDoublyLinkedList {
    public static Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> order = new LinkedList<>();
        treeToDoublyList(root, order);
        if(order.size() == 1){
            Node curr = order.poll();
            curr.left = curr;
            curr.right = curr;
            return curr;
        }
        if(order.size() == 2){
            Node first = order.poll();
            Node second = order.poll();
            first.right = second;
            second.left = first;
            first.left = second;
            second.right = first;
            return first;
        }
        Node first = order.poll();
        int index = 0;
        Node temp = null;
        while(order.size() > 1){
            if(index == 0){
                Node curr = order.poll();
                first.right = curr;
                curr.left = first;
                index++;
                temp = curr;
            }else{
                Node curr = order.poll();
                temp.right = curr;
                curr.left = temp;
                index++;
                temp = curr;
            }
        }
        Node last = order.poll();
        temp.right = last;
        last.left = temp;
        first.left = last;
        last.right = first;
        return first;
    }

    public static void treeToDoublyList(Node current, Queue<Node> order){
        if(current.left == null && current.right == null){
            order.add(current);
        }
        else if(current.left == null && current.right != null){
            order.add(current);
            treeToDoublyList(current.right, order);
        }
        else if(current.left != null && current.right == null){
            treeToDoublyList(current.left, order);
            order.add(current);
        }else{
            treeToDoublyList(current.left,order);
            order.add(current);
            treeToDoublyList(current.right, order);
        }


    }
}
