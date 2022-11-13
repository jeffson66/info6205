public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){
        if(head == null){
            this.head = new Node(data);
        }else{
            Node temphead = head;
            if(data < temphead.data){
                Node newhead = new Node(data);
                newhead.next = head;
                this.head = newhead;
                return;
            }
            while(temphead != null){
                if(temphead.next != null){
                    if(temphead.data <= data && data <= temphead.next.data){
                        Node curr = new Node(data);
                        Node keep = temphead.next;
                        temphead.next = curr;
                        curr.next = keep;
                        break;
                    }
                }else{
                    temphead.next = new Node(data);
                    break;
                }
                temphead = temphead.next;
            }
        }
    }
}
