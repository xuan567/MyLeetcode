package com.problem;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		int n = 3;
	}
	
	public static List<String> generateParenthesis(int n){
		if(n==0)
			return new ArrayList<>();
		List<List<String>> dp = new ArrayList<>(n);
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(dp0);
		
		for(int i = 1;i<=n;i++) {
			List<String> cur = new ArrayList<>();
			for(int j = 0;j<i;j++) {
				List<String> str1 = dp.get(j);
				List<String> str2 = dp.get(i-j-1);
				for(String s1 : str1) {
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
