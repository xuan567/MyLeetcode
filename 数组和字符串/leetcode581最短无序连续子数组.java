package 数组和字符串;

import java.util.Arrays;

public class leetcode581最短无序连续子数组 {
    /*
    给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
    如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    请你找出符合题意的 最短 子数组，并输出它的长度。

    示例 1：
    输入：nums = [2,6,4,8,10,9,15]
    输出：5
    解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

    示例 2：
    输入：nums = [1,2,3,4]
    输出：0

    示例 3：
    输入：nums = [1]
    输出：0

    * */

    //题解：
    //将nums数组克隆给arr，然后将nums数组排序
    //比较nums和arr，找到不同的开始下标和结束下标
    //然后两个下标的差


    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(nums);
        int i,j;
        for(i=0;i<nums.length;i++) {
            if(nums[i]!=arr[i]){
                break;
            }
        }
        if(i==nums.length){
            return 0;
        }
        for(j=nums.length-1;j>=0;j--){
            if(nums[j]!=arr[j]){
                break;
            }
        }
        return j-i+1;

    }

}
