package com.problem;

public class leetcode_605 {
	
	/*
	 * 605. 种花问题
		假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
		给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
		示例 1:
		输入: flowerbed = [1,0,0,0,1], n = 1
		输出: True
		示例 2:
		输入: flowerbed = [1,0,0,0,1], n = 2
		输出: False*/

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
// 因为第一个和最后一个情况特殊，挑出来单独判断，若flowerbed[0]和flowerbed[1]都是0
// sum++，flowerbed[0]=1，给能种花的都赋值为1，以便之后的判断，然后从i=1开始判断，
// flowerbed[i] == 0 && flowerbed[i+1]==0 && flowerbed[i-1]==0，表示能种花，
// sum++,flowerbed[i]=1,遍历完之后，再判断最后一个元素，如果最后一个和二个都为0，
// sum++，最后判断，如果sum>=n,返回true    
}
