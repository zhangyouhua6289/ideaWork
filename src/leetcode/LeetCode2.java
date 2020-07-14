package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date 2020/4/24
 */
public class LeetCode2 {
    public static String twoSum(int[] nums, int target) {
        StringBuilder aa = new StringBuilder();
        if (nums.length <= 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    aa.append(i).append(",").append(j).append("^");
                }
            }
        }
        if (aa.length() > 0)
            return aa.toString();
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[] {2, 7, 11, 3, 6, 15}, 9));
    }
}
