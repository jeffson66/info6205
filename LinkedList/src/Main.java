public class Main {

    public static void main(String[] args) {
	    LinkList<Integer> list = new LinkList<Integer>();
        list.head = createNoCycleList();
//	    list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
        list.printList();

        list.reverseList();

        list.printList();

        Node<Integer> secondHalf = list.breakListInHalf();

        System.out.println(secondHalf.data);
    }

    private static Node<Integer> createNoCycleList(){
        Node<Integer> node = new Node<>(1);
        node.next = new Node<>(2);
        node.next.next = new Node<>(3);
        node.next.next.next = new Node<>(4);
        node.next.next.next.next = new Node<>(5);
        node.next.next.next.next.next = new Node<>(6);
        node.next.next.next.next.next.next = new Node<>(7);
        return node;
    }

    private static void createCycleList(){
        Node<Integer> node = new Node<>(1);
    }


}
