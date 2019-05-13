package company.BinaryTree;

import java.util.*;

public class BinaryTree<T> {


    /*
     * 先序创建二叉树，根左右
     * 返回：根节点
     */
    public TreeNode<T> creatBinaryPre(LinkedList<T> treeData)
    {
        TreeNode<T> root=null;
        T data=treeData.removeFirst();
        if (data!=null)
        {
            root=new TreeNode<T>(data, null, null);
            root.left =creatBinaryPre(treeData);//root的left等于下一个root
            root.right=creatBinaryPre(treeData);
        }
        return root;
    }
    /*
     * 先序遍历二叉树（递归）
     */
    public void PrintBinaryTreePreRecur(TreeNode<T> root)
    {
        if (root!=null)
        {
            System.out.print(root.data);
            PrintBinaryTreePreRecur(root.left);
            PrintBinaryTreePreRecur(root.right);
        }
    }
    /*
     * 中序遍历二叉树（递归）左根右
     */
    public void PrintBinaryTreeMidRecur(TreeNode<T> root)
    {
        if (root!=null)
        {
            PrintBinaryTreeMidRecur(root.left);
            System.out.print(root.data);
            PrintBinaryTreeMidRecur(root.right);
        }
    }
    /*
     * 后序遍历二叉树（递归）左右根
     */
    public void PrintBinaryTreeBacRecur(TreeNode<T> root)
    {
        if (root!=null)
        {
            PrintBinaryTreeBacRecur(root.left);
            PrintBinaryTreeBacRecur(root.right);
            System.out.print(root.data);
        }
    }
    /*
     * 先序遍历二叉树（非递归）根左右
     * 思路：对于任意节点T，访问这个节点并压入栈中，然后访问节点的左子树，
     *      遍历完左子树后，取出栈顶的节点T，再先序遍历T的右子树
     */
    public void PrintBinaryTreePreUnrecur(TreeNode<T> root)
    {
        TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode> stack=new LinkedList<>();
        //栈不为空时，或者p不为空时循环
        while(p!=null || !stack.isEmpty())
        {
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            if (p!=null)
            {
                stack.push(p);//记录左侧所有左节点
                System.out.print(p.data);
                p=p.left;
            }
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出栈顶元素，赋值为right
            else //不过p的左为空，还是p的右为空，都会pop
            {
                p=stack.pop();
                p=p.right; //把右节点放进去，75行，然后再pop出来
            }
        }
    }

