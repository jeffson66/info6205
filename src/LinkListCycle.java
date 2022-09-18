public class LinkListCycle <T> {
    public Node<Integer> head;
    public LinkListCycle(){
        head = null;
    }

    public boolean containsCycle(){
        if(head == null || head.next == null){
            return false;
        }
        Node<Integer> front = head;
        Node<Integer> back = head;

        while(back != null && back.next != null){
            front = front.next;
            back = back.next.next;
            if(back == front){
                return true;
            }
        }
        return false;
    }

    public Node<Integer> findStartCycle(){
        if(head == null || head.next == null){
            return null;
        }
        Node<Integer> front = head;
        Node<Integer> back = head;

        boolean containsCycle = false;
        while(back != null && back.next != null){
            front = front.next;
            back = back.next.next;
            if(back == front){
                containsCycle = true;
                break;
            }
        }

        if(!containsCycle){
            return null;
        }

        //There is a cycle
        front  = head;

        while(front != back){
            front = front.next;
            back = back.next;
        }
        return front;
    }





}
