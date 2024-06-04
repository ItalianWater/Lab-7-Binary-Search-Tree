// Class representing each node in the tree
class TreeNode<E extends Comparable<E>> {
    E data;
    TreeNode<E> leftNode;
    TreeNode<E> rightNode;

    // Constructor initializes data and makes this a leaf node
    public TreeNode(E nodeData) {
        data = nodeData;
        leftNode = rightNode = null;
    }
}
