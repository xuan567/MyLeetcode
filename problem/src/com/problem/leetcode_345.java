package com.problem;

public class leetcode_345 {
	/*345. ��ת�ַ����е�Ԫ����ĸ�Ѷȼ�112��дһ�����������ַ�����Ϊ���룬��ת���ַ����е�Ԫ����ĸ��
	ʾ�� 1��	
	���룺"hello"
	�����"holle"
	
	ʾ�� 2��
	���룺"leetcode"
	�����"leotcede"*/

	public static void main(String[] args) {
		String s = "aA";
		String t = reverseVowels(s);
		System.out.println(t);

	}
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        
        int i=0,j=s.length()-1;
        while(i<j) {
        	if((arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='O'||arr[i]=='I'||arr[i]=='U')&&
            		(arr[j]=='a'||arr[j]=='e'||arr[j]=='i'||arr[j]=='o'||arr[j]=='u'||arr[j]=='A'||arr[j]=='E'||arr[j]=='I'||arr[j]=='O'||arr[j]=='U')) {
            		char c = arr[i];
            		arr[i]=arr[j];
            		arr[j]=c;
            		i++;
            		j--;
            	}
        	else if((arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='O'||arr[i]=='I'||arr[i]=='U')&&
            		(arr[j]!='a'&&arr[j]!='e'&&arr[j]!='i'&&arr[j]!='o'&&arr[j]!='u'&&arr[j]!='A'&&arr[j]!='E'&&arr[j]!='O'&&arr[j]!='I'&&arr[j]!='U')) {
        		j--;
        	}else if((arr[j]=='a'||arr[j]=='e'||arr[j]=='i'||arr[j]=='o'||arr[j]=='u'||arr[j]=='A'||arr[j]=='E'||arr[j]=='I'||arr[j]=='O'||arr[j]=='U')&&
            		(arr[i]!='a'&&arr[i]!='e'&&arr[i]!='i'&&arr[i]!='o'&&arr[i]!='u'&&arr[i]!='A'&&arr[i]!='E'&&arr[i]!='I'&&arr[i]!='O'&&arr[i]!='U')) {
        		i++;
        	}else {
        		i++;
        		j--;
        	}
        }
        StringBuffer sb = new StringBuffer();
        for(i=0;i<arr.length;i++)
        	sb.append(arr[i]);
        return sb.toString();
    }
/* ���ַ���ת�������� i=0,j=arr.length-1;
 * 1.arr[i]��arr[j]����Ԫ����ĸ��������i++��j--��
 * 2.arr[i]��,arr[j]����,i���䣬j--��
 * 3.arr[i]����,arr[j]��,i++��j���䣻
 * ��i>j������ѭ��������StringBuilder��sb.append(arr[i]),sb.toString();
 */
   

}
