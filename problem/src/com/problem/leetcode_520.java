package com.problem;

public class leetcode_520 {
	/*
	 * 520. ����д��ĸ
		����һ�����ʣ�����Ҫ�жϵ��ʵĴ�дʹ���Ƿ���ȷ��
		���Ƕ��壬���������ʱ�����ʵĴ�д�÷�����ȷ�ģ�
		ȫ����ĸ���Ǵ�д������"USA"��
		������������ĸ�����Ǵ�д������"leetcode"��
		������ʲ�ֻ����һ����ĸ��ֻ������ĸ��д�� ���� "Google"��
		�������Ƕ����������û����ȷʹ�ô�д��ĸ��
		ʾ�� 1:
		����: "USA"
		���: True
		ʾ�� 2:
		����: "FlaG"
		���: False*/

	public static void main(String[] args) {
		
	}
    public boolean detectCapitalUse(String word) {
        if(Character.isUpperCase(word.charAt(0))) {
        	int l = 0;
        	int U = 0;
        	for(int i=1;i<word.length();i++) {
        		if(Character.isUpperCase(word.charAt(i)))
        			U++;
        		else
        			l++;
        	}
        	if(U==0&&l==word.length()-1)
        		return true;
        	else if(l==0 && U==word.length()-1)
        		return true;
        }
        else {
        	for(int i=1;i<word.length();i++) {
        		if(Character.isUpperCase(word.charAt(i))) {
        			return false;
        		}
        	}
        	return true;
        }
        return false;
    }
// ���жϵ�һ����ĸ�Ĵ�Сд�������������1.��д���жϣ����֮�����ĸ���Ǵ�д������true
// ֮�����ĸ����Сд������true�����򷵻�false��2��Сд���ж����֮����Сд������true��
// ���򷵻�true��    
    
}
