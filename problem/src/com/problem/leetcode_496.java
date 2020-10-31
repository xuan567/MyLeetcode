package com.problem;

public class leetcode_496 {
	/*
	 * 496. ��һ������Ԫ�� I�Ѷȼ�263�������� û���ظ�Ԫ�� ������ nums1 �� nums2 ��
	 * ����nums1 �� nums2 ���Ӽ����ҵ� nums1 ��ÿ��Ԫ���� nums2 �е���һ��������ֵ��
		nums1 ������ x ����һ������Ԫ����ָ x �� nums2 �ж�Ӧλ�õ��ұߵĵ�һ���� x ���Ԫ�ء�
		��������ڣ���Ӧλ����� -1 ��
		
		ʾ�� 1:
		����: nums1 = [4,1,2], nums2 = [1,3,4,2].
		���: [-1,3,-1]
		����:
	    ����num1�е�����4�����޷��ڵڶ����������ҵ���һ����������֣������� -1��
	    ����num1�е�����1���ڶ�������������1�ұߵ���һ���ϴ������� 3��
	    ����num1�е�����2���ڶ���������û����һ����������֣������� -1��*/

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] nums3 = nextGreaterElement(nums1,nums2);
		for (int i : nums3) {
			System.out.print(i + " ");
		}
	}
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int[] nums = new int[nums1.length];
    	int k=0;
    	for(int i=0;i<nums1.length;i++) {
    		nums[k++] = find(nums1[i],nums2);
    	}
    	return nums;
    }
    public static int find(int n,int[] nums) {
    	int i;
    	for(i=0;i<nums.length;i++) {
    		if(nums[i]==n)
    			break;
    	}
    	for(;i<nums.length;i++) {
    		if(nums[i]>n)
    			return nums[i];
    	}
    	return -1;
    }
//����nums1��ÿ�α�����nums1[i]��nums2���뵽�����find�������nums2���ҵ���Ԫ����
//��λ�ã��Ӹ�λ�������ң����ҵ���һ����nums[i]���Ԫ�أ�ֱ�ӷ��أ������껹û�ҵ�ʱ��
//����-1��    
}
