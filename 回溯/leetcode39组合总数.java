package 回溯;

import java.lang.reflect.Array;
import java.util.*;

public class leetcode39组合总数 {
        /*
        给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
        candidates中的数字可以无限制重复被选取。

        说明：
        所有数字（包括target）都是正整数。
        解集不能包含重复的组合。

        示例1：
        输入：candidates = [2,3,6,7], target = 7,
        所求解集为：
        [
          [7],
          [2,2,3]
        ]

        示例2：
        输入：candidates = [2,3,5], target = 8,
        所求解集为：
        [
         [2,2,2,2],
         [2,3,3],
         [3,5]
        ]

        * */


    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        if(len==0){
            return res;
        }
        dfs1(candidates,0,target,len,res,path);
        return res;
    }

    private void dfs1(int[] candidates,int begin,int target,int len,List<List<Integer>> res,Deque<Integer> path){
        if(target<0){
            return;
        }
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=begin;i<len;i++){
            path.addLast(candidates[i]);
            dfs1(candidates,i,target-candidates[i],len,res,path);
            path.removeLast();
        }
    }

    //优化

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        Arrays.sort(candidates);
        if(len==0){
            return res;
        }
        dfs2(candidates,0,target,len,path,res);
        return res;
    }
    private void dfs2(int[] candidates, int begin, int target,int len,Deque<Integer> path,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=begin;i<len;i++){
            if(target-candidates[i]<0){
                break;
            }
            path.addLast(candidates[i]);
            dfs2(candidates,i,target-candidates[i],len,path,res);
            path.removeLast();
        }
    }
}
