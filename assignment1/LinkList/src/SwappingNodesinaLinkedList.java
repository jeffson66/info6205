public class SwappingNodesinaLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode frontParent = null;
        ListNode backParent = null;
        ListNode frontChild = null;
        ListNode backChild = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy.next;
        int length = 0;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        if(length %2 == 0){
            if(k > length/2){
                k = length+1-k;
            }
        }else{
            if(k == (length+1)/2){
                return dummy.next;
            }
            if(k > (length+1)/2){
                k = length+1-k;
            }
        }

        ListNode dummytemp = dummy;
        ListNode dummytemp2 = dummy;

        int count = 1;
        while(dummytemp != null){
            if(count == k){
                frontParent = dummytemp;
                frontChild = dummytemp.next.next;
                break;
            }
            dummytemp = dummytemp.next;
            count++;
        }
        count = 1;
        while(dummytemp.next.next != null){
            dummytemp2 = dummytemp2.next;
            dummytemp = dummytemp.next;
        }


        backParent = dummytemp2;
        backChild = dummytemp2.next.next;
        ListNode front = frontParent.next;
        ListNode back = backParent.next;


        if(frontChild == back){

            front.next = backChild;
            back.next = front;
            frontParent.next = back;
            return dummy.next;
        }
        front.next = backChild;
        backParent.next = front;
        back.next = frontChild;
        frontParent.next = back;

        return dummy.next;
    }
}
