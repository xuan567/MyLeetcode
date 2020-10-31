package com.problem;

public class letcode_31 {
	/*31. 下一个排列难度中等613实现获取下一个排列的函数，
	 	* 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
		如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
		必须原地修改，只允许使用额外常数空间。
		以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
		1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1
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
    
//思路：从右边遍历，如果nums[i]>[i+1]，说明nums[i]右边按照降序排列，是最大的。
//当nums[i]<nums[i+1]，找到nums[i]右边第一个比他大的数字并交换，这个是最接近原数字的，
//因为右边按照降序排列，是最大，此时将nums[i]到nums[length-1]反转，就得到比原数字大
//并且最接近原数字的数。
   

}
