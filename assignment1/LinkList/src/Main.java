public class Main {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RotateList rl = new RotateList();
        ListNode rotate = rl.rotateRight(head,2);
        while(rotate != null){
            System.out.print(rotate.val + "-> ");
            rotate = rotate.next;
        }
        System.out.print("null");
    }
}
