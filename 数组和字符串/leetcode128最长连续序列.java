package 数组和字符串;

import java.util.Arrays;
import java.util.HashSet;

public class leetcode128最长连续序列 {
   /*
   * 128. 最长连续序列
        给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
        进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？

        示例 1：
        输入：nums = [100,4,200,1,3,2]
        输出：4
        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

        示例 2：
        输入：nums = [0,3,7,2,5,8,4,6,0,1]
        输出：9
   * */

   public static void main(String[] args) {
       int nums[] = {0,3,7,2,5,8,4,6,0,1};
       int max = longestConsecutive(nums);
       System.out.println(max);
   }

   //解法1：排序，然后找出最长连续的子串
   public static int longestConsecutive(int[] nums) {
       if(nums==null || nums.length==0){
           return 0;
       }
       int max = 1;
       int ans = 1;
       Arrays.sort(nums);
       for(int i=1;i<nums.length;i++){
           if(nums[i]-nums[i-1]==1){
               ans++;
           }else if(nums[i]-nums[i-1]==0){
               ans = ans;
           }else{
               max = Math.max(ans,max);
               ans = 1;
           }
       }
       return Math.max(ans,max);
   }

   //解法2：HashSet
   //时间复杂度：O(n)O(n)，其中 nn 为数组的长度。具体分析已在上面正文中给出。
   //空间复杂度：O(n)O(n)。哈希表存储数组中所有的数需要 O(n)O(n) 的空间。

    public int longestConsecutive2(int[] nums){
       HashSet<Integer> hs = new HashSet<>();
       for(int num:nums){
           hs.add(num);
       }
       int max = 0;
       for(int num:hs){
           if(!hs.contains(num-1)){
               int currentNum = num;
               int ans = 1;
               while(hs.contains(currentNum+1)){
                   currentNum+=1;
                   ans++;
               }
               max = Math.max(max,ans);
           }
       }
       return max;
   }
}
