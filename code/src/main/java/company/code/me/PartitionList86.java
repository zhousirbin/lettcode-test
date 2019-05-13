package company.code.me;


public class PartitionList86 {
    public static void main(String[] args){

        //head = 1->4->3->2->5->2, x = 3

        ListNode head = new ListNode(1);
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(2);

        head.next =node;
        node.next = node1;
        node1.next =node2;
        node2.next = node3;

        ListNode listNode =partition1(head,3);

//        head.setNext(node1);
//        node1.setNext(node2);


    }

    //1 4 3 2 5
    public static ListNode partition1(ListNode head, int x) {
        ListNode  listNode1  = new ListNode(0);
        ListNode  listNode2 = new ListNode(0);

        ListNode curr1 = listNode1, curr2 = listNode2;
        while (head !=null){
           if (head.val <x){
               curr1.next = head;
               curr1 = head;
           }
           else {
               curr2.next =head;//大于的
               curr2 =head;
           }
           head = head.next;
       }
        curr2.next =null;
        curr1.next =listNode2.next;
        return listNode1.next;

    }









    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }



}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}