package com.problem;

public class leetcode_29 {
	/*�������������������� dividend �ͳ��� divisor�������������Ҫ��ʹ�ó˷��������� mod �������
	���ر����� dividend ���Գ��� divisor �õ����̡�
	���������Ľ��Ӧ����ȥ��truncate����С�����֣����磺truncate(8.345) = 8 �Լ� truncate(-2.7335) = -2
	 
	 *ʾ�� 1:
		����: dividend = 10, divisor = 3
		���: 3
		����: 10/3 = truncate(3.33333..) = truncate(3) = 3
		
	ʾ�� 2:
		����: dividend = 7, divisor = -3
		���: -2
		����: 7/-3 = truncate(-2.33333..) = -2
	 *
	 */

	public static void main(String[] args) {
		int n = divide(10,3);
		System.out.println(n);

	}
	
    public static int divide(int dividend, int divisor) {
    	if(dividend ==Integer.MIN_VALUE&&divisor==-1)
    		return Integer.MAX_VALUE;
    	boolean isNegative = (dividend^divisor) <0 ?true:false;
    	dividend = dividend<0?dividend:-dividend;
    	divisor = divisor <0?divisor:-divisor;
    	int res = div(dividend,divisor);
    	return isNegative?-res:res;
    }
    
    public static int div(int dividend,int divisor) {
    	if(dividend  > divisor)
    		return 0;
    	int temp = divisor;
    	int count = 1;
    	while(temp+temp<0&&dividend<=temp+temp) {
    		temp+=temp;
    		count+=count;
    	}
    	return count+div(dividend-temp,divisor);
    }

}
