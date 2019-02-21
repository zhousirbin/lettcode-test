package company.code;

public class MergeList {

//
    public static void main(String[] args){
        Node head = new Node(0);
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);

//        head.setNext(node1);
//        node1.setNext(node2);

        Node head1 = new Node(1);

        Node node4 = new Node(2);
//        Node node5 = new Node(3);
       head1.setNext(node4);
//        node4.setNext(node5);

        Node newNode = mergeTwoLists(head,head1);

        while (null != newNode) {
            System.out.print(newNode.getData() + " ");
            newNode = newNode.getNext();
        }
    }

    public static Node mergeTwoLists(Node l1, Node l2){
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2); //如果l1的值小，那么一直递归到，l1的最后一个值，然后最后一个值的next=l2
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}

class Node {
    public int val;// 数据域
    public Node next;// 指针域

    public Node(int val) {
        // super();
        this.val = val;
    }

    public int getData() {
        return val;
    }

    public void setData(int Data) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}