package test;

import java.util.List;

/**
 * @author zhangyouhua
 * @date 2020/10/15 8:16
 */
public class TestError {
    public static void main(String[] args) {
        try {
            List<String> a = null;
            a.add("aa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("aaa");
    }
}
