package com.problem;

import java.util.HashMap;

public class leetcode_389 {
	/*
	 * 389. �Ҳ�ͬ�Ѷȼ�151���������ַ��� s �� t������ֻ����Сд��ĸ��
		�ַ��� t ���ַ��� s ������ţ�Ȼ�������λ�����һ����ĸ��
		���ҳ��� t �б���ӵ���ĸ��
		
		ʾ��:
		���룺
		s = "abcd"
		t = "abcde"
		�����
		e
*/

	public static void main(String[] args) {

	}
	public char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map1 = new HashMap<>();
		HashMap<Character, Integer> map2 = new HashMap<>();
		int i=0;
		for(i=0;i<s.length();i++) {
			map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
		}
		for(i=0;i<t.length();i++) {
			map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
		}
		for(i=0;i<t.length();i++) {
			if( !map1.containsKey(t.charAt(i)) || map1.get(t.charAt(i))!=map2.get(t.charAt(i))) {
                break;
			}
		}
        return t.charAt(i);
	}
//������������ϣ����һ����¼�ַ���s�и���Ԫ�س��ֵĴ�����
//�ڶ�����¼�ַ���t�и���Ԫ�س��ֵĴ�����Ȼ��Աȣ���map1��
//������t.charAt(i)���Ԫ����map1���ֵĴ�����������map2�г���
//�Ĵ�����ֱ��break������t.charAt(i)

}
