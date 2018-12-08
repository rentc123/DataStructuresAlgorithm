package Tree;

import java.util.TreeMap;

/**
 * Created by admin on 2018/12/3.
 */
public class Trie {

    private class Node<T> {
        public int value;
        public boolean isWord;
        public TreeMap<T, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.size = 0;
        root = new Node();
    }

    public int getSize() {
        return this.size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());

            cur = (Node) cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            this.size++;
        }
        cur.value++;
    }

    public boolean contain(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null)
                return false;
            cur = (Node) cur.next.get(c);
        }
        return cur.isWord;
    }


    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.add("good");
        trie.add("god");
        trie.add("bad");
        trie.add("boy");
        trie.add("boy");
        System.out.println();
        System.out.println(trie.contain("bad"));
    }

}
