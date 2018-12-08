package Tree;

/**
 * Created by admin on 2018/12/5.
 */
public class BSTree {
    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node root;

    public BSTree() {
        this.root = null;
    }

    public void insert(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        }
        Node p = root;
        while (p != null) {
            if (data < p.data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;

            } else if (data > p.data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;

            }
        }
    }

    public boolean find(int data) {
        if (root == null)
            return false;
        Node p = root;
        while (p != null) {
            if (data == p.data) {
                return true;
            } else if (data < p.data) {
                if (p.left == null) {
                    return false;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    return false;
                }
                p = p.right;

            }
        }


        return false;
    }

    public void preOrder() {

    }

    public void inOrder(Node p) {

        if (p == null) return;
//        if (p.left != null) {
            inOrder(p.left);
//        }
        System.out.println(p.data);
//        if (p.right != null) {
            inOrder(p.right);
//        }


    }

    public void postOrder() {

    }

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.insert(2);
        bsTree.insert(1);
        bsTree.insert(3);
        bsTree.insert(4);
        bsTree.insert(7);
        bsTree.insert(6);
        bsTree.insert(9);

        System.out.println(bsTree.find(3));
        System.out.println(bsTree.find(5));

        bsTree.inOrder(bsTree.root);
        System.out.println();
    }

}
