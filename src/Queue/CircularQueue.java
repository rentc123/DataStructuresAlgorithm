package Queue;

/**
 * 用数组实现循环的队列，不需要数据搬移。
 */

public class CircularQueue {

    public int length;
    private int[] array;
    private int head;
    private int tail;

    public CircularQueue(int length) {
        this.length = length;
        this.array = new int[length];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int data) {
        if ((tail + 1) % this.length == head)
            return false;


        array[tail] = data;//这里直接在tail位置放新数据
        tail = (tail + 1) % this.length; //保证不可能超过数组的长度，每次只要不满都有得放


        return true;
    }


    public boolean dequeue() {
        if (head == tail) {
            return false;
        }
        head = (head + 1) % this.length;
        return true;
    }

    public void printElements() {
        if (this.length == 0) return;
        for (int i = head; i % this.length != tail; i++) {//这里预留一个存储空间，这里需要修改
            System.out.println(array[i % this.length]);  //这里 示例代码 array[i] 是错误的

        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(1);
        q.enqueue(3);
        q.enqueue(4);
        q.dequeue();
        q.dequeue();
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);
        q.enqueue(10);
        q.enqueue(11);
        q.printElements();
    }

}
