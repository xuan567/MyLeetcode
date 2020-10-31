package com.problem;

public class letcode_31 {
	/*31. ��һ�������Ѷ��е�613ʵ�ֻ�ȡ��һ�����еĺ�����
	 	* �㷨��Ҫ���������������������г��ֵ�������һ����������С�
		�����������һ����������У��������������г���С�����У����������У���
		����ԭ���޸ģ�ֻ����ʹ�ö��ⳣ���ռ䡣
		������һЩ���ӣ�����λ������У�����Ӧ���λ���Ҳ��С�
		1,2,3 �� 1,3,2
		3,2,1 �� 1,2,3
		1,1,5 �� 1,5,1
	 */

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		nextPermutation(nums);
		for (int i : nums) {
			System.out.print(i);
		}
	}
    public static void nextPermutation(int[] nums) {
    	int i=nums.length-2;
    	while(i>=0&&nums[i]>=nums[i+1]) {
    		i--;
    	}
    	if(i>=0) {
    		int j=nums.length-1;
    		while(j>=0&&nums[j]<=nums[i]) {
    			j--;
    		}
    		swap(nums,i,j);
    	}
    	reverse(nums,i+1);
    }
    public static void swap(int[] nums,int i,int j) {
    	int tmp = nums[i];
    	nums[i]=nums[j];
    	nums[j]= tmp;
    }
    
    public static void reverse(int[] nums,int start) {
    	int i =start;
    	int j = nums.length-1;
    	while(i<j) {
    		swap(nums,i,j);
    		i++;
    		j--;
    	}
    }
    
//˼·�����ұ߱��������nums[i]>[i+1]��˵��nums[i]�ұ߰��ս������У������ġ�
//��nums[i]<nums[i+1]���ҵ�nums[i]�ұߵ�һ������������ֲ��������������ӽ�ԭ���ֵģ�
//��Ϊ�ұ߰��ս������У�����󣬴�ʱ��nums[i]��nums[length-1]��ת���͵õ���ԭ���ִ�
//������ӽ�ԭ���ֵ�����
   

}
