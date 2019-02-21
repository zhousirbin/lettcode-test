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
