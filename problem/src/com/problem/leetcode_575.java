package com.problem;

import java.util.HashMap;

public class leetcode_575 {
	
	/*
	 * 575. 分糖果
		给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
		示例 1:
		输入: candies = [1,1,2,2,3,3]
		输出: 3
		解析: 一共有三种种类的糖果，每一种都有两个。
		最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
		
		示例 2 :
		输入: candies = [1,1,2,3]
		输出: 2
		解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，
		弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。*/

	public static void main(String[] args) {
		int[] candies = {1,1,2,3};
		int n = distributeCandies(candies);
		System.out.println(n);
	}
    public static int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<candies.length;i++) {
        	map.put(candies[i], map.getOrDefault(candies[i], 0)+1);
        }
        
        int n = map.size();
        int len = candies.length;
        int sum = 0;
        if(n>=len/2)
        	sum = len/2;
        else if(n < len/2) {
        	sum = n;
        }
        return sum;
    }
// 定义一个哈希表，记录总共有多少个不同的数字，即糖果的种类，因为是两个人平均分，
// 每个人分到的糖果数是总数的一半，如果糖果的种类>=糖果总数的一半，则返回糖果总
// 数的一半，否则返回糖果的种类   

}
