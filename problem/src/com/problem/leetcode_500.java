package com.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_500 {
	/*
	 * 500. 键盘行
	 示例：
	输入: ["Hello", "Alaska", "Dad", "Peace"]
	输出: ["Alaska", "Dad"]*/

	public static void main(String[] args) {
		String[] words = {"a","b"};
		String[] arr = findWords(words);
		for (String string : arr) {
			System.out.println(string);
		}
	}
    public static String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        int k=0;
        for(int i=0;i<words.length;i++) {
        	String s = words[i].toLowerCase();
        	if(s1.contains(String.valueOf(s.charAt(i)))) {
        		int j;
        		for(j=1;j<s.length();j++) {
        			if(!s1.contains(String.valueOf(s.charAt(j))))
        				break;
        		}
        		if(j>=s.length()) {
        			ans.add(s);
        		}
        	}
        	if(s2.contains(String.valueOf(s.charAt(i)))) {
        		int j;
        		for(j=1;j<s.length();j++) {
        			if(!s2.contains(String.valueOf(s.charAt(j))))
        				break;
        		}
        		if(j>=s.length()) {
        			ans.add(s);
        		}
        	}
        	if(s3.contains(String.valueOf(s.charAt(i)))) {
        		int j;
        		for(j=1;j<s.length();j++) {
        			if(!s3.contains(String.valueOf(s.charAt(j))))
        				break;
        		}
        		if(j>=s.length()) {
        			ans.add(s);
        		}
        	}
        }
        if(k==0)
        	return null;
        return ans.toArray(new String[ans.size()]);
    }
    
    public static String[] findWords1(String[] words) {
    	if(words == null) {
    		return null;
    	}
    	
    	String[] lines = new String[] {"qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"};

    	List<String> ans = new ArrayList();
    	for (String word : words) {
			if(judge(word.toLowerCase(),lines))
				ans.add(word);
		}
    	return ans.toArray(new String[ans.size()]);
    	
    }
    
    public static boolean judge(String word,String[] lines) {
    	String find = null;
    	for (String line : lines) {
			if(line.indexOf(word.charAt(0))>-1) {
				find = line;
				break;
			}
		}
    	if(find == null)
    		return false;
    	for(int i=0;i<word.length();i++) {
    		if(find.indexOf(word.charAt(i))<0)
    			return false;
    	}
    	return true;
    	
    }
 //将键盘行定义成lines字符串数组，逐个判断，先判断每一个word，将lines遍历，如果line
 //包含了word的第一个字符，将line取出，赋值给find，如果find！=null，此时将word遍历，
 //如果find不包含word[i]直接返回false，最后返回true；

}
