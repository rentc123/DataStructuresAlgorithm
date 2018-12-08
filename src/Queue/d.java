package Queue;

/**
 * Created by admin on 2018/11/7.
 */
public class d {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head表示队头下标，tail表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为capacity的数组
    public d(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    // 入队
    public boolean enqueue(String item) {
        // 队列满了
        if ((tail + 1) % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    // 出队
    public String dequeue() {
        // 如果head == tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        d q = new d(5);
        q.enqueue("1");
        q.enqueue("3");
        q.enqueue("4");
        q.dequeue();
        q.dequeue();
        q.enqueue("6");
        q.enqueue("7");
        q.enqueue("8");
        q.enqueue("9");
        q.enqueue("10");
        q.printAll();
    }
}
