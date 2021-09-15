package 链表;

import java.util.Arrays;
import java.util.HashMap;

public class leetcode169多数元素 {
    /*
    给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现
    次数大于n/2的元素。
    你可以假设数组是非空的，并且给定的数组总是存在多数元素。

    示例1：
    输入：[3,2,3]
    输出：3

    示例2：
    输入：[2,2,1,1,1,2,2]
    输出：2
    * */

    //题解：
    //暴力：先将数组遍历一遍，定义一个哈希表，将数组中出现的元素和出现的次数对应
    //的存到哈希表中，之后遍历哈希表，找到出现次数大于n/2的元素

    public int majorityElement(int[] nums) {
        int temp=0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Integer key : map.keySet()){
            if(map.get(key)>(nums.length/2)){
                temp = key;
                break;
            }
        }
        return temp;
    }

    //排序
    public int majorityElement2(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

}
