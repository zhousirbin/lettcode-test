package company.code.me;

public class LinkedList {

    private int i;

    public static void main(String[] args){

        //LinkedList.ListNode head = new LinkedList().new ListNode(1); --如果为非静态内部类
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);

        head.next  =node;
        node.next  =node1;
        node1.next = node2;
        node2.next = node3;
        node3.next=node2;

        System.out.println(hasCycle(head));



    }

    //141 Given a linked list, determine if it has a cycle in it.
    //Input: head = [3,2,0,-4], pos = 1
    //Output: true
    //Explanation: There is a cycle in the linked list, where tail connects to the second node.

    //解析：  Use two pointers, walker and runner.
    //    walker moves step by step. runner moves two steps at time.
    //            if the Linked List has a cycle walker and runner will meet at some
    //    point.
    // 一个跑的快一个跑的慢，如果有环，总会在一个节点上遇到。否则一定遇不到。
    public static boolean hasCycle(ListNode head) {

        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) { //只有这个条件不行，runner.next.next!=null，因为当到达末尾是，runner.next已经为null了。
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) {
                System.out.println(runner.val);
                return true;
            }

        }

        return false;
    }

    //142. Linked List Cycle II
    //Example 1:

    //Input: head = [3,2,0,-4], pos = 1
    // Output: tail connects to node index 1
    // Explanation: There is a cycle in the linked list, where tail connects to the second node.

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }



    //143  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    //reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
    //Example 1:
    //
    //Given 1->2->3->4, reorder it to 1->4->2->3.

    public void reorderList(ListNode head) {

        ListNode curr = head;



    }


    //翻转列表
    public void reorderList1(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        while(preCurrent.next!=null){
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=preMiddle.next;
            preMiddle.next=current;
        }

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }
    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }




}
