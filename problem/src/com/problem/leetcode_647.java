package com.problem;

public class leetcode_647 {
	/*647. �����Ӵ��Ѷ��е�322����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
	���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
	
	ʾ�� 1��
	���룺"abc"
	�����3
	���ͣ����������Ӵ�: "a", "b", "c"
	
	ʾ�� 2��
	���룺"aaa"
	�����6
	���ͣ�6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa"*/


	public static void main(String[] args) {
		String s = "abc";
		int n = countSubstrings(s);
		System.out.println(n);
		int n2 = countSubstrings2(s);
		System.out.println(n2);
	}
	
    public static int countSubstrings(String s) {
    	char[] arr = s.toCharArray();
    	int len = s.length();
    	int count = len;
    	for(int i = 0;i<len-1;i++) {
    		for(int j=i+1;j<len;j++) {
    			if(isHuiWen(arr,i,j)) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
    public static boolean isHuiWen(char[] arr,int i,int j) {
    	for(;i<=j;i++,j--) {
    		if(arr[i]!=arr[j])
    			return false;
    	}
    	return true;
    }
    
    public static int countSubstrings2(String s) {
    	int count =0;
    	int n = s.length();
    	for(int i=0;i<2*n-1;i++) {
    		int l = i/2;
    		int r = i/2+i%2;
    		while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)) {
    			l--;
    			r++;
    			count++;
    		}
    	}
    	return count;
    }

}

/* �Լ���˼·�ǽ������Ӵ�����һ��Ȼ���ж��Ƿ��ǻ����Ӵ����ǵĻ�count++��
 * Ȼ������⣬���ʹ����������չ������ʱ���ˣ���Ϊ�ǻ����ַ������������Ŀ�����
 * һ��Ҳ��������������2n-1�����ģ���i=0��ʼ������l=i/2��r=i%2��l--��r++�����ж�
 * �ǲ��ǻ��Ĵ�*/
