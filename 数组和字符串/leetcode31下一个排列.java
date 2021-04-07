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

    //1.希望下一个数比当前数大，所以需要将后面的‘大数’与前面的‘小数’交换，例如123456就变成123465
    //2.还希望下一个数增加的幅度尽可能小：
    //   1.在尽可能靠右的低位进行交换，需要从后向前找
    //   2.将一个尽可能小的‘大数’与前面的‘小数’交换，如‘123465’ 应该换为 ‘123546’
    //   3.将‘大数’换到前面后，需要将大数后面所有的数重置为升序，升序排列就是最小的排列

    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if(i>=0){
            int j = nums.length-1;
            while(nums[j]<=nums[i] && j>i){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums,i+1);
    }

    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums,int i){
        int j = nums.length-1;
        for(;i<j;i++,j--){
            swap(nums,i,j);
        }
    }

}
