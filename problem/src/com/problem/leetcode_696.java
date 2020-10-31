package com.problem;

import java.util.ArrayList;
import java.util.List;

public class leetcode_696 {

	public static void main(String[] args) {
		String s = "00110011";
		int n =countBinarySubstrings(s);
		System.out.println(n);
	}
    public static int countBinarySubstrings(String s) {
//        int n=0,i,j,k;
//        for(i = 0;i<s.length();i++) {
//        	int flag = 0,a=0,b=0;
//        	for(j=i+1;j<s.length();j++) {
//        		if(flag<2&&a!=0&&b!=0&&a==b) {
//        			n++;
//        			System.out.println(s.substring(i,j+1));
//        		}
//        		if(s.charAt(j)!=s.charAt(j-1))
//        			flag++;
//        		if(flag>2)
//        			break;
//        		if(s.charAt(j)=='1')
//        			b++;
//        		if(s.charAt(j)=='0')
//        			a++;
//        	}
//        }
//        return n;
    	int ptr = 0,last = 0,ans=0,n=s.length();
    	while(ptr<n) {
    		int count = 0;
    		char c = s.charAt(ptr);
    		while(ptr<n&&s.charAt(ptr)==c) {
    			++ptr;
    			++count;
    		}
    		ans+=Math.min(last, count);
    		last = count;
    	}
    	return ans;
    }
}
