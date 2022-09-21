public class Main {

    public static void main(String[] args) {
	    LinkList<Integer> list = new LinkList<Integer>();
        list.head = createNoCycleList();
//	    list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.addNodeToHead(5);
//        list.printList();
//
//        list.reverseList();
//
//        list.printList();
//
//        Node<Integer> secondHalf = list.breakListInHalf();
//
//        System.out.println(secondHalf.data);

        LinkList<Integer> list1 = new LinkList<>();
        LinkList<Integer> list2 = new LinkList<>();

        list1.addNodeToTail(9);
        list1.addNodeToTail(3);
        list1.addNodeToTail(2);
        list2.addNodeToTail(8);
        list2.addNodeToTail(1);

        LinkList<Integer> addResult = addTwoNumber(list1, list2);
        addResult.printList();
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

    private static LinkList<Integer> addTwoNumber(LinkList<Integer> l1, LinkList<Integer> l2){
        //assuming both lists are not empty

        LinkList<Integer> addResult = new LinkList<>();
        Node<Integer> temp1 = l1.reverseList(l1.head);
        Node<Integer> temp2 = l2.reverseList(l2.head);

        int carry = 0;
        while(temp1 != null || temp2 != null){
            int result = 0;
            if(temp1 != null){
                result = temp1.data;
                temp1 = temp1.next;
            }

            if(temp2 != null){
                result = result + temp2.data;
                temp2 = temp2.next;
            }

            result += carry;
            if(result>=10){
                result = result%10;
                carry = 1;
            }else{
                carry = 0;
            }

            addResult.addNodeToHead(result);
        }
        if(carry == 1){
            addResult.addNodeToHead(1);
        }
        return addResult;
    }

//    private static Node<Integer> getIntersectingNode(LinkList<Integer> l1, LinkList<Integer> l2){
//        if(l1 == null || l2 == null){
//            return null;
//        }
//        int len1 = l1.length;
//        int len2 = l2.length;
//
//        Node<Integer> temp1 = list1.head;
//        Node<Integer> tenp2 = list2.head;
//
//        if(len1 > len2){
//            int count = len1 - len2;
//            while(count > 0){
//                temp1 = temp1.next;
//                count--;
//            }
//        }else{
//            int count = len2 - len1;
//            while(count > 0){
//                temp2 = temp2.next;
//                count--;
//            }
//        }
//
//        while(temp1 != null && temp2 != null){
//            if(temp1 == temp2){
//                return temp1;
//            }
//            temp1 = temp1.next;
//            temp2 = temp2.next;
//        }
//        return null;
//    }

    private static void createIntersectionOfTwoList(LinkList<Integer> l1, LinkList<Integer> l2){

    }
    private static void createCycleList(){
        Node<Integer> node = new Node<>(1);
    }


}
