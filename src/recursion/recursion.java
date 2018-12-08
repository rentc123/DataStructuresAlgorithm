package recursion;

/**
 * Created by admin on 2018/11/8.
 */
public class recursion {


    public static long fb(int N) {
        if (N == 1) return 1;
        if (N == 0) return 1;


        return fb(N - 1) + fb(N - 2);

    }

    public static void main(String[] args) {
        System.out.println(fb(15));
    }
}
