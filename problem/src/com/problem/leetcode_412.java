package com.problem;

import java.util.ArrayList;
import java.util.List;

public class leetcode_412 {
	/*
	 * 412. Fizz Buzz�Ѷȼ�71дһ����������� 1 �� n ���ֵ��ַ�����ʾ��
		1. ��� n ��3�ı����������Fizz����
		2. ��� n ��5�ı����������Buzz����
		3.��� n ͬʱ��3��5�ı�������� ��FizzBuzz����
		ʾ����
		n = 15,
		����:
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
