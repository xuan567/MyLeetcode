package 栈;

import java.util.ArrayList;
import java.util.List;

public class leetcode22括号生成 {
    /*
    22. 括号生成
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。

    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]

    示例 2：
    输入：n = 1
    输出：["()"]
    * */

    //题解：深度优先遍历，由于字符串的特殊性，产生一次拼接都生成的对象，因此无需回溯
    //1.当左右括号都大于0个可以使用的时候才产生分支
    //2.产生左分支时，只看当前是否还有左括号可以使用
    //3.产生右分支时，受到左分支的限制，右边剩余括号的数量一定得严格大于左边剩余数量的时候才能产生分支
    //4.在左边右边剩余括号的数都等于0的时候结算

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    public void dfs(String curStr,int left,int right,List<String> res){
        if(left==0 && right==0){
            res.add(curStr);
            return;
        }
        if(left>right){
            return;
        }

        if(left>0){
            dfs(curStr+'(',left-1,right,res);
        }
        if(right>0) {
            dfs(curStr+')',left,right-1,res);
        }

    }

}
