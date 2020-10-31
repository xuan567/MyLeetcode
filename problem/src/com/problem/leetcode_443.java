package com.problem;

public class leetcode_443 {
	/*
	 * 443. ѹ���ַ���
	����һ���ַ���ʹ��ԭ���㷨����ѹ����
	ѹ����ĳ��ȱ���ʼ��С�ڻ����ԭ���鳤�ȡ�
	�����ÿ��Ԫ��Ӧ���ǳ���Ϊ1 ���ַ������� int �������ͣ���
	�����ԭ���޸���������󣬷���������³��ȡ�
 	���ף�
	���ܷ��ʹ��O(1) �ռ������⣿
 
	ʾ�� 1��
	���룺
	["a","a","b","b","c","c","c"]
	�����
	���� 6 �����������ǰ 6 ���ַ�Ӧ���ǣ�["a","2","b","2","c","3"]
	˵����
	"aa" �� "a2" �����"bb" �� "b2" �����"ccc" �� "c3" �����
	
	ʾ�� 2��
	���룺
	["a"]
	�����
	���� 1 �����������ǰ 1 ���ַ�Ӧ���ǣ�["a"]
	���ͣ�
	û���κ��ַ����������
	
	ʾ�� 3��
	���룺
	["a","b","b","b","b","b","b","b","b","b","b","b","b"]
	�����
	���� 4 �����������ǰ4���ַ�Ӧ���ǣ�["a","b","1","2"]��
	���ͣ�
	�����ַ� "a" ���ظ������Բ��ᱻѹ����"bbbbbbbbbbbb" �� ��b12�� �����
	ע��ÿ�������������ж������Լ���λ�á�*/

	public static void main(String[] args) {
		char[] chars ={'a','b'};
		int n = compress(chars);
		System.out.println(n);
	}
    public static int compress(char[] chars) {
    	int i=0,t=0;
    	StringBuilder sb = new StringBuilder();
    	while(i<chars.length) {
    		t=i+1;
    		while(t<chars.length){
                if(chars[i]==chars[t])
                    t++;
            }
    		int len = t-i;
    		sb.append(chars[i]);
    		sb.append(len);
            i=t;
    	}
    	return sb.length();
    }
//����ָ�� anchor���ǵ�ǰ���������ַ�������ʼλ�á������Ҷ�ȡ��
//�������һ���ַ�������һ���ַ��뵱ǰ��ͬʱ���򵽴���������Ľ�β���ʹ� write 
//д��ѹ���Ľ����chars[anchor] Ϊ�ַ���read - anchor + 1 �������� 1��Ϊ���ȡ�
  

}
