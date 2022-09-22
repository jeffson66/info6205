public class SplitLinkedListinParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temphead = head;
        int length = 0;
        while(temphead != null){
            temphead = temphead.next;
            length++;
        }
        ListNode[] res = new ListNode[k];
        int addOne = length%k;
        int eachGroupNum = length/k;
        int count = 0;
        for(int i = 0; i < k; i++){
            ListNode dummy = new ListNode(0);
            ListNode dummytemp = dummy;
            int groupNum = eachGroupNum;
            if(addOne > 0){
                groupNum++;
                addOne--;
            }
            if(groupNum == 0){
                res[i] = null;
                continue;
            }
            while(groupNum > 0){
                dummytemp.next = new ListNode(head.val);
                dummytemp = dummytemp.next;
                head = head.next;
                groupNum--;
            }
            res[i] = dummy.next;
        }

        return res;
    }
}
