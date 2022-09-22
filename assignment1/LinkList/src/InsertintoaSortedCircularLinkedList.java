public class InsertintoaSortedCircularLinkedList {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }

        if(head.next == null){
            Node res = new Node(insertVal);
            head.next = res;
            res.next = head;
            return head;
        }

        Node temphead = head;
        Node realStart = null;
        while(temphead.next != head){
            if(temphead.val > temphead.next.val){
                realStart = temphead.next;
                break;
            }
            temphead = temphead.next;
        }

        if(realStart == null){
            realStart = head;
        }

        if(insertVal <= realStart.val || insertVal >= temphead.val){
            temphead.next = new Node(insertVal);
            temphead.next.next = realStart;
            return head;
        }

        int previousVal = temphead.val;
        while(!(previousVal <= insertVal && insertVal <= realStart.val)){
            previousVal = realStart.val;
            realStart = realStart.next;
            temphead = temphead.next;
        }

        temphead.next = new Node(insertVal);
        temphead.next.next = realStart;
        return head;

    }
}
