package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyh
 * @date 2020/7/6
 */
public class LeetCode5 {
    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        LeetCode5 l5 = new LeetCode5();
        System.out.println(l5.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().orElse(0);
        List<Boolean> booleans = new ArrayList<Boolean>();
        Arrays.stream(candies).forEach(s -> {
            booleans.add(max - s <= extraCandies);
        });
        return booleans;
        /*int n = candies.length;
        int maxCandies = 0;
        for (int i = 0; i < n; ++i) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        List<Boolean> ret = new ArrayList<Boolean>();
        for (int i = 0; i < n; ++i) {
            ret.add(candies[i] + extraCandies >= maxCandies);
        }
        return ret;*/
    }
}
