package com.problem;

import java.util.ArrayList;
import java.util.List;

public class leetcode_22 {

	public static void main(String[] args) {

	}
	
	
	public static List<String> generateParenthesis(int n){
		List<String> combinations = new ArrayList<>();
		generateAll(new char[2*n],0,combinations);
		return combinations;
	}
	public static void generateAll(char[] current,int pos,List<String> result) {
		if(pos == current.length) {
			if(valid(current)) {
				result.add(new String(current));
			}
		}else {
			current[pos] = '(';
			generateAll(current,pos+1,result);
			current[pos]=')';
			generateAll(current,pos+1,result);
		}
	}
	public static boolean valid(char[] current) {
		int balance = 0;
		for(char c : current) {
			if(c=='(')
				balance++;
			else
				balance--;
			if(balance < 0)
				return false;
		}
		return (balance==0);
	}
	
	
	public static List<String> generateParenthesis_2(int n){
		List<String> res = new ArrayList<>();
		if(n==0) {
			return res;
		}
		dfs("",0,0,n,res);
		return res;
	}
	public static void dfs(String curStr,int left,int right,int n,List<String> res) {
		if(left==n&&right==n) {
			res.add(curStr);
		}
		
		if(left < right)
			return;
		if(left < n) {
			dfs(curStr+"(",left+1,right,n,res);
		}
		if(right < n) {
			dfs(curStr+")",left,right+1,n,res);
		}
	}
	
	public static List<String> generateParenthesis3(int n){
		if(n==0)
			return new ArrayList<>();
		List<List<String>> dp = new ArrayList<>(n);
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(dp0);
		
		for(int i = 1;i<=n;i++) {
			List<String> cur = new ArrayList<>();
			for(int j = 0;i<i;j++) {
				List<String> str1 = dp.get(j);
				List<String> str2 = dp.get(i-1-j);
				for(String s1:str1) {
					for(String s2:str2) {
						cur.add("("+s1+")"+s2);
					}
				}
			}
			dp.add(cur);
		} 
		return dp.get(n);
	}

}
