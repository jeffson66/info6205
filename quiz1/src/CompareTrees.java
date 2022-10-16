public class CompareTrees {
    public boolean compareTree(BinaryTree tree1, BinaryTree tree2){
        Node root1 = tree1.root;
        Node root2 = tree2.root;
        return compareHelper(root1,root2);
    }

    public boolean compareHelper(Node n1, Node n2){
        if(n2.val == null && n1.val == null) {
            return true;
        }
        else if(n1.val == n2.val){
            return compareHelper(n1.left, n2.left) && compareHelper(n1.right, n2.right);
        }else{
            return false;
        }
    }
}
