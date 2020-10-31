package com.problem;

public class leetcode_520 {
	/*
	 * 520. 检测大写字母
		给定一个单词，你需要判断单词的大写使用是否正确。
		我们定义，在以下情况时，单词的大写用法是正确的：
		全部字母都是大写，比如"USA"。
		单词中所有字母都不是大写，比如"leetcode"。
		如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
		否则，我们定义这个单词没有正确使用大写字母。
		示例 1:
		输入: "USA"
		输出: True
		示例 2:
		输入: "FlaG"
		输出: False*/

	public static void main(String[] args) {
		
	}
    public boolean detectCapitalUse(String word) {
        if(Character.isUpperCase(word.charAt(0))) {
        	int l = 0;
        	int U = 0;
        	for(int i=1;i<word.length();i++) {
        		if(Character.isUpperCase(word.charAt(i)))
        			U++;
        		else
        			l++;
        	}
        	if(U==0&&l==word.length()-1)
        		return true;
        	else if(l==0 && U==word.length()-1)
        		return true;
        }
        else {
        	for(int i=1;i<word.length();i++) {
        		if(Character.isUpperCase(word.charAt(i))) {
        			return false;
        		}
        	}
        	return true;
        }
        return false;
    }
// 先判断第一个字母的大小写，分两种情况，1.大写，判断，如果之后的字母都是大写，返回true
// 之后的字母都是小写，返回true，否则返回false；2。小写，判断如果之后都是小写，返回true，
// 否则返回true。    
    
}
