package 回溯;

import java.util.*;

public class leetcode46全排列 {
    /*
    给定一个 没有重复 数字的序列，返回其所有可能的全排列。

    示例:
    输入: [1,2,3]
    输出:
    [
      [1,2,3],
      [1,3,2],
      [2,1,3],
      [2,3,1],
      [3,1,2],
      [3,2,1]
    ]
        * */

//    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        List<List<Integer>> res = permute(nums);
//        System.out.println(res);
////        for(int i=0;i<res.size();i++){
////            System.out.println(res.get(i));
////        }
//    }

    public  List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len==0){
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums,len,0,res,used,path);
        return res;
    }

    private void dfs(int[] nums,int len,int depth,List<List<Integer>> res,boolean[] used,List<Integer> path){
        if(depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                dfs(nums,len,depth+1,res,used,path);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }

}
