package com.problem;

import java.util.ArrayList;
import java.util.List;

public class leetcode_412 {
	/*
	 * 412. Fizz Buzz难度简单71写一个程序，输出从 1 到 n 数字的字符串表示。
		1. 如果 n 是3的倍数，输出“Fizz”；
		2. 如果 n 是5的倍数，输出“Buzz”；
		3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
		示例：
		n = 15,
		返回:
		[
		    "1",
		    "2",
		    "Fizz",
		    "4",
		    "Buzz",
		    "Fizz",
		    "7",
		    "8",
		    "Fizz",
		    "Buzz",
		    "11",
		    "Fizz",
		    "13",
		    "14",
		    "FizzBuzz"
		] */

	public static void main(String[] args) {
		List<String> list = fizzBuzz(15);
		System.out.println(list);
	}
    public static List<String> fizzBuzz(int n) {
    	List<String> list = new ArrayList<>();
    	for(int i=1;i<=n;i++) {
    		list.add(panduan(i));
    	}
    	return list;
    }
    
    public static String panduan(int n) {
    	if(n%3==0 && n%5 == 0) {
    		return "FizzBuzz";
    	}else if(n%3==0 && n%5 != 0) {
    		return "Fizz";
    	}else if(n%3!=0 && n%5 == 0) {
    		return "Buzz";
    	}else {
    		return String.valueOf(n);
    	}
    }

}
