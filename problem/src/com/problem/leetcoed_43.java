package com.problem;

public class leetcoed_43 {
	/*
	   * �����������ַ�����ʽ��ʾ�ķǸ����� num1 �� num2
	   * ���� num1 �� num2 �ĳ˻������ǵĳ˻�Ҳ��ʾΪ�ַ�����ʽ��
		ʾ�� 1:
		����: num1 = "2", num2 = "3"
		���: "6"
		
		ʾ�� 2:
		����: num1 = "123", num2 = "456"
		���: "56088"
*/

	public static void main(String[] args) {
		String num1="123";
		String num2="456";
		String s = multiply(num1,num2);
		System.out.println(s);
	}
	
    public static String multiply(String num1, String num2) {
    	if(num1.equals("0")||num2.equals("0"))
    		return "0";
    	int[] num = new int[num1.length()+num2.length()];
    	for(int i = num1.length()-1;i>=0;i--) {
    		int n = num1.charAt(i)-'0';
    		for(int j = num2.length()-1;j>=0;j--) {
    			int m = num2.charAt(j)-'0';
    			int sum = num[i+j+1]+n*m;
    			num[i+j+1] = sum%10;
    			num[i+j]+=sum/10;
    		}
    	}
    	StringBuilder result = new StringBuilder();
    	for(int i=0;i<num.length;i++) {
    		if(i==0&&num[i]==0) continue;
    		result.append(num[i]);
    	}
    	return result.toString();
    }

}
