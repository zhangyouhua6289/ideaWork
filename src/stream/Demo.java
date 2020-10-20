package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author zhangyouhua
 * @date 2020/9/22 15:16
 */
public class Demo {
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length);
        Arrays.parallelPrefix(sums, Double::sum);
        int start = n - 1;
        return IntStream.range(start, sums.length).mapToDouble(i -> {
            double prefix = (i == start ? 0 : sums[i - n]);
            return (sums[i] - prefix) / n;
        }).toArray();
    }

    public static void main(String[] args) {
        double[] values = {0, 1, 2, 3, 4, 3.5};
        double[] vas = simpleMovingAverage(values, 3);
        for (double value : vas) {
            System.out.println(value);
        }
    }
}
