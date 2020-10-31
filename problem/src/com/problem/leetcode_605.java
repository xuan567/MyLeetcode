package com.problem;

public class leetcode_605 {
	
	/*
	 * 605. �ֻ�����
		��������һ���ܳ��Ļ�̳��һ���ֵؿ���ֲ�˻�����һ����ȴû�С����ǣ����ܲ�����ֲ�����ڵĵؿ��ϣ����ǻ�����ˮԴ�����߶�����ȥ��
		����һ����̳����ʾΪһ���������0��1������0��ʾû��ֲ����1��ʾ��ֲ�˻�������һ���� n ���ܷ��ڲ�������ֲ�������������� n �仨�����򷵻�True�������򷵻�False��
		ʾ�� 1:
		����: flowerbed = [1,0,0,0,1], n = 1
		���: True
		ʾ�� 2:
		����: flowerbed = [1,0,0,0,1], n = 2
		���: False*/

	public static void main(String[] args) {

	}
	
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int sum = 0;
        if(flowerbed.length == 1 &&flowerbed[0]==0 ){
            if(n<=1)
                return true;
            else
                return false;
        }

        if(flowerbed[0]==0 && flowerbed[1] ==0) {
    		flowerbed[0] = 1;
    		sum++;
    	}
    	int i=1;
    	while(i<flowerbed.length-1) {
    		if(flowerbed[i] == 0 && flowerbed[i+1]==0 && flowerbed[i-1]==0) {
    			flowerbed[i] = 1;
    			sum++;
    		}
    		i++;
    	}
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0){
            sum++;
        }
    	if(sum >= n) {
    		return true;
    	}else {
    		return false;
        }
    }
// ��Ϊ��һ�������һ��������⣬�����������жϣ���flowerbed[0]��flowerbed[1]����0
// sum++��flowerbed[0]=1�������ֻ��Ķ���ֵΪ1���Ա�֮����жϣ�Ȼ���i=1��ʼ�жϣ�
// flowerbed[i] == 0 && flowerbed[i+1]==0 && flowerbed[i-1]==0����ʾ���ֻ���
// sum++,flowerbed[i]=1,������֮�����ж����һ��Ԫ�أ�������һ���Ͷ�����Ϊ0��
// sum++������жϣ����sum>=n,����true    
}
