package Bsearch;

/**
 * Created by admin on 2018/11/20.
 */
public class besearch2 {
    private int a[];
    private int value;

    public besearch2(int[] a, int value) {
        this.a = a;
        this.value = value;
    }

    /**
     * 查找第1个值等于给定值的方法
     *
     * @return
     */
    public int bsearch_01() {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value == a[mid]) {
                if (mid == 0 || a[mid - 1] != value)
                    return mid;
                else
                    high = mid - 1;

            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定的值
     *
     * @param
     */
    public int bsearch_02() {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (value == a[mid]) {
                if (mid == a.length - 1 || a[mid + 1] != value)
                    return mid;
                else
                    low = mid + 1;

            } else if (value < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第1个大于等于给定元素的值
     *
     * @return
     */
    public int bsearch_03() {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < value)
                low = mid + 1;
            else {
                if (mid == 0 || a[mid - 1] < value)
                    return mid;
                else
                    high = mid - 1;
            }

        }
        return -1;
    }

    /**
     * 查找最后一个小于等于value的值
     * @return
     */
    public int bsearch_04() {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > value)
                high = mid - 1;
            else {
                if (mid == a.length-1 || a[mid + 1] > value)
                    return mid;
                else
                    low = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 4, 5, 6, 7, 8, 8, 10, 12, 34, 44, 55, 67, 78, 78, 78, 123, 231, 231};
        besearch2 besearch2 = new besearch2(a, 231);
//        int index = besearch2.bsearch_01();
//        System.out.println(index+"  "+a[index]+"  left:"+a[index-1]);

//        int index = besearch2.bsearch_02();
//        System.out.println(index+"  "+a[index]+"  left:"+a[index-1]+"  right:"+a[index]);

//        int index = besearch2.bsearch_03();
//        System.out.println("index:"+index + " value: " + a[index] + "  left:" + a[index - 1] + "  right:" + a[index+1]);

        int index = besearch2.bsearch_04();
        System.out.println("index:"+index + " value: " + a[index] + "  left:" + a[index - 1] );

    }
}
