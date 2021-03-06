package company.linkedlist;

public class ReverseListTest1 {
    public static void main(String[] args) {
        Node head  = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
//        head = Reverse1(head);
//
//
//        System.out.println("\n**************************");
//        // 打印反转后的结果
//        while (null != head) {
//            System.out.print(head.getData() + " ");
//            head = head.getNext();
//        }


        //head = Reverse3(head);
        Node node = reverseList2(head);
        System.out.println("\n**************************");
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
    }

    /**
     * 递归，在反转当前节点之前先反转后续节点
     */
    public static Node Reverse1(Node head) {
        // head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
        //此处必须有要循环到head.getNext()为最后一个元素。
        if (head == null || head.getNext() == null) {
            return head;// 若为空链或者当前结点在尾结点，则直接还回
        }

        //上边的循环要一直循环到，head.getNext()=last，即head.getNext().getNext()= null ,返回最后一个值，rehead才有值，才能执行后边的代码。


        Node reHead = Reverse1(head.getNext());// 先反转后续节点head.getNext()
        head.getNext().setNext(head);// 将当前结点的指针域指向前一结点
        head.setNext(null);// 前一结点的指针域令为null;
        return reHead;// 反转后新链表的头结点
    }

    public static Node Reverse2(Node head) {

        Node nextNode = head.getNext();
        if (head == null || nextNode == null){
            return head;
        }

        Node reHead = Reverse2(nextNode);
        nextNode.setNext(head);
        head.setNext(null);
        return reHead;
    }


    /**
     * 迭代方法
     */
    public static Node  Reverse3(Node head) {

        if (head == null || head.getNext() == null){
            return head;
        }

        Node p0 = head;
        Node p1 = head.getNext();
        Node p2 = null;

        while (p1!=null){
            p2 = p1.getNext();
            p1.setNext(p0);
            p0 =p1;
            p1 = p2;
        }
        head.setNext(null);
        head=p0;
        return head;

    }

    /**
     * 迭代方法
     */
    public static void   Reverse4(Node head) {

        if (head == null || head.getNext() == null){
            return ;
        }

        Node p0 = head;
        Node p1 = head.getNext();
        Node p2 = null;

        while (p1!=null){
            p2 = p1.getNext();
            p1.setNext(p0);
            p0 =p1;
            p1 = p2;
        }
        head.setNext(null);
        head=p0;


    }

    public static Node reverseList1(Node node) {
        Node previousNode = null;
        Node currentNode = node;
        Node headNode = null;
        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;

    }

    public static Node reverseList2(Node node) {
        Node previousNode = null;
        Node currentNode = node;
        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return previousNode;

    }

    public static Node reverseList3(Node node) {

        Node pre = null;
        Node cur = node;
        while(cur!=null){

            Node next = cur.getNext();
           cur.setNext(pre);
           pre = cur;
           cur = next;

        }
        return  pre;
    }







}

class Node {
    private int Data;// 数据域
    private Node Next;// 指针域

    public Node(int Data) {
        // super();
        this.Data = Data;
    }

    public int getData() {
        return Data;
    }

    public void setData(int Data) {
        this.Data = Data;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node Next) {
        this.Next = Next;
    }
}
