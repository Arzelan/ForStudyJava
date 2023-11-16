package cc.xdev.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class AveragingDoubleExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        //collect() 方法会把所有的元素收集起来然后传递给 Collectors.averagingDouble(d->`d*2) 收集器，
        // 对每个元素执行 *2 操作后计算平均值
        Double result = list.stream().collect(Collectors.averagingDouble(d->d*2));
        System.out.println(result);
    }
}