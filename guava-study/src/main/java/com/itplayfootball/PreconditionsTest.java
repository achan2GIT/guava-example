package com.itplayfootball;

import com.google.common.base.Preconditions;

/**
 * 参数检测
 */
public class PreconditionsTest {

	public static void main(String[] args) {
		int age = 140;
        //只有第一个表达式返回true才能正常通过，否则抛异常
        Preconditions.checkArgument(age > 0 && age < 150, "不合理的年龄:%s", age);

        int[] nums = new int[10];
        int index = 11;
        //只有index>=0 && index<nums.length才能通过
        Preconditions.checkElementIndex(index, nums.length);
        //同上
        Preconditions.checkPositionIndex(index, nums.length);
        //只有当start和end参数都处于size范围内才通过
        Preconditions.checkPositionIndexes(-1, 11, nums.length);

        Object obj = null;
        //只有obj不为null才通过
        Preconditions.checkNotNull(obj);

        //假设active是一个用户激活状态
        boolean active = false;
        Preconditions.checkState(active, "用户未激活");

	}

}
