public class LinkList <T>{
    public Node<T> head;
    public Node<T> tail;
    int length = 0;
    public LinkList(){
        this.head = null;
        this.tail = null;
    }

    public void addNodeToHead(T data){
        Node<T> newhead = new Node<T>(data);
        newhead.next = this.head;
        this.head = newhead;
        length++;
    }

    //O(n)
    public void addNodeToTail(T data){
        Node<T> newtail = new Node<T>(data);
        if(head == null){
            head = newtail;
            return;
        }
        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newtail;
        length++;
        return;
    }
    //O(n)
    public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }

        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public Node<T> getNthFromEnd(int n){
        if(head == null || n <= 0){
            return null;
        }

        Node<T> front = head;
        Node<T> back = head;
        int count = n;
        while(count!= 0){
            if(back == null){
                return null;
            }
            back = back.next;
            count--;
        }

        while(back != null){
            back = back.next;
            front = front.next;
        }

        return front;
    }

    public Node<T> getNthFromEndWithLength(int n){
        if(head == null || n <= 0){
            return null;
        }

        int count = length - n;

        if(count < 0){
            return null;
        }
        Node<T> temp = head;
        while(count != 0){
            temp = temp.next;
            count--;
        }

        return temp;
    }

    public void breakCycleIfExist(){
        if(head == null || head.next == null){
            return;
        }
        Node<T> front = head;
        Node<T> back = head;

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
            return;
        }

        //There is a cycle
        front  = head;
        Node<T> temp = head;
        while(front != back){
            front = front.next;
            back = back.next;
            temp = temp.next;
        }

        temp.next = null;
        return;
    }

    public void reverseList(){
        Node<T> back = null;
        Node<T> middle = head;

        if(middle == null || middle.next == null){
            return;
        }

        Node<T> front = middle.next;
        while(front !=null){
            middle.next = back;
            back = middle;
            middle = front;
            front = front.next;
        }
        middle.next = back;
        head = middle;
    }


    public Node<T> breakListInHalf(){
        if(head == null || head.next == null){
            return null;
        }

        Node<T> front = head;
        Node<T> back = head;
        while(back.next != null && back.next.next != null){
            front = front.next;
            back = back.next.next;
        }

        return front.next;
    }


    public Node<T> reverseList(Node<T> secondHalf){
        Node<T> back = null;
        Node<T> middle = secondHalf;

        if(middle == null || middle.next == null){
            return null;
        }

        Node<T> front = middle.next;
        while(front !=null){
            middle.next = back;
            back = middle;
            middle = front;
            front = front.next;
        }
        middle.next = back;
        head = middle;
        return head;
    }

    public Node<T> getLastNode(Node<T> head){
        //finish later
        return null;
    }
    public boolean isPalindrome(){
        if(head == null || head.next == null){
            return false;
        }
        Node<T> secondHalf = breakListInHalf();

        secondHalf = reverseList(secondHalf);

        Node<T> temp1 = head;
        Node<T> temp2 = secondHalf;

        boolean bPalindrome = true;
        while(temp1 != null && temp2 != null){
            if(temp1.data != temp2.data){
                bPalindrome = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        secondHalf = reverseList(secondHalf);
        Node<T> lastNode = getLastNode(head);
        lastNode.next = secondHalf;

        return bPalindrome;
    }

    public void zipMerge(){
        if(head == null || head.next == null){
            return;
        }
        Node<T> secondHalf = breakListInHalf();
        secondHalf = reverseList(secondHalf);
        head = zipMerge(head,secondHalf,true);
    }

    private Node<T> zipMerge(Node<T> node1, Node<T> node2, boolean bSwitch){
        Node<T> result = null;
        if(node1 == null ){
            return node2;
        }

        if(node2 == null){
            return node1;
        }

        if(bSwitch == true){
            result = node1;
            result.next = zipMerge(node1.next, node2, false);
        }else{
            result = node2;
            result.next = zipMerge(node1, node2.next, true);
        }

        return result;
    }
}
