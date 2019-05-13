package company.linkedlist.node;

public class MergeTwoSortedList {

    public static void main(String[] args) {

        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(6);
        node.Next  =node1;

        node2.Next=node3;
        node3.Next = node4;

        Node node5 = mergeList(node,node2);
        while (node5 != null){
            System.out.print(node5.Data);
            node5 = node5.Next;
        }


        Node node6 = new Node(2);
        Node node7 = new Node(3);
        Node node8 = new Node(4);
        Node node10 = new Node(5);
        node6.Next = node7;
        node7.Next = node8;
        node8.Next = node10;


        Node node9 = reverseKGroup(node6,3);
        while (node9 != null){
            System.out.print(node9.Data);
            node9 = node9.Next;
        }

    }

    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.Next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                Node tmp = head.Next; // tmp - next head in direct part
                head.Next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }




    public static Node mergeList(Node l1,Node l2){

        if (l1==null)return l2;
        if (l2==null)return l1;

        if (l1.Data < l2.Data){
             l1.Next = mergeList(l1.Next,l2);
             return l1;
        }
        else {
             l2.Next = mergeList(l1,l2.Next);
             return l2;
        }

    }

    public static Node swapPairs(Node head) {
        if(head==null|| head.Next==null){
            return head;
        }
        Node n = head.Next;
        head.Next = swapPairs(head.Next.Next);
        n.Next = head;

        return n;
    }

    static class Node {
        private int Data;// 数据域
        private Node Next;// 指针域

        public Node(int Data) {
            // super();
            this.Data = Data;
        }

//        public int getData() {
//            return Data;
//        }
//
//        public void setData(int Data) {
//            this.Data = Data;
//        }
//
//        public Node getNext() {
//            return Next;
//        }
//
//        public void setNext(Node Next) {
//            this.Next = Next;
//        }
    }
}
