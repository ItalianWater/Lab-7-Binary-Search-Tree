import java.util.*;

// Binary Search Tree class
public class Tree<E extends Comparable<E>> {
    private TreeNode<E> root;

    // Main method for testing the Tree class
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();

        Random random = new Random();
        List<Integer> values = new ArrayList<>();

        // Inserting 10 random integers from 0 to 99
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(100);
            values.add(value);
            tree.insertNode(value);
        }

        System.out.println("Inserting the following values:");
        for (int value : values) {
            System.out.printf("%d ", value);
        }
        System.out.println("\n");

        // Pre-order traversal
        System.out.println("Preorder traversal:");
        for (int value : tree.preorderTraversal()) {
            System.out.printf("%d ", value);
        }
        System.out.println("\n");

        // In-order traversal
        System.out.println("Inorder traversal:");
        for (int value : tree.inorderTraversal()) {
            System.out.printf("%d ", value);
        }
        System.out.println("\n");

        // Post-order traversal
        System.out.println("Postorder traversal:");
        for (int value : tree.postorderTraversal()) {
            System.out.printf("%d ", value);
        }
        System.out.println("\n");

        // Output tree
        System.out.println("Tree output:");
        tree.outputTree();
    }

    // Constructor initializes an empty Tree
    public Tree() {
        this.root = null;
    }

    // Insert a new node in the binary search tree
    public void insertNode(E insertValue) {
        root = insertRecursive(root, insertValue);
    }

    private TreeNode<E> insertRecursive(TreeNode<E> node, E insertValue) {
        if (node == null) {
            return new TreeNode<>(insertValue);
        }

        if (insertValue.compareTo(node.data) < 0) {
            node.leftNode = insertRecursive(node.leftNode, insertValue);
        } else if (insertValue.compareTo(node.data) > 0) {
            node.rightNode = insertRecursive(node.rightNode, insertValue);
        }

        return node;
    }

    // Pre-order traversal
    public List<E> preorderTraversal() {
        List<E> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }

        result.add(node.data);
        preorderHelper(node.leftNode, result);
        preorderHelper(node.rightNode, result);
    }

    // In-order traversal
    public List<E> inorderTraversal() {
        List<E> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }

        inorderHelper(node.leftNode, result);
        result.add(node.data);
        inorderHelper(node.rightNode, result);
    }

    // Post-order traversal
    public List<E> postorderTraversal() {
        List<E> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode<E> node, List<E> result) {
        if (node == null) {
            return;
        }

        postorderHelper(node.leftNode, result);
        postorderHelper(node.rightNode, result);
        result.add(node.data);
    }

    // Output tree method to display the tree
    public void outputTree() {
        outputTreeHelper(root, 0);
    }

    private void outputTreeHelper(TreeNode<E> node, int totalSpaces) {
        if (node == null) {
            return;
        }

        totalSpaces += 5;

        outputTreeHelper(node.rightNode, totalSpaces);

        System.out.println();
        for (int i = 5; i < totalSpaces; i++) {
            System.out.print(" ");
        }
        System.out.println(node.data);

        outputTreeHelper(node.leftNode, totalSpaces);
    }
}
