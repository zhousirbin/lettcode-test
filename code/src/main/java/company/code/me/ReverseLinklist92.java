package company.code.me;

public class ReverseLinklist92 {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);


        head.next =node;
        node.next = node1;
        node1.next =node2;
        node2.next = node3;

      //  ListNode listNode =reverseList(head,2,4);

    //    ListNode listNode1 = reverseBetween(head , 2,4);
        ListNode listNode2 = reverseBetween1(head , 2,4);


    }

    public static ListNode reverseList(ListNode head, int m, int n){

        ListNode curr = head;
        ListNode mNode = head;
        ListNode nNode= head;
        int i=0;
        while (curr !=null){
            i++;

            if (i==m){
                mNode =curr;
            }

            if (i==n){
                nNode =curr;
                break;
            }
            curr =curr.next;
        }

        return head;

    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then  = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i=0; i<n-m; i++)
        {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

    public static ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i<m-1; i++) pre = pre.next;

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then  = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        ListNode curr = start;
        ListNode pres =null;
        for(int i=0; i<n-m; i++)
        {
//            start.next = then.next;
//            then.next = pre.next;
//            pre.next = then;
//            then = start.next;

            ListNode next = curr.next;
            curr.next = pres;
            pres =curr;
            curr = next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;

    }

}



