package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyh
 * @date 2020/7/2
 */
public class LeetCode3 {
    public static void main(String[] args) {
        int[] nums = {0, 4, 3, 0};
        int target = 0;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other)) {
                indexs[0] = map.get(other);
                indexs[1] = i;
                return indexs;
            }
            map.put(nums[i], i);
        }
        return indexs;
    }
}
