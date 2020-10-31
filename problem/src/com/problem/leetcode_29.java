package com.problem;

public class leetcode_29 {
	/*给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
	返回被除数 dividend 除以除数 divisor 得到的商。
	整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
	 
	 *示例 1:
		输入: dividend = 10, divisor = 3
		输出: 3
		解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
		
	示例 2:
		输入: dividend = 7, divisor = -3
		输出: -2
		解释: 7/-3 = truncate(-2.33333..) = -2
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
