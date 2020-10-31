package com.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class leetcode_17 {
	/*����һ������������ 2-9 ���ַ����������������ܱ�ʾ����ĸ��ϡ�
		�������ֵ���ĸ��ӳ�����£���绰������ͬ����ע�� 1 ����Ӧ�κ���ĸ��
		"23"
		�����["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
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
/*���������Ӧ�İ����浽�ַ�����������ж�digits�Ƿ��ǿյģ�Ȼ�����digits��
 * ����Ӧ������������ת����int���ͣ�ѭ��������������ĵ�һ��Ԫ�صĳ���==i��
 * ���ǵ���δ�����Ԫ�ص�ԭ�����ַ����ĳ��ȣ���������©���ַ�����Ȼ�������һ��Ԫ��
 * �Ƴ������������Ԫ�أ���һͬ��ӵ������ѭ��֪��digits�����һ��Ԫ�ء�
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
		