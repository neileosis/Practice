package trees;

import org.junit.Assert;
import org.junit.Test;
import utils.TreeNode;

public class SerializeBinaryTreeTest {

    private SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();

    @Test
    public void testSimplePerfectTreeSerialization() {
        Assert.assertEquals(perfectTreeSerialized(), serializeBinaryTree.serialize(buildPerfectTree()));
    }

    @Test
    public void testBinaryTreeSerialization() {
        Assert.assertEquals(binaryTreeSerialized(), serializeBinaryTree.serialize(buildBinaryTree()));
    }

    @Test
    public void testSingleNodeInputSerialization() {
        Assert.assertEquals("[1,null,null]", serializeBinaryTree.serialize(new TreeNode<>(1)));
    }

    @Test
    public void testNullInputSerialization() {
        Assert.assertEquals("[]", serializeBinaryTree.serialize(null));
    }

    @Test
    public void testSimplePerfectTreeDeserialization() {
        Assert.assertTrue(identicalTrees(buildPerfectTree(), serializeBinaryTree.deserialize(perfectTreeSerialized())));
    }

    @Test
    public void testBinaryTreeDeserialization() {
        Assert.assertTrue(identicalTrees(buildBinaryTree(), serializeBinaryTree.deserialize(binaryTreeSerialized())));
    }

    @Test
    public void testSingleNodeInputDeserialization() {
        Assert.assertTrue(identicalTrees(buildPerfectTree(), serializeBinaryTree.deserialize(perfectTreeSerialized())));
    }

    @Test
    public void testNullInputDeserialization() {
        Assert.assertNull(serializeBinaryTree.deserialize(null));
    }

    @Test
    public void testEmptyInputDeserialization() {
        Assert.assertNull(serializeBinaryTree.deserialize(""));
    }

    @Test
    public void testEmptyBracketsInputDeserialization() {
        Assert.assertNull(serializeBinaryTree.deserialize("[]"));
    }

    private TreeNode<Integer> buildPerfectTree() {
        TreeNode<Integer> start = new TreeNode<>(1);
        start.left = new TreeNode<>(2);
        start.right = new TreeNode<>(4);
        return start;
    }

    private String perfectTreeSerialized() {
        return "[1,2,4,null,null,null,null]";
    }

    private TreeNode<Integer> buildBinaryTree() {
        TreeNode<Integer> start = new TreeNode<>(1);
        start.left = new TreeNode<>(2);
        start.left.left = new TreeNode<>(3);
        start.right = new TreeNode<>(4);
        start.right.left = new TreeNode<>(5);
        start.right.left.right = new TreeNode<>(6);
        start.right.right = new TreeNode<>(7);
        start.right.right.left = new TreeNode<>(8);
        start.right.right.right = new TreeNode<>(9);
        return start;
    }

    private String binaryTreeSerialized() {
        return "[1,2,4,3,null,5,7,null,null,null,6,8,9,null,null,null,null,null,null]";
    }

    private boolean identicalTrees(TreeNode a, TreeNode b) {
        /*1. both empty */
        if (a == null && b == null)
            return true;

        /* 2. both non-empty -> compare them */
        if (a != null && b != null)
            return (a.val == b.val
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));

        /* 3. one empty, one not -> false */
        return false;
    }
}
