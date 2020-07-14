package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1,9,4,6,2,7,5,3});
        list = list.stream().sorted((n1,n2)->n1 > n2 ? -1 : 1).collect(Collectors.toList());
        System.out.println(list);

    }
}
