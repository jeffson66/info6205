public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temphead = head;
        while(temphead != null){
            if(temphead.val == val){
                head = head.next;
            }else{
                break;
            }
            temphead = temphead.next;
        }

        while(temphead != null && temphead.next != null){
            ListNode currentNext = temphead.next;
            while(currentNext != null && currentNext.val == val){
                currentNext = currentNext.next;
            }
            temphead.next = currentNext;
            temphead = currentNext;
        }

        return head;
    }
}
