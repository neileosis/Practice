package utils;

public class TreeNode<T extends Comparable<?>> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T x) {
        val = x;
    }
}
