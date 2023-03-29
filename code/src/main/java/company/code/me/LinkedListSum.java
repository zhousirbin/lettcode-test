package company.code.me;

public class LinkedListSum {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        head.setNext(node1);
//        node1.setNext(node2);
//        node2.setNext(node3);

        Node head1 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        head1.setNext(node4);
//        node4.setNext(node5);
//        node5.setNext(node6);

        // 打印反转前的链表
        Node h = head;
        while (null != h) {
            System.out.print(h.getData() + " ");
            h = h.getNext();
        }
        // 调用反转方法
     Node node= addTwoNumbers(head,head1);

        System.out.println("\n**************************");
        // 打印反转后的结果
        while (null != node) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }


    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node c1 = l1;
        Node c2 = l2;
        Node sentinel = new Node(0);
        Node d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new Node(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new Node(1);
        return sentinel.next;
    }
}
//class Node {
//    private int val;// 数据域
//    private Node Next;// 指针域
//
//    public Node(int val) {
//        // super();
//        this.val = val;
//    }
//
//    public int getData() {
//        return val;
//    }
//
//    public void setData(int Data) {
//        this.val = val;
//    }
//
//    public Node getNext() {
//        return Next;
//    }
//
//    public void setNext(Node Next) {
//        this.Next = Next;
//    }
//}
