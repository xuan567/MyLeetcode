package 剑指Offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 剑指offer03数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
       Arrays.sort(nums);
       int temp = 0;
       for(int i=0;i<nums.length-1;i++){
           if(nums[i] == nums[i+1]){
               temp = nums[i];
               break;
           }
       }
       return temp;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> hashset = new HashSet<Integer>();
        for (int num: nums){
            if(hashset.contains(num)){
                return num;
            }
            hashset.add(num);
        }
        return -1;
    }

    public int findRepeatNumber2(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]==i){
                continue;
            }
            if(nums[nums[i]] == nums[i]) {
                return nums[i];
            }
            int temp = nums[i];
            nums[temp] = nums[i];
            nums[i] = temp;
        }
        return -1;
    }

}
