package com.problem;

import java.util.HashMap;

public class leetcode_522 {
	
	/*
	 * 522. 最长特殊序列 II难度中等42给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
		子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
		输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
		示例：
		输入: "aba", "cdc", "eae"
		输出: 3*/

	public static void main(String[] args) {

	}
	public int findLUSlength(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<strs.length;i++) {
			map.put(strs[i], map.getOrDefault(strs[i], 0)+1);
		}
		if(map.size()==1)
			return -1;
		int max = -1;
		for(String key : map.keySet()) {
			if(map.get(key)==1 && key.length()>max) {
				int t=0;
				for(String key1 : map.keySet()) {
					int i=0,j=0;
					for(;i<key.length()&& j<key1.length();j++) {
						if(key1.charAt(j)==key.charAt(i))
							i++;
					}
					if(i==key.length())
						t++;
				}
				if(t==1)
					max = Math.max(key.length(),max);
			}
		}
		return max;
    }
// 定义一个哈希表，把每个字符串出现的次数记录下来，如果哈希表的size等于1，说明
// 所有的字符串一样，直接返回-1，然后将哈希表遍历一遍，当value==1时，并且该字符串
// 的长度大于目前的，max，将哈希表遍历一遍，如果该字符串不是其他字符串的字串，则
// max等于该字符串的长度，max最初赋值-1，防止没有最特殊的子字符串，最后返回max
}
