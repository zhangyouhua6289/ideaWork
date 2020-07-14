package leetcode;

/**
 * @author zyh
 * @date 2020/7/7
 */
public class LeetCode7 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        LeetCode7 l7 = new LeetCode7();
        System.out.println(l7.reverseLeftWords(s, k));
    }

    public String reverseLeftWords(String s, int n) {
        if ((s == null || s.length() == 0) || s.length() < n) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        str.append(s.substring(n)).append(s.substring(0, n));
        return str.toString();
    }

    public String reverseLeftWords1(String s, int n) {
        if ((s == null || s.length() == 0) || s.length() < n) {
            return s;
        }
        StringBuilder str = new StringBuilder();
        for (int i = n; i < n + s.length(); i++)
            str.append(s.charAt(i % s.length()));
        return str.toString();
    }
}
