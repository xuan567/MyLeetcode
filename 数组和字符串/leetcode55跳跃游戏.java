package 数组和字符串;

import java.util.HashMap;
import java.util.List;

public class leetcode55跳跃游戏 {
    /*
    给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
    数组中的每个元素代表你在该位置可以跳跃的最大长度。
    判断你是否能够到达最后一个下标。

    示例1：
    输入：nums = [2,3,1,1,4]
    输出：true
    解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

    示例2：
    输入：nums = [3,2,1,0,4]
    输出：false
    解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

    * */

    //如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
    //对每一个能作为起跳点的格子都尝试一次，把能跳到最远的距离不断更新，如果最远距离>=最后一个坐标
    //说明可以跳到最后一个，直接返回true
    //遍历完，说明最远距离不能到达最后一个格子，返回false

    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<=max;i++){
            int temp = nums[i] + i;
            max = Math.max(temp,max);
            if(max>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
