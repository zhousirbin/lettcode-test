package company.BinaryTree1;

public class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(TreeNode<T> left,TreeNode<T> right,T data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
