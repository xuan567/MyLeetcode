package com.problem;

public class leetcode_283 {
	/*283. �ƶ����Ѷȼ�701����һ������ nums��
	 * ��дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��
	ʾ��:
	����: [0,1,0,3,12]
	���: [1,3,12,0,0]

	˵��:
	������ԭ�����ϲ��������ܿ�����������顣
	�������ٲ���������
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
//         ˼·����i=0��ʼ��������nums[i]==0ʱ��j=i+1���ҵ���һ��������0������
//         ��nums[i],nums[j]������0�ͻ��ܵ����棬����˳��Ҳû�иı䡣

}
