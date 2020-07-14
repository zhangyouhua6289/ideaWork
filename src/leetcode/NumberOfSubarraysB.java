package leetcode;

import java.util.Vector;

public class NumberOfSubarraysB {
    private Vector<Integer> cnt = new Vector<>();

    public int numberOfSubarrays(Integer[] nums, int k) {
        int n = nums.length;
        cnt.setSize(n + 1);
        int odd = 0, ans = 0;
        cnt.setElementAt(1, 0);
        for (int i = 0; i < n; ++i) {
            odd += (nums[i] & 1);
            ans += odd >= k ? cnt.indexOf(odd - k) : 0;
            cnt.setElementAt(cnt.indexOf(odd) + 1, odd);
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 1, 2, 1, 1};
        int k = 3;
        NumberOfSubarraysB b = new NumberOfSubarraysB();
        System.out.println(b.numberOfSubarrays(nums, k));
    }
}
