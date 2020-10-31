package com.problem;

public class leetcode_283 {
	/*283. 移动零难度简单701给定一个数组 nums，
	 * 编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
	示例:
	输入: [0,1,0,3,12]
	输出: [1,3,12,0,0]

	说明:
	必须在原数组上操作，不能拷贝额外的数组。
	尽量减少操作次数。
	 * */

	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
	}
    public static void moveZeroes(int[] nums) {
    	for(int i=0;i<nums.length;i++) {
    		if(nums[i]==0) {
    			for(int j=i+1;j<nums.length;j++) {
    				if(nums[j]!=0) {
    					int temp = nums[i];
    					nums[i]=nums[j];
    					nums[j] = temp;
    					break;
    				}
    			}
    		}
    	}
    }
//         思路：从i=0开始遍历，当nums[i]==0时，j=i+1，找到第一个不等于0的数，
//         将nums[i],nums[j]交换，0就会跑到后面，并且顺序也没有改变。

}
