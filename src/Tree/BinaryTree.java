package Tree;

/**
 * Created by admin on 2018/12/4.
 */
public class BinaryTree {

    public static class Node<T> {
        public T data;
        private Node left;
        private Node right;

        public Node() {
            this.data = null;
            this.left = null;
            this.right = null;
        }

        public Node(T data) {
            this.data = data;
            this.left = new Node();
            this.right = new Node();
        }
    }

    private Node root;
    public int high;

    public BinaryTree() {
        this.root = new Node();
        this.high = 0;
    }

    public void add(Node node,Node root) {
        Node cur = root;
        if (cur.left == null)
            cur.left = node;
        else if (cur.right == null)
            cur.right = node;
        else {
            cur = cur.left;
            add(node,cur);
        }


    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node node1 = new Node<Integer>(1);
        Node node2 = new Node<Integer>(2);
        Node node3 = new Node<Integer>(3);
        Node node4 = new Node<Integer>(4);
        binaryTree.add(node1,binaryTree.root);
        binaryTree.add(node2,binaryTree.root);
        binaryTree.add(node3,binaryTree.root);
        binaryTree.add(node4,binaryTree.root);
        System.out.println();
    }
}
