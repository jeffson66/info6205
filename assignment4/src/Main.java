public class Main {
    public static void main(String[] args) {
        Node root = createTree();
        ConvertBSTtoSortedDoublyLinkedList.treeToDoublyList(root);
    }

    public static Node createTree(){
        Node root = new Node(4);

        root.left = new Node(2);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        return root;
    }
}
