package Sort;

/**
 * Created by admin on 2018/11/13.
 */
public class findtopK {
    private int a[];
    private int N;
    private int K;

    public findtopK(int[] a, int n, int k) {
        this.a = a;
        N = n;
        this.K = k;
    }

    private int sort() {
        return quickSort(K, 0, N - 1);
    }

    private int quickSort(int k, int p, int r) {
        if (p >= r) {
            return a[r];
        }

        int q = partion(p, r);
        int k0 = q - p + 1; // q-p+1不是 p-q+1
        if (k0 == k) {
            return a[q];
        } else if (k0 > k) {
            return quickSort(k, p, q - 1);//越往右边去值越小了，要往左边找

        } else
            return quickSort(k - k0, q + 1, r);//在右边那部分需要减掉已知的k0部分，剩下那部分继续找第k-k0大的

    }

    private int partion(int p, int r) {
        int value = a[r];
        int i = p;

        for (int j = i; j < r; j++) {
            if (a[j] > value) { //比主元大的i,j交换 i++ j++,小的j+1
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
        int a[] = {0, 6, 5, 11, 3, 9, 8, 55, 23};
        findtopK quickSort = new findtopK(a, a.length, 3);
        int v = quickSort.sort();
//        quickSort.printSort();

        System.out.println(v);
    }
}
