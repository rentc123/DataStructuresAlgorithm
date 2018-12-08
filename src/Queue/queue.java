package Queue;

/**
 * 用数组实现普通的队列
 */

public class queue {

    public int length;
    private int[] array;
    private int head;
    private int tail;

    public queue(int length) {
        this.length = length;
        this.array = new int[length];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(int data) {
        if (tail == this.length)
            return false;

        array[tail] = data;//这里直接在tail位置放新数据
        tail += 1;
        return true;
    }

    /**
     * 动态的，当数组没有空间时，启动数据搬移
     *
     * @return
     */
    public boolean dynamicEnqueu(int data) {
        if (tail == this.length) {
            if (head == 0) {//说明一直插入进去没有出过。数组已经存满。
                return false;
            }
            System.out.println("数据搬移");
            for (int i = head; i < tail; i++) {
                array[i - head] = array[i];
            }


            tail -= head;
            head = 0;

        }
        //继续执行下去
        array[tail] = data;//这里直接在tail位置放新数据
        tail += 1;

        return true;
    }


    public boolean dequeue() {
        if (head == tail) {
            return false;
        }
        head += 1;
        return true;
    }

    public void printElements() {
        for (int i = head; i < tail; i++) {//这里预留一个存储空间
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        queue q = new queue(5);
        q.dynamicEnqueu(1);
        q.dynamicEnqueu(3);
        q.dynamicEnqueu(4);
        q.dequeue();
        q.dequeue();
        q.dynamicEnqueu(6);
        q.dynamicEnqueu(7);
        q.dynamicEnqueu(8);
        q.dynamicEnqueu(9);
        q.printElements();
    }

}
