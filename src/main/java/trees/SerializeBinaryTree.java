package trees;

import utils.BinaryTreePrinter;
import utils.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, serialize it in brackets with nulls representing missing nodes. Then deserialize it.
 */
public class SerializeBinaryTree {

    public static void main(String[] args) {
        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();

        TreeNode<Integer> start = new TreeNode<>(1);
        start.left = new TreeNode<>(2);
        start.left.left = new TreeNode<>(3);
        start.right = new TreeNode<>(4);
        start.right.left = new TreeNode<>(5);
        start.right.left.right = new TreeNode<>(6);
        start.right.right = new TreeNode<>(7);
        start.right.right.left = new TreeNode<>(8);
        start.right.right.right = new TreeNode<>(9);

        System.out.println("---- Original Tree ----------------------");
        BinaryTreePrinter.printNode(start);
        String serializedTree = serializeBinaryTree.serialize(start);
        System.out.println(serializedTree);
        System.out.println();
        TreeNode<Integer> deserializedTree = serializeBinaryTree.deserialize(serializedTree);
        System.out.println("---- Deserialized Tree ----------------------");
        BinaryTreePrinter.printNode(deserializedTree);
    }

    private String serialize(TreeNode treeNode) {
        if (treeNode == null)
            return "[]";
        String serializedString = "[";
        serializedString += treeNode.val;
        LinkedList<TreeNode> nodesToView = new LinkedList<>();
        nodesToView.add(treeNode.left);
        nodesToView.add(treeNode.right);

        while (!nodesToView.isEmpty()) {
            TreeNode currentNode = nodesToView.pollFirst();
            if (currentNode == null) {
                serializedString += ",null";
            } else {
                serializedString += "," + currentNode.val;
                nodesToView.add(currentNode.left);
                nodesToView.add(currentNode.right);
            }
        }
        return serializedString + "]";
    }

    private TreeNode<Integer> deserialize(String inputString) {
        if (inputString == null || inputString.equals("[]"))
            return null;
        String[] inputSplit = inputString.replace("[","").replace("]","").split(",");
        TreeNode<Integer> start = new TreeNode<>(Integer.valueOf(inputSplit[0]));
        TreeNode<Integer> trackingNode = start;
        LinkedList<TreeNode<Integer>> nodesToReconstruct = new LinkedList<>();

        for (int i=1; i<inputSplit.length; i+=2) {
            String left = inputSplit[i];
            String right = inputSplit[i+1];
            if (left != null && !left.equals("null")) {
                TreeNode<Integer> treeNode = new TreeNode<>(Integer.valueOf(left));
                trackingNode.left = treeNode;
                nodesToReconstruct.add(treeNode);
            }
            if (right != null && !right.equals("null")) {
                TreeNode<Integer> treeNode = new TreeNode<>(Integer.valueOf(right));
                trackingNode.right = treeNode;
                nodesToReconstruct.add(treeNode);
            }
            trackingNode = nodesToReconstruct.pollFirst();
        }

        return start;
    }
}
