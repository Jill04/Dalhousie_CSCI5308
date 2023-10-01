import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    BinaryTree tree = null;
    @BeforeEach
    void setUp() {
        tree = new BinaryTree();
    }

    @Test
        // Creating an empty binary tree and checking that its root is null.
    void testForEmptyTree() {
        assertNull(tree.root);
    }

    @Test
        // Inserting a single node into the tree and checking that it is the root.
    void testForRootNode() {
        tree.add(24);
        assertTrue(tree.root.getData() == 24);
        assertTrue(tree.size == 1);
    }

    @Test
        // To test whether correct tree is constructed
    void testTreeNode() {
        tree.add(20);
        tree.add(12);
        tree.add(45);
        tree.add(5);
        tree.add(34);
        assertTrue(tree.root.getLeftNode().getData() == 12);
    }

    @Test
        // To count the leaf nodes
    void testCountLeafNode() {
        tree.add(20);
        tree.add(12);
        tree.add(45);
        tree.add(5);
        tree.add(34);
        tree.add(61);
        assertTrue(tree.countLeaves(tree.root) == 3);
    }
}