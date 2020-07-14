package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode9 {
    public int numJewelsInStones(String J, String S) {
        Map<String,Integer> nums = new HashMap<String,Integer>();
        for(int i = 0;i< S.length();i++){
            String s = String.valueOf(S.charAt(i));
            if(nums.containsKey(s)){
                nums.put(s,nums.get(s)+1);
            }else {
                nums.put(s,1);
            }
        }
        int num = 0;
        for(int i = 0;i< J.length();i++){
            String s = String.valueOf(J.charAt(i));
            if(nums.containsKey(s)){
                num+= nums.get(s);
            }
        }
        return num;
    }
    public int numJewelsInStones1(String J, String S) {
        Set<Character> nums = new HashSet<>();
        for(Character c:J.toCharArray()){
            nums.add(c);
        }
        int num =0;
        for(Character c:S.toCharArray()){
            if(nums.contains(c)){
                num++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = String.valueOf('a');
        String ss = String.valueOf('A');
        System.out.println(s.equals(ss));
    }
}