    public void PrintBinaryTreePreUnrecur1(TreeNode<T> root)
    {
        TreeNode<T> p=root;//p为当前节点

        LinkedList<TreeNode> stack = new LinkedList<>();

        while (p != null ||! stack.isEmpty()){
            if (p!= null){
                stack.push(p);
                System.out.println(p.data);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
    }


    //中序遍历
    public void PrintBinaryTreePreUnrecurhou(TreeNode<T> root)
    {
        TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode> stack=new LinkedList<>();
        //栈不为空时，或者p不为空时循环
        while(p!=null || !stack.isEmpty())
        {
            //当前节点不为空。访问并压入栈中。并将当前节点赋值为左儿子
            if (p!=null)
            {
                stack.push(p);//记录左侧所有左节点

                p=p.left;
            }
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出栈顶元素，赋值为right
            else //不过p的左为空，还是p的右为空，都会pop
            {

                p=stack.pop();//最先pop出左节点
                System.out.print(p.data);
                p=p.right; //把右节点放进去，75行，然后再pop出来
            }

        }
    }


    /*
     * 中序遍历二叉树（非递归）
     *
     * 思路：先将T入栈，遍历左子树；遍历完左子树返回时，栈顶元素应为T，
     *       出栈，访问T->data，再中序遍历T的右子树。
     */
    public void PrintBinaryTreeMidUnrecur(TreeNode<T> root)
    {
        TreeNode<T> p=root;//p为当前节点
        LinkedList<TreeNode> stack=new LinkedList<>();

        //栈不为空时，或者p不为空时循环
        while(p!=null || !stack.isEmpty())
        {
            //当前节点不为空。压入栈中。并将当前节点赋值为左儿子
            if (p!=null)
            {
                stack.push(p);
                p=p.left;
            }
            //当前节点为空：
            //  1、当p指向的左儿子时，此时栈顶元素必然是它的父节点
            //  2、当p指向的右儿子时，此时栈顶元素必然是它的爷爷节点
            //取出并访问栈顶元素，赋值为right
            else
            {
                p=stack.pop();
                System.out.print(p.data);
                p=p.right;
            }
        }
    }
    /*
     * 后序遍历二叉树（非递归）
     *
     */
    public void PrintBinaryTreeBacUnrecur(TreeNode<T> root)
    {
        class NodeFlag<T>
        {
            TreeNode<T> node;
            char tag;
            public NodeFlag(TreeNode<T> node, char tag) {
                super();
                this.node = node;
                this.tag = tag;
            }
        }
        LinkedList<NodeFlag<T>> stack=new LinkedList<>();
        TreeNode<T> p=root;
        NodeFlag<T> bt;
        //栈不空或者p不空时循环
        while(p!=null || !stack.isEmpty())
        {
            //遍历左子树
            while(p!=null)
            {
                bt=new NodeFlag(p, 'L');
                stack.push(bt);
                p=p.left;
            }
            //左右子树访问完毕访问根节点
            while(!stack.isEmpty() && stack.getFirst().tag=='R')
            {
                bt=stack.pop();
                System.out.print(bt.node.data);
            }
            //遍历右子树
            if (!stack.isEmpty())
            {
                bt=stack.peek();
                bt.tag='R';
                p=bt.node;
                p=p.right;
            }
        }
    }
    /*
     * 层次遍历二叉树（非递归） 遍历每一层，从根节点开始，首先遍历根节点，输出，然后将左右节点加入队列，首先遍历左子树，输出，并将左子树的左右节点加入到队列里，然后遍历右子树，输出，并将右子树的左右节点加入到队列里。
     */
    public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root)
    {
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode<T> p;
        queue.push(root);
        while(!queue.isEmpty())
        {
            p=queue.removeFirst();
            System.out.print(p.data);
            if (p.left!=null)
                queue.addLast(p.left);
            if (p.right!=null)
                queue.addLast(p.right);
        }
    }


    /*
     * 层次遍历二叉树（非递归） 遍历每一层，从根节点开始，首先遍历根节点，输出，然后将左右节点加入队列，首先遍历左子树，输出，并将左子树的左右节点加入到队列里，然后遍历右子树，输出，并将右子树的左右节点加入到队列里。
     */
    public void PrintBinaryTreeLayerUnrecur2(TreeNode<T> root)
    {
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode<T> p;
        queue.addFirst(root);
        while(!queue.isEmpty()){

           p = queue.removeFirst();//删除对列前面，
           System.out.println(p.data);
           if (p.left !=null){
               queue.addLast(p.left);//如果有左节点，选择添加到队列后面
           }
           if (p.right!=null){
               queue.addLast(p.right);//如果有左节点，选择添加到队列后面
            }
        }

    }


    /*先序遍历
     * 深度遍历二叉树（非递归） 遍历每一层，从根节点开始，首先遍历根节点，输出，
     * 然后将左右节点加入队列，首先遍历左子树，输出，并将左子树的左右节点加入到队列里，然后遍历右子树，
     * 输出，并将右子树的左右节点加入到队列里。
     *
     */

    public void PrintBinaryTreeLayerUnrecur4(TreeNode<T> root)
    {

        Stack<TreeNode> myStack=new Stack<>();

        TreeNode<T> p;
        myStack.push(root);
        while(!myStack.isEmpty()){

            p = myStack.pop();//删除对列前面，
            System.out.print(p.data);
            if (p.right!=null){
                myStack.push(p.right);//如果有左节点，选择添加到队列后面
            }
            if (p.left !=null){
                myStack.push(p.left);//如果有左节点，选择添加到队列后面
            }

        }

    }

    public boolean isValidBST(TreeNode root) {

        if (root==null){
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root!=null){

           if (root != null){
               stack.push(root);
               root = root.left;
           }else {

                root = stack.pop();
//                if (pre.data< root.data){return false}
                pre = root;
                root =root.right;

           }


        }

        return true;

    }

    public void cengTreeLayerUnrecur4(TreeNode<T> root)
    {
        Stack<TreeNode> myStack=new Stack<>();
        TreeNode<T> p;
        myStack.push(root);
        while (!myStack.empty()){
            p = myStack.pop();
            if (p.left!=null){
               myStack.push(p.left) ;
            }
            if (p.right!=null){
                myStack.push(p.right) ;
            }

        }


    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        LinkedList<TreeNode > quee= new LinkedList<>();
        TreeNode curr = null;
        quee.addLast(root);
        while (!quee.isEmpty()){  //
            int size = quee.size();
            List<Integer> list = new ArrayList<>();
            for (int i=0;i<size;i++){//第一次一个，第二次两个（循环两次），第三次4个。
                curr = quee.removeFirst();
                list.add((Integer) curr.data);
                if (curr.left!=null){
                    quee.addLast(curr.left);
                }
                if (curr.right!=null){
                    quee.addLast(curr.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }


    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root==null) return lists;
        TreeNode p = null;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = linkedList.size();
            for (int i=0;i<size;i++){
                p = linkedList.removeFirst();
                list.add((Integer) p.data);
                if (p.left != null){
                    linkedList.add(p.left);
                }
                if (p.right != null){
                    linkedList.add(p.right);
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum          = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add((Integer) queue.poll().data);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
