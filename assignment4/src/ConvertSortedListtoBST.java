public class ConvertSortedListtoBST {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBSTHelper(head);
    }

    public TreeNode sortedListToBSTHelper(ListNode head){
        if(head == null){
            return null;
        }

        if(head.next == null){
            TreeNode curr = new TreeNode(head.val);
            curr.left = null;
            curr.right = null;
            return curr;
        }
        ListNode temphead = head;
        ListNode temphead2 = head;
        int length = 0;
        while(temphead != null){
            length++;
            temphead = temphead.next;
        }
        int mid = length/2;
        length = 0;
        while(length < mid-1){
            temphead2 = temphead2.next;
            length++;
        }
        ListNode keep = temphead2.next;
        temphead2.next = null;
        if(keep == null){
            return null;
        }
        TreeNode root = new TreeNode(keep.val);
        root.left = sortedListToBSTHelper(head);
        root.right = sortedListToBSTHelper(keep.next);

        return root;
    }
}
