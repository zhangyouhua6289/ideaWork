package leetcode;

import java.util.Arrays;

/**
 * @author zyh
 * @date 2020/7/7
 */
public class LeetCode6 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;
        LeetCode6 l6 = new LeetCode6();
        Arrays.stream(l6.shuffle1(nums, n)).forEach(System.out::println);
    }

    public int[] shuffle(int[] nums, int n) {
        if (n <= 0) {
            return new int[0];
        }
        int[] news = new int[2 * n];
        for (int i = 0; i < nums.length; i++) {
            if (i < n) {
                news[2 * i] = nums[i];
            } else {
                news[2 * (i - n) + 1] = nums[i];
            }
        }
        return news;
    }

    // 双指针法
    public int[] shuffle1(int[] nums, int n) {
        int i = 0, j = n, index = 0;
        int size = nums.length;
        int[] news = new int[2 * n];
        while (i < n && j < size && index < size) {
            news[index] += nums[i];
            index++;
            news[index] += nums[j];
            index++;
            i++;
            j++;
        }
        return news;
    }
}
