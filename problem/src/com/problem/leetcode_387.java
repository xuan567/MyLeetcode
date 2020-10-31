package com.problem;

import java.util.HashMap;

public class leetcode_387 {
	/*387. �ַ����еĵ�һ��Ψһ�ַ��Ѷȼ�257����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���
	 * ������������������������ڣ��򷵻� -1��
	ʾ����
	s = "leetcode"
	���� 0
	
	s = "loveleetcode"
	���� 2*/

	public static void main(String[] args) {
		String s = "leetcode";
		int n = firstUniqChar(s);
		System.out.println(n);
	}
	public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++) {
        	char c = s.charAt(i);
        	if(map.get(c)==1)
        		return i;
        }
        return -1;
    }
// ����һ����ϣ�����ַ��������е�Ԫ�ش��ȥ������¼���ֵĴ�����
// Ȼ���ٽ��ַ�������һ�飬����ڹ�ϣ��������Ӧ���ֵĴ��������
// ��ʱ��Ԫ�ض�Ӧ��������1��ֱ�ӷ��������������ַ��������껹û��
// ���֣�ֱ�ӷ���-1	
}
