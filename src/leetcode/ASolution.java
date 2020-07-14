package leetcode;

/**
 * @author Administrator
 */
public class ASolution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] odd = new int[n + 2];
        int ans = 0, cnt = 0;
        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) == 1) {
                odd[++cnt] = i;
            }
        }
        odd[0] = -1;
        odd[++cnt] = n;
        for (int i = 1; i + k <= cnt; ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int nums[] = {1, 1, 2, 1, 1};
        // int k = 3;
        // System.out.println(numberOfSubarrays(nums, k));
        System.out.println(4 & 1);
    }
}
