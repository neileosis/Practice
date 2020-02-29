package trees;

import utils.TreeNode;

import java.util.LinkedList;

/**
 * Given a binary tree, serialize it in brackets with nulls representing missing nodes. Then deserialize it.
 */
public class SerializeBinaryTree {

    public String serialize(TreeNode treeNode) {
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

    public TreeNode<Integer> deserialize(String inputString) {
        if (inputString == null || inputString.equals("") || inputString.equals("[]"))
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
