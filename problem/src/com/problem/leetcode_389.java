package com.problem;

import java.util.HashMap;

public class leetcode_389 {
	/*
	 * 389. 找不同难度简单151给定两个字符串 s 和 t，它们只包含小写字母。
		字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
		请找出在 t 中被添加的字母。
		
		示例:
		输入：
		s = "abcd"
		t = "abcde"
		输出：
		e
*/

	public static void main(String[] args) {

	}
	public char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		int i=0;
		for(i=0;i<s.length();i++) {
			map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
		}
		for(i=0;i<t.length();i++) {
			map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
		}
		for(i=0;i<t.length();i++) {
			if( !map1.containsKey(t.charAt(i)) || map1.get(t.charAt(i))!=map2.get(t.charAt(i))) {
                break;
			}
		}
        return t.charAt(i);
	}
//建立了两个哈希表，第一个记录字符串s中各个元素出现的次数，
//第二个记录字符串t中各个元素出现的次数，然后对比，若map1中
//不包含t.charAt(i)或该元素在map1出现的次数不等于在map2中出现
//的次数，直接break，返回t.charAt(i)

}
