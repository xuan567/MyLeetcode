package 数组和字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode15三数之和 {
    /*给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
    使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    注意：答案中不可以包含重复的三元组。

    示例 1：
    输入：nums = [-1,0,1,2,-1,-4]
    输出：[[-1,-1,2],[-1,0,1]]

    示例 2：
    输入：nums = []
    输出：[]

    示例 3：
    输入：nums = [0]
    输出：[]

     */

    //题解：将数组从小到大排序。
    //如果第一个数字大于0，直接返回空list，将整个数组遍历一遍，遇到相同的跳过
    // 定义双指针，L=i+1,R=len-1,找出所有加起来等于0的组合添加到lists中
    //其中排除相同的字符，如果遇到相同的字符，L坐标++，R坐标--，遍历一遍直到L<R,

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;++i){
            if(nums[i]>0){
                return lists;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int curr = nums[i];
            int L = i+1;
            int R = n-1;
            while(L<R) {
                int temp = curr + nums[L] + nums[R];
                if (temp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L] == nums[L + 1]) {
                        ++L;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        --R;
                    }
                    ++L;
                    --R;
                } else if (temp > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return lists;
    }
}
