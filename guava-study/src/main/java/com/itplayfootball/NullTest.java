package com.itplayfootball;

import com.google.common.base.Optional;

/**
 * null值的安全处理
 */
public class NullTest {

	public static void main(String[] args) {
		//fromNullable()允许传入null作为参数
        Optional s1 = Optional.fromNullable(null);
                
        System.out.println(s1);//Optional.absent()

        //of()要求参数一定不能为null
        Optional s2 = Optional.of("hello");

        System.out.println(s2.get());

	}

}
