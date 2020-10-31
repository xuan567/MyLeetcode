package com.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_30 {
	/*
	 * �Ѷ�����318����һ���ַ��� s ��һЩ������ͬ�ĵ��� words��
	 * �ҳ� s ��ǡ�ÿ����� words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�
	ע���Ӵ�Ҫ�� words �еĵ�����ȫƥ�䣬�м䲻���������ַ���
	������Ҫ���� words �е��ʴ�����˳��
	ʾ�� 1��
	���룺
	  s = "barfoothefoobarman",
	  words = ["foo","bar"]
	�����[0,9]
	���ͣ�
	������ 0 �� 9 ��ʼ���Ӵ��ֱ��� "barfoo" �� "foobar" ��
	�����˳����Ҫ, [9,0] Ҳ����Ч�𰸡�

*/

	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		List list = findSubstring(s,words);
		System.out.println(list);
	}
    public static List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res = new ArrayList<>();
    	if(s==null||s.length()==0||words==null||words.length==0)
    		return res;
    	int one_word = words[0].length();
    	int words_num = words.length;
    	int all_len = one_word * words_num;
    	HashMap<String,Integer> hm = new HashMap<String,Integer>();
    	for(String word:words) {
    		hm.put(word, hm.getOrDefault(word,0)+1);
    	}
    	for(int i=0;i<s.length()-all_len+1;i++) {
    		String tmp = s.substring(i,i+all_len);
    		HashMap<String,Integer> tmp_map = new HashMap<>();
    		for(int j=0;j<all_len;j+=one_word) {
    			String w = tmp.substring(j,j+one_word);
    			tmp_map.put(w,tmp_map.getOrDefault(w, 0)+1);
    		}
    		if(tmp_map.equals(hm))
    			res.add(i);
    	}
    	return res;
    }

}
