package com.problem;

import java.util.HashMap;

public class leetcode_522 {
	
	/*
	 * 522. ��������� II�Ѷ��е�42�����ַ����б�����Ҫ���������ҳ�����������С���������ж������£�������Ϊĳ�ַ������е�������У��������������ַ����������У���
		�����п���ͨ��ɾȥ�ַ����е�ĳЩ�ַ�ʵ�֣������ܸı�ʣ���ַ������˳�򡣿�����Ϊ�����ַ����������У��κ��ַ���Ϊ������������С�
		���뽫��һ���ַ����б��������������еĳ��ȡ������������в����ڣ����� -1 ��
		ʾ����
		����: "aba", "cdc", "eae"
		���: 3*/

	public static void main(String[] args) {

	}
	public int findLUSlength(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<strs.length;i++) {
			map.put(strs[i], map.getOrDefault(strs[i], 0)+1);
		}
		if(map.size()==1)
			return -1;
		int max = -1;
		for(String key : map.keySet()) {
			if(map.get(key)==1 && key.length()>max) {
				int t=0;
				for(String key1 : map.keySet()) {
					int i=0,j=0;
					for(;i<key.length()&& j<key1.length();j++) {
						if(key1.charAt(j)==key.charAt(i))
							i++;
					}
					if(i==key.length())
						t++;
				}
				if(t==1)
					max = Math.max(key.length(),max);
			}
		}
		return max;
    }
// ����һ����ϣ����ÿ���ַ������ֵĴ�����¼�����������ϣ���size����1��˵��
// ���е��ַ���һ����ֱ�ӷ���-1��Ȼ�󽫹�ϣ�����һ�飬��value==1ʱ�����Ҹ��ַ���
// �ĳ��ȴ���Ŀǰ�ģ�max������ϣ�����һ�飬������ַ������������ַ������ִ�����
// max���ڸ��ַ����ĳ��ȣ�max�����ֵ-1����ֹû������������ַ�������󷵻�max
}
