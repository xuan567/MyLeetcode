package 数组和字符串;

import java.lang.reflect.Array;
import java.util.Arrays;

public class leetcode26删除排序数组中的重复项 {
    /*
    * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
        示例1:
        给定数组 nums = [1,1,2],
        函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
        你不需要考虑数组中超出新长度后面的元素。

        示例2:
        给定 nums = [0,0,1,1,1,2,2,3,3,4],
        函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
        你不需要考虑数组中超出新长度后面的元素。
        */

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        nums = removeDuplicates3(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static int removeDuplicates1(int[] nums) {
        int index=0;
        int i =0;
        while(i<nums.length) {
            if(i==0){
                nums[index++]=nums[i];
                i++;
            }else{
                if(nums[i]!=nums[index-1]){
                    nums[index++] = nums[i];
                }else{
                    i++;
                }
            }
        }
        return index;
    }
    public static int removeDuplicates2(int[] nums){
        int i=0,j;
        if(nums==null || nums.length==0){
            return 0;
        }
        for(j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static int[] removeDuplicates3(int[] nums){
        if(nums.length==0 || nums==null){
            return null;
        }
        int i=0,j;
        for(j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return Arrays.copyOf(nums,i+1);
    }
    //遍历这个数组，因为是非递减的顺序表，下标i记录，j遍历，i=0，j=1，当nums[i]!=nums[j]，i++，j++，
    //当nums[i]==nums[j]时，i不变，j++，这样重复的元素不会被记录，最后返回Arrays.copyOf(nums,i+1)，
    //返回新数组的前i+1个元素，时间复杂度时O(n),空间复杂度是O(1);

    public int removeDuplicates(int[] nums) {
        //如果数组的长度等于0或1，没有重复的元素，直接返回n
        //设置一个下表j，遍历数组，i从1开始，如果该元素和上一个元素不一样
        //nums[j++]=nums[i]，如果不一样，则只有i++，j不变，实现在原地删除了
        //重复元素，最后直接返回j；
        int n=nums.length;
        if(n==0 || n==1){
            return n;
        }
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}
