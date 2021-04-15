package 回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
//        for(int i=0;i<res.size();i++){
//            System.out.println(res.get(i));
//        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int len = nums.length;
        if(len==0){
            return res;
        }
        dfs1(nums,0,len,res,path);
        dfs2(nums,len-1,res,path);
        return res;
    }
    private static void dfs1(int[] nums,int begin,int len,List<List<Integer>> res,Deque<Integer> path){
        if(begin==len-1){
            res.add(new ArrayList<>(path));
            return;
        }
        path.addLast(nums[begin]);
        for(int i=begin;i<len;i++){
            dfs1(nums,i,len,res,path);
        }
        path.removeLast();
    }


    private static void dfs2(int[] nums,int begin,List<List<Integer>> res,Deque<Integer> path){
        if(begin<0){
            res.add(new ArrayList<>(path));
            return;
        }
        path.addLast(nums[begin]);
        for(int i=begin;i>=0;i--){
            dfs2(nums,i,res,path);
        }
        path.removeLast();
    }
}
