public class Node <T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node<T> nextLeft;

    public Node(T data){
        this.data = data;
    }

    public void printNextLeft(){
        if(this.nextLeft == null){
            System.out.println(this.nextLeft);
        }else{
            System.out.print(this.nextLeft.data + ", ");
        }


    }
}
