package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode78子集 {
    /*
    * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

        示例 1：
        输入：nums = [1,2,3]
        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

        示例 2：
        输入：nums = [0]
        输出：[[],[0]]

    * */

    //解法：递归
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0,n,nums,res,path);
        return res;
    }

    private void dfs(int begin,int len,int[] nums,List<List<Integer>> res,List<Integer> path){
        res.add(new ArrayList<>(path));
        for(int i=begin;i<len;i++){
            path.add(nums[i]);
            dfs(i+1,len,nums,res,path);
            path.remove(path.size()-1);
        }
    }
}
