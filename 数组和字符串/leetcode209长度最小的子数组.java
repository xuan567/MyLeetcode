package 数组和字符串;

public class leetcode209长度最小的子数组 {
    /*
    * 209. 长度最小的子数组
      给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，
      并返回其长度。如果不存在符合条件的子数组，返回 0。

        示例：
        输入：s = 7, nums = [2,3,1,2,4,3]
        输出：2
        解释：子数组 [4,3] 是该条件下的长度最小的子数组。*/

    public static void main(String[] args) {
        int s=7;
        int[] nums = {2,3,1,2,4,3};
        int x;
        x=minSubArrayLen1(s,nums);
        System.out.println(x);
    }

    //暴力解法,时间复杂度O(n2),空间复杂度O(1);

    public static int minSubArrayLen1(int s, int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum = nums[i];
            if(sum>=s){
                return 1;
            }
            for(int j=i+1;j<nums.length;j++){
                sum+=nums[j];
                if(sum>=s){
                    ans=Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        if(ans==Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
    //滑动窗口
    //low指针不动，high指针右移，直到sum >= s，然后low指针右移，若sum还是>=s,记录min，
    //知道sum<s，然后再继续右移right，重复此过程，知道right>=nums.leghth;

    public static int minSubArrayLen2(int s, int[] nums) {
        int low=0,high=0,sum=0,min=Integer.MAX_VALUE;
        while(high<nums.length){
            sum+=nums[high++];
            while(sum>=s){
                min = Math.min(min,high-low);
                sum-=nums[low++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }


}
