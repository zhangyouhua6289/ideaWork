package util;

import java.util.*;

import org.apache.commons.math3.util.Pair;
import org.junit.platform.commons.util.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhangyouhua
 * @date 2020/10/20 11:08
 */
public class WeightRandom<K, V extends Number> {
    private TreeMap<Double, K> weightMap = new TreeMap<Double, K>();
    private static final Logger logger = LoggerFactory.getLogger(WeightRandom.class);

    public WeightRandom(List<Pair<K, V>> list) {
        Preconditions.notNull(list, "list can NOT be null!");
        for (Pair<K, V> pair : list) {
            Preconditions.condition(pair.getValue().doubleValue() > 0, String.format("非法权重值：pair=%s", pair));

            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey().doubleValue();// 统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());// 权重累加
        }
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }

    public static void main(String[] args) {
        List<Pair<String, Integer>> list = new ArrayList<>();
        list.add(new Pair("A", 1));
        list.add(new Pair("B", 2));
        list.add(new Pair("C", 3));
        list.add(new Pair("D", 4));
        // list.add(new Pair("E", 0));
        WeightRandom<String, Integer> random = new WeightRandom<>(list);
        Map<String, Integer> countMap = new HashMap();
        for (int i = 0; i < 100000000; i++) {
            String randomKey = random.random();
            countMap.put(randomKey, countMap.getOrDefault(randomKey, 0) + 1);
        }

        for (Pair<String, Integer> pair : list) {
            System.out.println(pair.getKey() + ":" + countMap.get(pair.getKey()));
        }
    }

}
