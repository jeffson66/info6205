public class Main {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insert(5);
        list.insert(4);
        list.insert(10);
        list.insert(7);
        list.insert(13);
        list.insert(4);
        list.insert(6);
        list.insert(3);
        Node head = list.head;
        while(head != null){
            System.out.print(head.data + ", ");
            head = head.next;
        }
    }
}