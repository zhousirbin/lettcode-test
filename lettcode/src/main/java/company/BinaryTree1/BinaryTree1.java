package company.BinaryTree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree1<T> {

    List<T> list = null;
    public TreeNode<T> createBinaryTree(LinkedList<T> list){

        TreeNode<T> root =null;
        T data = list.removeFirst();
        if(data !=null){
            root = new TreeNode<T>(null,null,data);
            root.left = createBinaryTree(list);
        }
        return root;
    }

//先序遍历 根左右
    public void preBinary(TreeNode<T> root) {
        list  = new ArrayList<>();
        list.add(root.data);
        System.out.println(root.data);
        preBinary(root.left);
        preBinary(root.right);

    }

    //中序遍历 左右根

    public void midBinary(TreeNode<T> root) {
        if (root!=null) {

            list = new ArrayList<>();
            preBinary(root.left);
            list.add(root.data);
            System.out.println(root.data);
            preBinary(root.right);
        }

    }

    public void PrintBinaryTreeLayerUnrecur(TreeNode<T> root)
    {
        LinkedList<TreeNode>  quene = new LinkedList<>();
        quene.push(root);
        TreeNode p;
        while (!quene.isEmpty()){
            p = quene.removeFirst();
            System.out.println(p.data);
            if (p.left!=null){
                quene.addLast(p.left);
            }
            if (p.right!=null){
                quene.addLast(p.right);
            }
        }
     }
}
