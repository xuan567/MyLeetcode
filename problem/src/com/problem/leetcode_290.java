package com.problem;

import java.util.HashMap;

public class leetcode_290 {
	/*示例1:

	输入: pattern = "abba", str = "dog cat cat dog"
	输出: true
	
	示例 2:
	
	输入:pattern = "abba", str = "dog cat cat fish"
	输出: false
	 */

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean b = wordPattern(pattern,str);
		System.out.println(b);
	}
    public static boolean wordPattern(String pattern, String str) {
    	HashMap<Character,String> map = new HashMap<>();
        String[] arr = str.split(" ");
        if(pattern.length()!=arr.length)
        	return false;
        for(int i=0;i<pattern.length();i++) {
        	char c = pattern.charAt(i);
        	if(!map.containsKey(c)) {
        		if(map.containsValue(arr[i]))
        			return false;
        		map.put(c, arr[i]);
        	}else {
        		if(!map.get(c).equals(arr[i])) {
        			return false;
        		}
        	}
        }
        return true;
     }

}
