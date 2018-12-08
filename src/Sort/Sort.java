package Sort;

/**
 * Created by admin on 2018/11/12.
 */
public class Sort {

    private int[] s;
    private int N;

    public Sort(int[] s) {
        this.s = s;
        this.N = s.length;
    }

    public void printSort() {
        for (int i = 0; i < s.length; i++) {

            System.out.println(s[i]);
        }

    }

    /**
     * 冒泡排序，每次把最大的放在最后面
     */
    public void bubbleSort() {
        int N = s.length;
        for (int i = N; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    int tmp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }


    }

    /**
     * 插入排序
     * 已排序区间，未排序区间，每次让未排序区间的每个数放在已排序区间合适位置。
     */
    public void insertSort() {

        for (int i = 1; i < N; i++) {
            int tmp = s[i];//放在这里合适
            int j = i - 1;
            for (; j >= 0; j--) {//  >==0
                if (tmp < s[j]) {
                    s[j + 1] = s[j];
                } else {
                    break;
                }
            }
            s[j + 1] = tmp;//需要获取当前j的位置  //j已经j = i - 1;减掉了1  这里需要 +1

        }

    }


    /**
     * 选择排序
     * 每次在未排序区间找最小的放在已排序区间的最后面
     */

    public void swapSort() {
        for (int i = 0; i < N-1; i++) {
            int min = s[i];
            int min_index = 0;
            int j = i + 1;
            for (; j < N; j++) {
                if (s[j] < min) {
                    min = s[j];
                    min_index = j;
                }
            }
            if (s[i] > min) {
                int tmp = s[i];
                s[i] = s[min_index];
                s[min_index] = tmp;
            } else {
//                int tmp = s[i + 1];
//                s[i + 1] = min;
//                s[min_index] = tmp;
                continue;
            }
        }
    }



    public static void main(String[] args) {
        int s[] = {0,9,5, 8, 1, 3, 2, 4,10,-1};
        Sort sort = new Sort(s);
        sort.insertSort();
        sort.swapSort();
        sort.printSort();
    }
}
