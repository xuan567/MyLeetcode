package 数组和字符串;

import java.util.Arrays;

public class leetcode31下一个排列 {
    /*
    实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    必须原地修改，只允许使用额外常数空间。

    示例 1：
    输入：nums = [1,2,3]
    输出：[1,3,2]

    示例 2：
    输入：nums = [3,2,1]
    输出：[1,2,3]

    示例 3：
    输入：nums = [1,1,5]
    输出：[1,5,1]

    示例 4：
    输入：nums = [1]
    输出：[1]

    * */

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;

        if(n==0 || n==1) {
            return;
        }else {
            for (i = 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    break;
                }
            }
            if (i == n - 1) {
                nums = reverse(nums);
            }else{
                int t = nums[i];
                nums[i-1] = nums[i];
                nums[i] = t;
            }
            return;
        }
    }

    public int[] reverse(int[] nums){
        int n = nums.length;
        int[] nums1 = new int[n];
        for(int i=n-1,j=0;i>=0;i--,j++){
            nums1[j] = nums[i];
        }
        return nums1;
    }

}
