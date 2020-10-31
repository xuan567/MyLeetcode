package com.problem;

import java.util.HashMap;

public class leetcode_575 {
	
	/*
	 * 575. ���ǹ�
		����һ��ż�����ȵ����飬���в�ͬ�����ִ����Ų�ͬ������ǹ���ÿһ�����ִ���һ���ǹ�������Ҫ����Щ�ǹ�ƽ���ָ�һ���ܵܺ�һ�����á��������ÿ��Ի�õ�����ǹ�����������
		ʾ�� 1:
		����: candies = [1,1,2,2,3,3]
		���: 3
		����: һ��������������ǹ���ÿһ�ֶ���������
		���ŷ��䷽�������û��[1,2,3],�ܵ�Ҳ���[1,2,3]������ʹ���û���ǹ�����������ࡣ
		
		ʾ�� 2 :
		����: candies = [1,1,2,3]
		���: 2
		����: ���û���ǹ�[2,3],�ܻܵ���ǹ�[1,1]�����������ֲ�ͬ���ǹ���
		�ܵ�ֻ��һ�֡�����ʹ�����ÿ��Ի�õ��ǹ���������ࡣ*/

	public static void main(String[] args) {
		int[] candies = {1,1,2,3};
		int n = distributeCandies(candies);
		System.out.println(n);
	}
    public static int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<candies.length;i++) {
        	map.put(candies[i], map.getOrDefault(candies[i], 0)+1);
        }
        
        int n = map.size();
        int len = candies.length;
        int sum = 0;
        if(n>=len/2)
        	sum = len/2;
        else if(n < len/2) {
        	sum = n;
        }
        return sum;
    }
// ����һ����ϣ����¼�ܹ��ж��ٸ���ͬ�����֣����ǹ������࣬��Ϊ��������ƽ���֣�
// ÿ���˷ֵ����ǹ�����������һ�룬����ǹ�������>=�ǹ�������һ�룬�򷵻��ǹ���
// ����һ�룬���򷵻��ǹ�������   

}
