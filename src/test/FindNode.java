package test;

/**
 * @author zyh
 * @date 2020/6/12
 */
public class FindNode {
    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        digui(a, 0, 0);
    }

    private static void digui(int[][] a, int i, int j) {
        if (i != a.length) {
            if (j == a[i].length - 1) {
                System.out.println(a[i][j]);
                digui(a, ++i, 0);
            } else if (i < a.length) {
                System.out.println(a[i][j]);
                digui(a, i, ++j);
            }
        }
    }

}
