package 数组和字符串;

public class leetcode485最大连续1的个数 {
    /*
    * 给定一个二进制数组， 计算其中最大连续1的个数。
        示例 1:
        输入: [1,1,0,1,1,1]
        输出: 3
        解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
        注意：

        输入的数组只包含0 和1。
        输入数组的长度是正整数，且不超过 10,000。*/

    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int i=0;
        int ans=0;
        while(i<nums.length){
            if(nums[i]==1){
                count++;
            }else if(nums[i]==0){
                count=0;
                ans = Math.max(count,ans);
            }
        }
        return ans = Math.max(count,ans);
    }
}
