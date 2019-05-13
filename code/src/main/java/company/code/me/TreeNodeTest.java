package company.code.me;

import java.util.HashMap;

public class TreeNodeTest {

    public static void main(String[] args){

        //[-10,-3,0,5,9]
        ListNode head = new ListNode(-10);
        ListNode node = new ListNode(-3);
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);



        //
        head.next =node;
        node.next = node1;
        node1.next =node2;
        node2.next = node3;
        TreeNodeTest treeNodeTest = new TreeNodeTest();
        TreeNode treeNode =treeNodeTest.sortedListToBST(head);


    }


    //108. Convert Sorted Array to Binary Search Tree
    //根据排序好的列表，构建一个二叉树，主要运用递归
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0 )  return null;
        TreeNode node = help(0,nums.length-1,nums);
        return node;
    }

    public  TreeNode help(int start,int end ,int[] nums) {

        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left  = help(start,mid-1,nums);
        root.right = help(mid+1,end,nums);

        return root;
    }

    //106. Construct Binary Tree from Inorder and Postorder Traversal
    //inorder = [9,3,15,20,7]
    //postorder = [9,15,7,20,3]
    //Return the following binary tree:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();
        for (int i=0;i<inorder.length;++i)
            hm.put(inorder[i], i);  //将中序遍历的结果放入map.
        return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0,
                postorder.length-1,hm);//七个参数
    }

    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,
                                     HashMap<Integer,Integer> hm){
        if (ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);//取出后续遍历的最后一个值
        int ri = hm.get(postorder[pe]);//获取到根节点在中序遍历结果中的位置
        //ps+ri-1为左边的根节点，还需要减去中序遍历的
        TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm); //那么左子树就在中序遍历的左边，右子树就在中序遍历的右边，
        //
        TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }


    //109. Convert Sorted List to Binary Search Tree
    //Given the sorted linked list: [-10,-3,0,5,9],
    //One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
    //
    //      0
    //     / \
    //   -3   9
    //   /   /
    // -10  5
    public TreeNode sortedListToBST(ListNode head) {

        if(head==null){
            return null;
        }
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode start, ListNode end){

        ListNode slow = start;
        ListNode fast = start;
        if(start==end){ //这个很重要，保证，
            return null;
        }
        while(fast!=end&&fast.next!=end){
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root= new TreeNode(slow.val);
        root.left  = toBST(start,slow);//start==end,保证只循环到slow前面。
        root.right = toBST(slow.next,end);

        return root;

    }
}










 class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

