package Sort;

/**
 * Created by admin on 2018/11/13.
 */
public class quickSort {
    private int a[];
    private int N;

    public quickSort(int[] a, int n) {
        this.a = a;
        N = n;
    }

    private void sort() {
        quickSort(0, N - 1);
    }

    private void quickSort(int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partion(p, r);
        quickSort(p, q - 1);//这里q-1 区间 而不是q
        quickSort(q + 1, r);

    }

    private int partion(int p, int r) {
        int value = a[r];
        int i = p;

        for (int j = i; j < r; j++) {
            if (a[j] < value) { //大的不动，等着被小的交换，最终最大的就是在i位置，然后与r位置交换，保证r那个值在中间
                swap(i, j);
                i++;
            }
        }
        swap(i, r);

        return i;
    }

    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void printSort() {
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        int a[] = {0,6, 5,11, 3, 9, 8,55,23,-1};
        quickSort quickSort = new quickSort(a, a.length);
        quickSort.sort();
        quickSort.printSort();
    }
}
