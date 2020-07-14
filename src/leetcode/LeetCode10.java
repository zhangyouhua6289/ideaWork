package leetcode;

public class LeetCode10 {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public String defangIPaddr1(String address) {
        return address.replace(".", "[.]");
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode10().defangIPaddr("1.1.1.1"));
    }
}
