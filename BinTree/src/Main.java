public class Main {
    public static void main(String[] args){
        BinaryTree<Integer> tree = getTree();
        tree.preOrder();
        tree.inOrder();
        tree.postOrder();
        System.out.println();
        tree.levelOrder();
        System.out.println(tree.height());

        tree.printTopLevelView();
    }

    private static BinaryTree<Integer> getTree(){
        BinaryTree<Integer> tree = new BinaryTree();
        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);

        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);

        return tree;
    }

    public static Node<Integer> getRootFromPreAndInOrderTraversal(Integer[] preorder, Integer[] inorder){
        BoxValue<Integer> preIndex = new BoxValue<T>(0);
        return getRootFromPreAndInOrderTraversal(preorder, inorder, preIndex, 0, preorder.length-1);
    }

    private static Node<Integer> getRootFromPreAndInOrderTraversal(Integer[] preorder, Integer[] inorder, BoxValue<Integer> preIndex, int start, int end){
        if(start > end || preIndex.val >= preorder.length){
            return null;
        }

        Node<Integer> node = new Node<>(preorder[preIndex.val]);
        preIndex.val++;
        int inOrderIndex = findIndex(inorder, start, end, node.val);
        if(inOrderIndex == -1){
            node.left = null;
        }else{
            node.left = getRootFromPreAndInOrderTraversal(preorder, inorder,  preIndex, start, inOrderIndex-1);
        }
    }
}
