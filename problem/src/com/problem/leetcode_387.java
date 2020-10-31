package com.problem;

import java.util.HashMap;

public class leetcode_387 {
	/*387. 字符串中的第一个唯一字符难度简单257给定一个字符串，找到它的第一个不重复的字符，
	 * 并返回它的索引。如果不存在，则返回 -1。
	示例：
	s = "leetcode"
	返回 0
	
	s = "loveleetcode"
	返回 2*/

	public static void main(String[] args) {
		String s = "leetcode";
		int n = firstUniqChar(s);
		System.out.println(n);
	}
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(map.get(c)==1)
        		return i;
        }
        return -1;
    }
// 定义一个哈希表，将字符串中所有的元素存进去，并记录出现的次数，
// 然后再将字符串遍历一遍，检查在哈希表中它对应出现的次数，如果
// 此时该元素对应的数字是1，直接返回索引，若将字符串遍历完还没有
// 出现，直接返回-1	
}
