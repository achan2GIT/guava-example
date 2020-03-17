package com.itplayfootball;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

/**
 * 排序器
 */
public class OrderingTest {

	public static void main(String[] args) {
		/**
         * nullsFirst()
         */
        List<Integer> toSort = Arrays.asList(3, 5, 4, null, 1, 2);
        //先把null值放在最前面，再把非null值按照自然排序
        Collections.sort(toSort, Ordering.natural().nullsFirst());
        Preconditions.checkState(toSort.get(0) == null);


        /**
         * nullsLast()
         */
        List<Integer> toSort1 = Arrays.asList(3, 5, 4, null, 1, 2);
        //先把null值放在最后，再把非null值按照自然排序
        Collections.sort(toSort1, Ordering.natural().nullsLast());
        Preconditions.checkState(toSort1.get(toSort1.size() - 1) == null);


        /**
         * natural()
         */
        List<Integer> toSort2 = Arrays.asList(3, 5, 4, 1, 2);
        //自然排序
        Collections.sort(toSort2, Ordering.natural());
        System.out.println(toSort2);
        
        //判断该集合是否已经按照指定排序器排序
        Preconditions.checkState(Ordering.natural().isOrdered(toSort2));


        /**
         * 自定义一个根据字符串长度排序的排序器
         */
        class OrderingByLenght extends Ordering<String> {
            @Override
            public int compare(String s1, String s2) {
                return Ints.compare(s1.length(), s2.length());
            }
        }
        //创建一个集合(也是guava的api)
        List<String> toSort3 = Arrays.asList("zz", "aa", "b", "ccc");
        Ordering<String> byLength = new OrderingByLenght();
        Collections.sort(toSort3, byLength);
        System.out.println(toSort3);
        //自定义一个期望的排序结果的排序器
        Ordering<String> expectedOrder = Ordering.explicit(Lists.newArrayList("b", "zz", "aa", "ccc"));
        //判断上面的集合是否按照期望的排序结果排序
        Preconditions.checkState(expectedOrder.isOrdered(toSort3));


        /**
         * reverse()
         */
        List<Integer> toSort4 = Arrays.asList(3, 5, 4, null, 1, 2);
        //反转Ordering.natural().nullsLast()
        Collections.sort(toSort4, Ordering.natural().nullsLast().reverse());
        Preconditions.checkState(toSort4.get(0) == null);


        /**
         * compound():组合排序器
         */
        List<String> toSort5 = Arrays.asList("zz", "aa", null, "b", "ccc");
        Collections.sort(toSort5,new OrderingByLenght().reverse().compound(Ordering.natural()).nullsLast());
        System.out.println(toSort5);


        /**
         * sortedCopy():创建一个按照排序器排序后的集合，但是不影响原集合的顺序
         */
        List<String> toSort6 = Arrays.asList("aa", "b", "ccc");
        List<String> sortedCopy = new OrderingByLenght().sortedCopy(toSort6);
        Ordering<String> expectedOrder2 = Ordering.explicit(Lists.newArrayList("b", "aa", "ccc"));
        //验证原集合是否被排序
        Preconditions.checkState(expectedOrder2.isOrdered(toSort6));
        //验证新集合是否被排序
        Preconditions.checkState(expectedOrder2.isOrdered(sortedCopy));

	}

}
