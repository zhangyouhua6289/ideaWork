package test;

/**
 * @author zyh
 * @date 2020/6/10
 */
public class SumTest {
    public static void main(String[] args) {
        System.out.println(getFN(10));
    }

    public static int getFN(int n) {
        if (n <= 1) {
            return 1;
        }
        return getFN(n - 1) + getFN(n - 2);
    }
}
