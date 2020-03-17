package com.itplayfootball;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class ListTest {

	public static void main(String[] args) {
		//集合创建,各种以s结尾的工厂类简化了集合的创建。在创建泛型实例的时候，它们使代码更加简洁
		List<String> strList = Lists.newArrayList();
		List<String> list2 = Lists.newArrayList("a","b","c");
		Set<Integer> set = Sets.newHashSet();
		
		System.out.println(list2);
		
		
		//Map-List结构，对比java的普通写法，代码简洁不少
		Multimap<String,Integer> mmap = ArrayListMultimap.create();
		mmap.put("test", 11);
		mmap.put("test", 22);
		
		System.out.println(mmap);
		System.out.println(mmap.get("test"));

	}

}
