import java.util.ArrayList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0){
            return head;
        }
        ListNode temphead = head;
        int length = 0;
        while(temphead != null){
            length++;
            temphead = temphead.next;
        }
        if(length == 0){
            return head;
        }
        int rotateTime = k%length;
        ArrayList<ListNode> original = new ArrayList<ListNode>();
        ArrayList<ListNode> rotate = new ArrayList<ListNode>();
        ListNode temp = head;
        for(int i = 0; i < length-rotateTime; i++){
            original.add(new ListNode(temp.val));
            temp = temp.next;
        }

        for(int i = 0; i < rotateTime; i++){
            rotate.add(new ListNode(temp.val));
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode dummytemp = dummy;
        for(ListNode l: rotate){
            dummytemp.next = l;
            dummytemp = l;
        }
        for(ListNode l: original){
            dummytemp.next = l;
            dummytemp = l;
        }

        return dummy.next;
    }
}
