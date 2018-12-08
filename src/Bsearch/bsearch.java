package Bsearch;

/**
 * 二分查找算法
 * Created by admin on 2018/11/19.
 */
public class bsearch {

    /**
     * 递归实现
     */
    public static int half(int a[], int value, int low, int high) {
        int mid = (low + high) / 2;
        if (low >= high)
            return -1;
        if (a[mid] == value)
            return mid;
        else if (a[mid] > value)
            return half(a, value, low, mid - 1);
        else
            return half(a, value, mid + 1, high);

    }

    public static int Bsearch(int a[], int value) {

        return half(a, value, 0, a.length - 1);
    }

    /**
     * 循环实现
     *
     * @param a
     * @param value
     * @param low
     * @param high
     * @return
     */
    public static int bsearchx(int a[], int value, int low, int high) {

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value == a[mid]) {
                return mid;
            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;


    }

    /**
     * 二分求开方，精确6位
     * @param n
     * @return
     */
    public static double sqrt(double n) {

        double low = 0.0;
        double high = n;
        while (low <= high) {
            double mid = low + (high - low) / 2;
            if (Math.abs(n - mid * mid) <= 0.00001 || n==mid*mid)
                return mid;
            else if (mid * mid > n - 0.0000000000001) {
                high = mid - 0.0000000000001;
            } else if (mid * mid < n - 0.0000000000001) {
                low = mid + 0.0000000000001;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {1, 3, 5, 7, 13, 16, 41, 134, 256, 675, 1231, 6555};
//        int index = Bsearch(a, 35);
//        if (index != -1)
//            System.out.println(index + " " + a[index]);
//        else
//            System.out.println("Not found！");


//        int index2 = bsearchx(a, 42, 0, a.length - 1);
//        if (index2 != -1)
//            System.out.println(index2 + " " + a[index2]);
//        else
//            System.out.println("Not found！");

        System.out.println(sqrt(36));
    }
}
