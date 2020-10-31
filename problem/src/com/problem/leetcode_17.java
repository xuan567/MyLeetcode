package com.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class leetcode_17 {
	/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
		给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
		"23"
		输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
		*/
    public List<String> letterCombinations1(String digits) {
    	LinkedList<String> ans = new LinkedList<>();
    	String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    	if(digits.isEmpty())
    		return ans;
    	ans.add("");
    	for(int i=0;i<digits.length();i++) {
    		int x = Character.getNumericValue(digits.charAt(i));
    		while(ans.peek().length()==i) {
    			String t = ans.remove();
    			for(char s: mapping[x].toCharArray()) {
    				ans.add(t+s);
    			}
    		}
    	}
    	return ans;
    }
/*将数字与对应的按键存到字符串数组里，先判断digits是否是空的，然后遍历digits，
 * 将对应的索引的数字转换成int类型，循环的条件是链表的第一个元素的长度==i，
 * 就是等于未添加新元素的原来的字符串的长度，这样不会漏掉字符串，然后将链表第一个元素
 * 移除，将其加上新元素，再一同添加到链表里，循环知道digits的最后一个元素。
 */
    
    
    
    Map<String,String> map = new HashMap<>() {
    	{
    		put("2","abc");
    		put("3","def");
    		put("4","ghi");
    		put("5","jkl");
    		put("6","mno");
    		put("7","pqrs");
    		put("8","tuv");
    		put("9","wxyz");
    	}
    };
    public List<String> letterCombinations2(String digits){
    	List<String> res = new ArrayList<>();
    	if(digits==null||digits.length()==0)
    		return res;
    	dfs(new StringBuilder(),digits,0,res);
    	return res;
    }
    public void dfs(StringBuilder sb,String digits,int n,List<String> res) {
    	if(n==digits.length()) {
    		res.add(sb.toString());
    		return;
    	}
    	int c = Integer.parseInt(String.valueOf(digits.charAt(n)));
    	String s = map.get(c);
    	for(int i=0;i<s.length();i++) {
    		sb.append(s.charAt(i));
    		dfs(sb,digits,n+1,res);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    
}
		