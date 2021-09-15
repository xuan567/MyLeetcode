package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode47全排列2 {
    /*
    给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    示例 1：
    输入：nums = [1,1,2]
    输出：
    [[1,1,2],
     [1,2,1],
     [2,1,1]]

    示例 2：
    输入：nums = [1,2,3]
    输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    * */

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        dfs(nums,0,n,used,path,res);
        return res;
    }

    public void dfs(int[] nums,int depth,int len,boolean[] used,List<Integer> path,List<List<Integer>> res){
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(used[i]){
                continue;
            }

            if(i>0 && nums[i]==nums[i-1] && used[i-1]==false){
                continue;
            }
            path.add(nums[i]);
            used[i]=true;
            dfs(nums,depth+1,len,used,path,res);
            used[i]=false;
            path.remove(path.size()-1);
        }
    }

}
