package com.problem;

public class leetcode_485 {
	/*
	 * 485. �������1�ĸ����Ѷȼ�120����һ�����������飬 ���������������1�ĸ�����
		
		ʾ�� 1:
		����: [1,1,0,1,1,1]
		���: 3
		����: ��ͷ����λ��������λ��������1�������������1�ĸ����� 3.*/

	public static void main(String[] args) {
		int[] nums = {1,1,0,1,1,1};
		int n = findMaxConsecutiveOnes(nums);
		System.out.println(n);

	}
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0,right = 0,ans = 0;
        while(left<nums.length){
            if(nums[left] == 1){
            	int i = left;
            	for(;i<nums.length && nums[i] ==1;i++) {
            	}
            	ans = Math.max(ans, i-left);
            	left = i+1;
            }else {
            	left++;
            }
        }
        return ans;
    }
//��ͷ�ң������Ԫ����1�����������ѭ����i=left�����nums[i]==1����i++;
//�������1�����Ѿ������꣬����ѭ����ans = Math.max(ans, i-left);
//�õ�����������1    
}
